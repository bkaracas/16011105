package com.example.bkrc.mobilprog1;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {
    ImageView userPhoto;
    TextView userInfo;
    Button phone, ders,mail;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        userInfo = (TextView) findViewById(R.id.yasGir);
        ders = (Button) findViewById(R.id.butonDerslerim);
        mail = (Button) findViewById(R.id.mailButton);
        userPhoto = (ImageView) findViewById(R.id.user_image);
        phone = (Button) findViewById(R.id.phoneButton);
        user=new User();
        userPhoto.setImageDrawable(MainActivity.imageDrawable);

        Intent i=getIntent();
        if (i.hasExtra("userInfo")){
        user=(User)i.getSerializableExtra("userInfo");
        userInfo.setText("\n"+user.getName()+" "+user.getSurname()+"\n\nDogumTarihi:"+user.getBirthDay()+"."+
                user.getBirthmonth()+"."+user.getBirthyear()+"\n\n Yas:"+user.getAge()
         +"\n\nTC Kimlik No:"+user.getId()+"\n\nMail Adresi:"+user.getEmail());
        phone.setText(user.getPhonenumber());}


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aramaYap();
            }
        });
        ders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                derslereGit();
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,user.getEmail());
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i,"choose a mail client"));
            }
        });
    }


    private void aramaYap() {
        String phonenumber= user.getPhonenumber();
        String uri= "tel:" + "0" + phonenumber;
        Intent arama = new Intent(Intent.ACTION_DIAL);
        arama.setData(Uri.parse(uri));
        startActivity(arama);
    }


    public void derslereGit(){
        Intent thirdIntent = new Intent(SecondActivity.this,ThirdActivity.class);
        thirdIntent.putExtra("userInfo",user);
        startActivity(thirdIntent);
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainIntent = new Intent(this,MainActivity.class);
        mainIntent.putExtra("userInfo",user);
        startActivity(mainIntent);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}