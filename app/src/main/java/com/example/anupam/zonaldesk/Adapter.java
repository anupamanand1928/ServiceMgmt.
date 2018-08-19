package com.example.anupam.zonaldesk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder>{

    Context mContent;
    List<item> mData;

    public Adapter(Context mContent, List<item> mData) {
        this.mContent = mContent;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContent);
        View v = inflater.inflate(R.layout.activity_customer_services,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        holder.background_img.setImageResource(mData.get(position).getBackground());
        holder.profile_photo.setImageResource(mData.get(position).getProfilePhoto());
        holder.tv_title.setText(mData.get(position).getProfileName());
        holder.tv_nbFollowers.setText(mData.get(position).getNbFollowers()+" Followers");
        holder.background_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContent,ServiceViewActivity.class);
                intent.putExtra("background",mData.get(position).getBackground());
                // start the activity
                mContent.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView profile_photo,background_img;
        TextView tv_title,tv_nbFollowers;


    public myViewHolder(View itemView) {
        super(itemView);
        profile_photo = itemView.findViewById(R.id.profile_img);
        background_img = itemView.findViewById(R.id.card_background);
        tv_title = itemView.findViewById(R.id.card_title);
        tv_nbFollowers = itemView.findViewById(R.id.card_desc);
    }
}

}
