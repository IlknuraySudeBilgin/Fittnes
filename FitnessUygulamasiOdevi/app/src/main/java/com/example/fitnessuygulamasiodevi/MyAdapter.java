package com.example.fitnessuygulamasiodevi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context contex;
    ArrayList<Yemek> list;

    public MyAdapter(Context contex, ArrayList<Yemek> list) {
        this.contex = contex;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(contex).inflate(R.layout.kahvalti_item,parent,false);
       return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Yemek yemek=list.get(position);
        //holder.isim.setText(yemek.getIsim());
        //holder.kalori.setText(yemek.getKalori());

        holder.isim.setText(yemek.getYemek_ad());
        holder.kalori.setText(yemek.getYemek_kalori());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView isim,kalori;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            isim=itemView.findViewById(R.id.isim);
            kalori=itemView.findViewById(R.id.kalori);

        }
    }

}
