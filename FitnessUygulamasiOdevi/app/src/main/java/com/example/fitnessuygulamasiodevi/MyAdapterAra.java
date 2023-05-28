package com.example.fitnessuygulamasiodevi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterAra extends RecyclerView.Adapter<MyAdapterAra.MyViewHolder> {

    Context context;
    ArrayList<AraOgun> list;

    public MyAdapterAra(Context context, ArrayList<AraOgun> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(context).inflate(R.layout.ara_item,parent,false);
        return new MyAdapterAra.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AraOgun araogun=list.get(position);
        holder.isim.setText(araogun.getYemek_ad());
        holder.kalori.setText(araogun.getYemek_kalori());

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
