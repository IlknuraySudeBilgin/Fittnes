package com.example.fitnessuygulamasiodevi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterOgle extends RecyclerView.Adapter<MyAdapterOgle.MyViewHolder> {


    Context context;
    ArrayList<Ogle> list;

    public MyAdapterOgle(Context context, ArrayList<Ogle> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(context).inflate(R.layout.ogle_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Ogle ogle=list.get(position);
        holder.isim.setText(ogle.getYemek_ad());
        holder.kalori.setText(ogle.getYemek_kalori());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView isim,kalori;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            isim=itemView.findViewById(R.id.isim);
            kalori=itemView.findViewById(R.id.kalori);

        }
    }

}
