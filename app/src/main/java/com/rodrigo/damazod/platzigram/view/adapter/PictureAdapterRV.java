package com.rodrigo.damazod.platzigram.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.rodrigo.damazod.platzigram.R;
import com.rodrigo.damazod.platzigram.model.Picture;
import com.rodrigo.damazod.platzigram.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by damazoD on 18/07/2017.
 */

public class PictureAdapterRV  extends RecyclerView.Adapter<PictureAdapterRV.PictureViewHolder>{

    private ArrayList<Picture> pictures;
    private Context context;

    public PictureAdapterRV(ArrayList<Picture> pictures,Context context) {
        this.pictures = pictures;
        this.context = context;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        return new PictureViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_picture,parent,false));
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder,int position) {
        holder.bindElements(pictures.get(position));
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }



    class PictureViewHolder extends RecyclerView.ViewHolder{
        private ImageView pictureView ;
        private TextView tvUsername,tvTime,tvLike;

        PictureViewHolder(View itemView) {
            super(itemView);
            pictureView =(ImageView)itemView.findViewById(R.id.picture_card);
            tvUsername =(TextView)itemView.findViewById(R.id.username_card);
            tvTime =(TextView)itemView.findViewById(R.id.time_card);
            tvLike =(TextView)itemView.findViewById(R.id.like_number_card);
        }

        void bindElements(Picture picture){
            tvUsername.setText(picture.getUsername());
            tvTime.setText(String.valueOf(picture.getTime()));
            tvLike.setText(String.valueOf(picture.getLike()));
            Picasso.with(context).load(picture.getPicture()).into(pictureView);

            pictureView.setOnClickListener(item -> {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    Activity activity = (Activity) context;
                    activity.getWindow().setExitTransition(explode);
                    context.startActivity(new Intent(context,DetailActivity.class),
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity,item,context.getString(R.string.transictionCardview)).toBundle());

                }else{
                    context.startActivity(new Intent(context,DetailActivity.class));
                }


            });
        }
    }
}
