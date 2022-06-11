package com.example.zenquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Modelclass> list;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();

        databaseReference=FirebaseDatabase.getInstance().getReference("Question");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Modelclass modelclass=dataSnapshot.getValue(Modelclass.class);
                    list.add(modelclass);
                }
                Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//
//        list.add(new Modelclass("saaada","a","b","c","d","a"));
//        list.add(new Modelclass("sddddd","a","b","c","d","b"));
//        list.add(new Modelclass("jjjjjjjj","a","b","c","d","b"));
//        list.add(new Modelclass("saaada","a","b","c","d","c"));
//        list.add(new Modelclass("sddddd","a","b","c","d","d"));
//        list.add(new Modelclass("jjjjjjjj","a","b","c","d","d"));
//        list.add(new Modelclass("saaada","a","b","c","d","c"));
//        list.add(new Modelclass("sddddd","a","b","c","d","b"));
//        list.add(new Modelclass("jjjjjjjj","a","b","c","d","a"));
//        list.add(new Modelclass("saaada","a","b","c","d","d"));
//        list.add(new Modelclass("sddddd","a","b","c","d","c"));
//        list.add(new Modelclass("jjjjjjjj","a","b","c","d","b"));
//        list.add(new Modelclass("saaada","a","b","c","d","c"));
//        list.add(new Modelclass("sddddd","a","b","c","d","b"));
//        list.add(new Modelclass("jjjjjjjj","a","b","c","d","a"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
//                startActivity(intent);

            }
        },1500);
    }
}