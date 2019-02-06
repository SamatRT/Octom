package com.example.user.octom;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView recyclerView = (RecyclerView)  view.findViewById(R.id.rv);
        SongsAdapter songsAdapter = new SongsAdapter();
        recyclerView.setAdapter(songsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        songs.add(new songs(R.drawable.stop , "Song1", "Samat", "angel_cuplet.txt.txt", "text1", "text1", "http://docs.google.com/uc?export=download&id=10Gu9XM3Nu9crVo_O6-HsTynW1u_0supZ"));
        songs.add(new songs(R.drawable.stop , "Song2", "Kiril", "text1.tx", "text1", "text1", "http://docs.google.com/uc?export=download&id=10Gu9XM3Nu9crVo_O6-HsTynW1u_0supZ"));
        songs.add(new songs(R.drawable.stop , "Song3", "Vova", "text1.tx", "text1", "text1", "http://docs.google.com/uc?export=download&id=10Gu9XM3Nu9crVo_O6-HsTynW1u_0supZ"));
        songs.add(new songs(R.drawable.stop , "Song4", "Vadim", "text1.tx", "text1", "text1", "http://docs.google.com/uc?export=download&id=10Gu9XM3Nu9crVo_O6-HsTynW1u_0supZ"));
        songs.add(new songs(R.drawable.stop , "Song5", "Chong", "text1.tx", "text1", "text1", "http://docs.google.com/uc?export=download&id=10Gu9XM3Nu9crVo_O6-HsTynW1u_0supZ"));
        songs.add(new songs(R.drawable.stop , "Song6", "Sasha", "text1.tx", "text1", "text1", "http://docs.google.com/uc?export=download&id=10Gu9XM3Nu9crVo_O6-HsTynW1u_0supZ"));

        return view;

    }

}
