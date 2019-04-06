package com.example.bkrc.mobilprog1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    List<Ders> dersList;
    Context c;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements ItemClickListener, View.OnClickListener {

        public TextView textViewDers;
        public TextView textViewNot;
        public CardView cardView;
        ItemClickListener ıtemClickListener;

        public MyViewHolder(View v){
            super(v);
            textViewDers=(TextView)v.findViewById(R.id.text_ders);
            textViewNot=(TextView)v.findViewById(R.id.text_ders_not);
            cardView = (CardView)v.findViewById(R.id.ders_card_cardview);
            v.setOnClickListener(this);


        }

        @Override
        public void onItemClicked(View v, int pos) {

        }

        @Override
        public void onClick(View v) {
            this.ıtemClickListener.onItemClicked(v, getLayoutPosition());

        }
        public void setItemClickListener(ItemClickListener ic){
            this.ıtemClickListener=ic;
        }
    }


    public MyAdapter(Context c,List<Ders> dersList){
        this.c=c;
        this.dersList=dersList;
    }



    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.ders_cardview,parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    public void onBindViewHolder(MyViewHolder holder, final int position){
        holder.textViewDers.setText(dersList.get(position).getDersAdi());
        holder.textViewNot.setText(dersList.get(position).getNot());

        Animation animation=AnimationUtils.loadAnimation(c,android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClicked(View v, int pos) {
                String name= dersList.get(position).getDersAdi();
                String ortalama= dersList.get(position).getNotOrtalaması();
                String ogrsayisi=dersList.get(position).getOgrenciSayisi();
                Intent i=new Intent(c,DersInfoActivity.class);
                i.putExtra("name",name);
                i.putExtra("ort",ortalama);
                i.putExtra("sayi",ogrsayisi);
                c.startActivity(i);
            }
        });

    }

    public int getItemCount(){
        return dersList.size();}

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
