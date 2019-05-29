package com.example.user.octom;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommonTabs extends Fragment {

    StringBuffer stringBufferSongCuplet = new StringBuffer();
    PDFView pdfView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String PrimeCupletCommon = sharedPreferences.getString("cuplet", "");

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_common_tabs, container, false);

        pdfView = rootView.findViewById(R.id.pdfView);
        pdfView.fromAsset(PrimeCupletCommon).load();

//        TextView SongText;
//        SongText = (TextView) rootView.findViewById(R.id.SongText);
//
//        try {
//            InputStream is = getResources().openRawResource(PrimeCupletCommon);
//            InputStreamReader reader = new InputStreamReader(is);
//            BufferedReader buffer = new BufferedReader(reader);
//            String lines;
//            while ((lines = buffer.readLine()) != null) {
//                stringBufferSongCuplet.append(lines + "\n");
//            }
//            SongText.setText(stringBufferSongCuplet.toString());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }



        return rootView;

    }








}
