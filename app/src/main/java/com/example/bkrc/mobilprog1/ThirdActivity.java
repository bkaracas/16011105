package com.example.bkrc.mobilprog1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Ders> dersList;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        recyclerView=(RecyclerView)findViewById(R.id.third_Activity_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        user=new User();

        Intent i=getIntent();
        if (i.hasExtra("userInfo")){
            user=(User)i.getSerializableExtra("userInfo");
           }


        dersList= new ArrayList<Ders>();
        dersList.add(new Ders("BBG1","BA","50","120"));
        dersList.add(new Ders("BBG2","BB","55","100"));
        dersList.add(new Ders("MOBİL PROG. GİRİŞ","AA","60","60"));
        dersList.add(new Ders("OYUN GELİŞTİRMEYE GİRİŞ","AA","90","65"));
        dersList.add(new Ders("AĞ TEKNOLOJİLERİ","BB","75","150"));
        dersList.add(new Ders("ASSEMBLY","CB","50","40"));
        dersList.add(new Ders("NESNEYE DAYALI PROG.","AA","56","60"));
        dersList.add(new Ders("HESAPLAMA KURAMI","F0","37","62"));
        dersList.add(new Ders("MİKROİŞLEMCİ","F0","75","75"));
        dersList.add(new Ders("ALGORİTMA ANALİZİ","CB","40","63"));
        dersList.add(new Ders("VERİ YAPILARI","CC","55","120"));
        dersList.add(new Ders("BİLGİSAYAR DONANIMI","AA","60","40"));


        mAdapter= new MyAdapter(this,dersList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent secondIntent = new Intent(ThirdActivity.this,SecondActivity.class);
        secondIntent.putExtra("userInfo",user);
        startActivity(secondIntent);
        finish();
    }
}


