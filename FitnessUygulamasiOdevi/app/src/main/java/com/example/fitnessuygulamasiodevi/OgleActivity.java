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

public class OgleActivity extends AppCompatActivity {


    RecyclerView recyclerView;
   DatabaseReference databaseReference;
    MyAdapterOgle myAdapterOgle;
    ArrayList<Ogle> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogle);


        recyclerView=findViewById(R.id.recView_ogle);
        databaseReference=FirebaseDatabase.getInstance().getReference("ogle");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<Ogle>();
        myAdapterOgle=new MyAdapterOgle(this,list);
        recyclerView.setAdapter(myAdapterOgle);


        //FirebaseDatabase database= FirebaseDatabase.getInstance();
        //DatabaseReference myRef=database.getReference("ogle");

        Ogle ogle1= new Ogle("Izgara Tavuk Göğsü(100gr)","151 cal","");
        Ogle ogle2= new Ogle("Izgara Köfte(100gr)","168 cal","");
        Ogle ogle3= new Ogle("Izgara Balık(100gr)","153cal","");
        Ogle ogle4= new Ogle("Tavuklu Arpa şehriye salatası","500 cal","");
        Ogle ogle5= new Ogle("Deniz ürünleri salatası","400 cal","");
        Ogle ogle6= new Ogle("Nohutlu semizotu salatası","200 cal","");
        Ogle ogle7= new Ogle("Çekölek roka salatası","220 cal","");
        Ogle ogle8= new Ogle("Sezar salata","440 cal","");
        Ogle ogle9= new Ogle("Çoban salata","115 cal","");
        Ogle ogle10= new Ogle("Mantarlı kinoa salata","350 cal","");
        Ogle ogle11= new Ogle("Falafel bowl","470 cal","");
        Ogle ogle12= new Ogle("Izgara bonfile(100gr)","186","");
        Ogle ogle13= new Ogle("Tavuk döner dürüm","309 cal","");
        Ogle ogle14= new Ogle("Ciğer dürüm","347 cal","");
        Ogle ogle15= new Ogle("Urfa dürüm","345 cal","");

        databaseReference.push().setValue(ogle1);
        databaseReference.push().setValue(ogle2);
        databaseReference.push().setValue(ogle3);
        databaseReference.push().setValue(ogle4);
        databaseReference.push().setValue(ogle5);
        databaseReference.push().setValue(ogle6);
        databaseReference.push().setValue(ogle7);
        databaseReference.push().setValue(ogle8);
        databaseReference.push().setValue(ogle9);
        databaseReference.push().setValue(ogle10);
        databaseReference.push().setValue(ogle11);
        databaseReference.push().setValue(ogle12);
        databaseReference.push().setValue(ogle13);
        databaseReference.push().setValue(ogle14);
        databaseReference.push().setValue(ogle15);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Ogle ogle=dataSnapshot.getValue(Ogle.class);
                    list.add(ogle);

                }

                myAdapterOgle.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}