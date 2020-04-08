package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;;
import android.widget.TextView;

import java.util.List;

import static com.example.myapplication.R.id.idBtn;


public class adapter extends BaseAdapter {
    List<model> list;
    Context context;
    Activity activity;



    public adapter(List<model> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity= activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position,  View convertView, ViewGroup parent) {
       convertView= LayoutInflater.from(context).inflate(R.layout.mesajayout, parent, false);

        final EditText editText=convertView.findViewById(R.id.idMsjIcerik);
        Button button=convertView.findViewById(idBtn);
        TextView tel=convertView.findViewById(R.id.idTxtTel);
        TextView isim=convertView.findViewById(R.id.idTxtIsim);

        tel.setText(list.get(position).getTel());
        isim.setText(list.get(position).getIsim());
        final String telNo=list.get(position).getTel();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String mesajIcerik;
                mesajIcerik = editText.getText().toString();

                Intent ıntent=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" +telNo));
                ıntent.putExtra("sms_body",mesajIcerik);

                activity.startActivity(ıntent);

            }
        });

        return convertView;
    }
}
