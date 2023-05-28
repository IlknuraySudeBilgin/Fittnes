package com.example.fitnessuygulamasiodevi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AksamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapterAksam myAdapterAksam;
    ArrayList<Aksam> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksam);



        recyclerView=findViewById(R.id.recView_aksam);
        databaseReference= FirebaseDatabase.getInstance().getReference("aksam");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<Aksam>();
        myAdapterAksam=new MyAdapterAksam(this,list);
        recyclerView.setAdapter(myAdapterAksam);

        Aksam aksam1 = new Aksam("Zeytinyağlı Pırasa","200 cal","");
        Aksam aksam2 = new Aksam("Zeytinyağlı Bakla","199 cal","");
        Aksam aksam3 = new Aksam("Zeytinyağlı Bezelye","199 cal","");
        Aksam aksam4 = new Aksam("Zeytinyağlı Barbunya","356 cal","");
        Aksam aksam5 = new Aksam("Ispanak","133 cal","");
        Aksam aksam6 = new Aksam("Karnabahar","112 cal","");
        Aksam aksam7 = new Aksam("Karnıyarık","191 cal","");
        Aksam aksam8 = new Aksam("Mercimek çorbası","137 cal","");
        Aksam aksam9 = new Aksam("Tarhana çorbası","151 cal","");
        Aksam aksam10 = new Aksam("Şehriye çorbası","136 cal","");
        Aksam aksam11 = new Aksam("Brokoli çorbası","60 cal","");
        Aksam aksam12= new Aksam("Bulgur Pİlavı","149 cal","");
        Aksam aksam13= new Aksam("Patates Püresi","491 cal","");
        Aksam aksam14= new Aksam("Makarna","141 cal","");
        Aksam aksam15 = new Aksam("Pilav","460 cal","");


        databaseReference.push().setValue(aksam1);
        databaseReference.push().setValue(aksam2);
        databaseReference.push().setValue(aksam3);
        databaseReference.push().setValue(aksam4);
        databaseReference.push().setValue(aksam5);
        databaseReference.push().setValue(aksam6);
        databaseReference.push().setValue(aksam7);
        databaseReference.push().setValue(aksam8);
        databaseReference.push().setValue(aksam9);
        databaseReference.push().setValue(aksam10);
        databaseReference.push().setValue(aksam11);
        databaseReference.push().setValue(aksam12);
        databaseReference.push().setValue(aksam13);
        databaseReference.push().setValue(aksam14);
        databaseReference.push().setValue(aksam15);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Aksam aksam=dataSnapshot.getValue(Aksam.class);
                    list.add(aksam);

                }

                myAdapterAksam.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}