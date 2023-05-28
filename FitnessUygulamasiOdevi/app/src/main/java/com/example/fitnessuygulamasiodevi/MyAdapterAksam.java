package com.example.fitnessuygulamasiodevi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterAksam extends RecyclerView.Adapter<MyAdapterAksam.MyViewHolder> {

    Context context;
    ArrayList<Aksam> list;

    public MyAdapterAksam(Context context, ArrayList<Aksam> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item_aksam,parent,false);
        return new MyAdapterAksam.MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Aksam aksam=list.get(position);
        holder.isim.setText(aksam.getYemek_ad());
        holder.kalori.setText(aksam.getYemek_kalori());

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
