package com.imageviewer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imageviewer.ImageDescription;
import com.imageviewer.Model;
import com.imageviewer.R;
import com.imageviewer.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Akshay Jindam on 12-03-2017.
 */

public class ImageViewer_Adapter extends RecyclerView.Adapter<ImageViewer_Adapter.MyViewHolder> {

    List<Model> list;
    Context context;

    public ImageViewer_Adapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        CardView background;
        TextView imageName;
        TextView designerName;
        ImageView favbutton;


        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_imageViewer);
            background = (CardView) itemView.findViewById(R.id.ll_imageViewer);
            imageName = (TextView) itemView.findViewById(R.id.id_ImageName);
            designerName = (TextView) itemView.findViewById(R.id.id_DesignerName);
            favbutton = (ImageView) itemView.findViewById(R.id.toggle);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Picasso.with(context).load(list.get(position).getImageUrl()).into(holder.imageView);

        holder.imageName.setText(list.get(position).getImageName());
        holder.designerName.setText(list.get(position).getDesignerName());

        holder.favbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.favbutton.setImageDrawable(context.getResources().getDrawable(R.drawable.selected_image));

                if (Constants.data != null) {
                    Constants.data.add(list.get(position).getImageID());
                }
            }
        });

        holder.background.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // on click im starting a new activity
                Intent i = new Intent(context, ImageDescription.class);

                //here m passing image url to new activity
                i.putExtra("image_url", list.get(position).getImageUrl());
                i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
                /*Toast.makeText(context," "+list.get(position).getImageView(),Toast.LENGTH_SHORT).show();*/
            }
        });

        List<String> favourateList = Constants.getFavourateList();


        if (favourateList.contains(list.get(position).getImageID())) {
            holder.favbutton.setImageResource(R.drawable.selected_image);
        } else {
            holder.favbutton.setImageResource(R.drawable.unselected_image);
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

}

