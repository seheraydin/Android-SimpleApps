package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<model>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeDoldur();
        tanimla();
    }
    public void listeDoldur()
    {
        list=new ArrayList<>();
        model m1=new model("seher","25631478965");
        model m2=new model("sezer","12345678901");
        model m3=new model("ege","12345678901");
        model m4=new model("efe","12345678901");
        model m5=new model("eren","12345678901");

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
    }
    public void tanimla()
    {
        ListView listView=findViewById(R.id.idMsjLst);
        adapter adp=new adapter(list,this,this);
        listView.setAdapter(adp);
    }

}
