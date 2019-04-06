package com.example.bkrc.mobilprog1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DersInfoActivity extends Activity {

    TextView dersadi,dersortalamasi,dersalanaogr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_info);

        dersadi=(TextView)findViewById(R.id.ders_adi);
        dersortalamasi=(TextView)findViewById(R.id.not_ortalama);
        dersalanaogr=(TextView)findViewById(R.id.ogrenci_sayisi);


        Intent i=getIntent();
        String name=i.getStringExtra("name");
        String ort=i.getStringExtra("ort");
        String sayi=i.getStringExtra("sayi");

        dersadi.setText(name);
        dersortalamasi.setText(ort);
        dersalanaogr.setText(sayi);

    }
}
