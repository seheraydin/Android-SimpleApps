package com.example.mail_gonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText icerik;
    EditText konu;
    EditText mailAdres;
    Button button;
    String icerikText, konuText, mailAdresText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        mailUygulamalariniGorveGonder();
    }

    public void tanimla() {
        icerik = findViewById(R.id.idTxtMailIerik);
        konu = findViewById(R.id.idTxtMailKonusu);
        mailAdres = findViewById(R.id.idTxtMailAdres);
        button = findViewById(R.id.idBtnMailAt);
    }

    public void bilgiAl() {
        icerikText = icerik.getText().toString();
        konuText = konu.getText().toString();
        mailAdresText = mailAdres.getText().toString();
    }

    public void mailUygulamalariniGorveGonder() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilgiAl();
                try {
                    Intent ıntent = new Intent(Intent.ACTION_SEND);
                    ıntent.setType("message/rfc822");//sabit bir type
                    ıntent.putExtra(Intent.EXTRA_EMAIL, mailAdresText);
                    ıntent.putExtra(Intent.EXTRA_SUBJECT, konuText);
                    ıntent.putExtra(Intent.EXTRA_TEXT, icerikText);
                    startActivity(Intent.createChooser(ıntent,"Mail Gönderiniz:"));

                } catch (Exception e) {
                    System.out.println("" + e);
                }


            }
        });
    }
}
