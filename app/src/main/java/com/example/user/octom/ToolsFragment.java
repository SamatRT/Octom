package com.example.user.octom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ToolsFragment extends Fragment  implements View.OnClickListener{

    Button btn_Metronom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools, container, false);

        btn_Metronom = (Button) view.findViewById(R.id.btnToolsMetronome);

        btn_Metronom.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnToolsMetronome:
                Intent intent1 = new Intent("android.intent.action.MetronomeActivity");
                startActivity(intent1);
                break;
        }
    }
}
