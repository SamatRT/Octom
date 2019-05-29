package com.example.user.octom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class SearchFragment extends Fragment implements View.OnClickListener {

    public RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<songs> songsList = new ArrayList<>();
    public EditText Edit_fragment_search;
    public TextView Text_fragment_search;
    ArrayList<songs> filteredList = new ArrayList<>();
    public Button SearchButton;
    public ViewSwitcher switcher;
    private String findName = "";
    private SongsAdapter songsAdapter = new SongsAdapter(filteredList);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        Edit_fragment_search = (EditText) view.findViewById(R.id.Edit_fragment_search);
        Text_fragment_search = (TextView) view.findViewById(R.id.Text_fragment_search);
        CreateSongList();
        switcher = (ViewSwitcher) view.findViewById(R.id.search_fragment_switcher);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);

        recyclerView.setAdapter(songsAdapter);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        SearchButton = (Button) view.findViewById(R.id.Search_button);
        SearchButton.setOnClickListener(this);
        Text_fragment_search.setOnClickListener(this);

        return view;

    }

    private void filter(String text) {
        filteredList.clear();
        System.out.println("очищено");
        for (songs item : songsList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
                System.out.println("есть совпадение");
            }
        }

        songsAdapter.setSongs(filteredList);

        System.out.println("сохранено");

    }


    public void CreateSongList() {
        songsList.add(new songs(R.drawable.unreavel_image     , "Unreavel"          , "Hatsune Miku"  , "Tab_Unravel.pdf"                                                    ,"unreaveltint" , "https://www.youtube.com/watch?v=ztKl8qqZr0c"             , R.raw.unreavelplus ,R.raw.unreavelminus));
        songsList.add(new songs(R.drawable.elder_scrolls_image, "DragonBorn"        , "Jeremy Soule"  , "the_elder_scrolls_v_skyrim-the_dragonborn_comes_fingerstyle.pdf"    ,"unreaveltint" , "https://mychords.net/aria/70-ariya-bespechnyj-angel.html", R.raw.jeremy_soule_dragonborn ,R.raw.jeremy_soule_dragonborn));
        songsList.add(new songs(R.drawable.allegro_image      , "Allegro"           , "Мауро Джулиани", "giuliani_mauro-allegro_allegro.pdf"                                 ,"unreaveltint" , "https://mychords.net/aria/70-ariya-bespechnyj-angel.html", R.raw.allegroplus ,R.raw.allegrominus));
        songsList.add(new songs(R.drawable.bb_king_image      , "The Thrill Is Gone", "BB King"       , "bb_king-the_thrill_is_gone.pdf"                                     ,"unreaveltint" , "https://mychords.net/aria/70-ariya-bespechnyj-angel.html", R.raw.the_thrill_is_gone ,R.raw.the_thrill_is_gone));

        for (songs item : songsList) {
            filteredList.add(item);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Search_button:
                filter(Edit_fragment_search.getText().toString());
                switcher.showPrevious();
                break;
            case R.id.Text_fragment_search:
                switcher.showNext();
                break;
        }
    }

}
