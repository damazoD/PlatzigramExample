package com.rodrigo.damazod.platzigram.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rodrigo.damazod.platzigram.R;
import com.rodrigo.damazod.platzigram.model.Picture;
import com.rodrigo.damazod.platzigram.view.adapter.PictureAdapterRV;

import java.util.ArrayList;

/**
 * Created by damazoD on 18/07/2017.
 */

public class SearchFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_search,null,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.grid_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PictureAdapterRV(buildPictures(),getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg", "Rodrigo Bautista",4,5));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg", "Saul Bautista",2,3));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg", "Jacqueline Bautista",1,1));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg", "Mayra Lara",9,7));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg", "Amy Espinoza",6,7));

        return pictures;
    }
}
