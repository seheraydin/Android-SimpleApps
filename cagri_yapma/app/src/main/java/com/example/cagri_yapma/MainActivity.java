package com.example.cagri_yapma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //2:nesnelerimizi oluşturalım
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        aramaYap();
    }
    //3:View ları tanımla
    public void tanimla()
    {
        editText=findViewById(R.id.idEtxtPhone);
        button=findViewById(R.id.idBtnAra);
    }
    //4: butona tıklandığında arama sayfasına ulaşılmalı
    public void aramaYap()
    {
        //Not: arama yapmak için manifest içerisinde izin almamız gerekiyor
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String veriAl=editText.getText().toString();
                Intent ıntent=new Intent(Intent.ACTION_DIAL);
                ıntent.setData(Uri.parse("tel:"+veriAl));
                startActivity(ıntent);
        }
        });
    }
}
