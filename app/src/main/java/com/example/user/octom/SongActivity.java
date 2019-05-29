package com.example.user.octom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class SongActivity extends AppCompatActivity implements View.OnClickListener {

    Button playBtn;
    Button CloseTintBtn;
    Button Back;
    Button Tint;
    Button Vid_of_Song;
    public SeekBar positionBar;
    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;
    public MediaPlayer mp;
    int totalTime;
    String TintSource;
    private BottomSheetDialog mBottomSheetDialog;
    boolean Vid_of_song = true;
    int MP3SourcePlus;
    int MP3ourceMinus;

    TextView TintText;

    private ViewPager pager;
    private PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        List<Fragment> list = new ArrayList<>();
        list.add(new CommonTabs());
        list.add(new TabsNetworkFragment());

        mBottomSheetDialog = new BottomSheetDialog(SongActivity.this);

        pager = findViewById(R.id.pager);
        pagerAdapter = new SwitcherAdaptor(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        MP3SourcePlus = sharedPreferences.getInt("MP3SourcePlus", 0);
        MP3ourceMinus = sharedPreferences.getInt("MP3SourceMinus", 0);
        TintSource = sharedPreferences.getString("TintSource", "");

        playBtn = (Button) findViewById(R.id.playBtn);
        Back = (Button) findViewById(R.id.returnButton);
        Tint = (Button) findViewById(R.id.Tint);
        Vid_of_Song = (Button) findViewById(R.id.vid_Btn);

        if(MP3SourcePlus==MP3ourceMinus){
            Vid_of_Song.setEnabled(false);
            Vid_of_Song.setBackgroundResource(R.drawable.ic_search_black_24dp);
        }

        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);

        Back.setOnClickListener(this);
        Tint.setOnClickListener(this);

        mp = MediaPlayer.create(this, MP3SourcePlus);
        mp.setLooping(false);

        mp.seekTo(0);
        totalTime = mp.getDuration();

        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mp.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null) {
                    try {

                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentPosition = msg.what;

            positionBar.setProgress(currentPosition);


            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = createTimeLabel(totalTime - currentPosition);
            remainingTimeLabel.setText("- " + remainingTime);
        }
    };

    public String createTimeLabel(int time) {

        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) {
            timeLabel += "0";
        }
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnOnClick(View view) {

        if (!mp.isPlaying()) {
            //stopping
            mp.start();
            playBtn.setBackgroundResource(R.drawable.stop);
        } else {
            //playing
            mp.pause();
            playBtn.setBackgroundResource(R.drawable.play);
        }

    }

    public void vid_BtnOnClick(View view){

        if(Vid_of_song==true){
            Vid_of_song = false;
            playBtn.setBackgroundResource(R.drawable.play);
            Vid_of_Song.setBackgroundResource(R.drawable.elder_scrolls_image);
            mp.stop();
            mp = MediaPlayer.create(this, MP3ourceMinus);
            mp.setLooping(false);
        }
        else{
            Vid_of_song = true;
            playBtn.setBackgroundResource(R.drawable.play);
            Vid_of_Song.setBackgroundResource(R.drawable.ic_home_black_24dp);
            mp.stop();
            mp = MediaPlayer.create(this, MP3SourcePlus);
            mp.setLooping(false);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.returnButton:

                startActivity(new Intent(SongActivity.this, MainActivity.class));

                break;

            case R.id.Tint:

                openBottomSheetDiallog();

            break;
        }
    }

    private void openBottomSheetDiallog() {
        System.out.println("opened");
        View dialogLayout = getLayoutInflater().inflate(R.layout.layout_bottom_sheet_dialog, null);
        mBottomSheetDialog.setContentView(dialogLayout);
        mBottomSheetDialog.show();

        TintText = (TextView) dialogLayout.findViewById(R.id.Bottom_sheet_text);

        TintText.setText("Играй аккуратно"+"\n"+"И все будет хорошо");

        CloseTintBtn = dialogLayout.findViewById(R.id.Close_bottom_sheet);
        CloseTintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
            }
        });

    }

}
