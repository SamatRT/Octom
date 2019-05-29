package com.example.user.octom;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.BackingStoreException;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MetronomeActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private MediaPlayer player;

    int MPlayerResource = R.raw.metronomesound;

    Handler handler = new Handler();
    boolean check = false;
    boolean flag = false;

    EditText TickSpeed;

    Button BackButton, StartButton;

    Button btn_Plus, btn_Minus;

    int BeatPerMinSeconds;

    int Ticks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metronome);

        ButterKnife.bind(this);

        BackButton= (Button) findViewById(R.id.MetronomeBackButton);

        StartButton = (Button) findViewById(R.id.startMetronome);

        TickSpeed = (EditText) findViewById(R.id.tickSpeed);

        btn_Minus = (Button) findViewById(R.id.btn_Minus);

        btn_Plus = (Button) findViewById(R.id.btn_Plus);

        BeatPerMinSeconds = Integer.parseInt(TickSpeed.getText().toString());

        initializeMediaPlayer();


    }

    @OnClick(R.id.startMetronome)
    void onClick(Button button) {

        try {
            if (!check) {
                button.setBackgroundResource(R.drawable.stop);
                check = !check;
                initializeMediaPlayer();
                player.start();
                flag = false;
                TickSpeed.setEnabled(false);
                TickSpeed.setCursorVisible(false);
            } else {
                button.setBackgroundResource(R.drawable.play);
                check = !check;
                player.stop();
                flag = true;
                TickSpeed.setEnabled(true);
                TickSpeed.setCursorVisible(true);
            }
        } catch (Exception e) {
            Log.e("TAG", "", e);
        }

    }

    public void MetronomeBackButtonClick(View view)
    {
        check = !check;
        player.stop();
        flag = true;
        startActivity(new Intent(MetronomeActivity.this, MainActivity.class));
    }

    public void PlusBtnClick(View view){
        int score = Integer.parseInt(TickSpeed.getText().toString());
        score++;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(score);
        String strI = sb.toString();
        TickSpeed.setText(strI);
    }

    public void MinusBtnClick(View view){
        int score = Integer.parseInt(TickSpeed.getText().toString());
        score--;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(score);
        String strI = sb.toString();
        TickSpeed.setText(strI);
    }




    private void initializeMediaPlayer()
    {
                BeatPerMinSeconds = Integer.parseInt(TickSpeed.getText().toString());
                Ticks = Math.round((60 / BeatPerMinSeconds) * 1000);
                player = MediaPlayer.create(this, MPlayerResource);
                player.setOnCompletionListener(this);
        }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.e("TAG", "OK");
        handler.postDelayed(runnable, Ticks);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (!flag) {
                player.release();
                initializeMediaPlayer();
                player.start();
            }

        }
    };

}
