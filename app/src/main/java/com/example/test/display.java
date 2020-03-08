package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class display extends AppCompatActivity {
    TextView tv1,tv2;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);

        Intent intent=getIntent();
        String value=intent.getStringExtra("my key");
        tv2.setText(value);


        database=FirebaseDatabase.getInstance();
        DatabaseReference midRef=database.getReference().child("monuments");
        Query obj=midRef.orderByChild("name")
                .equalTo(value);
        obj.addValueEventListener(postListener);





    }
    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
           for(DataSnapshot childs : dataSnapshot.getChildren()){

               Monument m=childs.getValue(Monument.class);

               String name=m.getName()+"\n"+m.getDescription()+"\n"+m.getLocation()+"\n"+m.getTag()+"\n"+m.getNoc();
               tv1.setText(name);

           }


        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };



}
