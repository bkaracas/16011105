package com.example.bkrc.mobilprog1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Date;

public class MainActivity extends Activity {
    ImageView foto;
    public static Drawable imageDrawable;
    EditText name,surname,town,number,phonenumber;
    TextView dogum;
    Button kaydet,sil;
    DatePicker dogumTarihi;
    User user;
    public static final int IMAGE_GALLERY_REQUEST = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.DECOR_CAPTION_SHADE_DARK);
        setContentView(R.layout.activity_main);

        foto = (ImageView)findViewById(R.id.Foto);
        dogum = (TextView) findViewById(R.id.dogum);
        name = (EditText) findViewById(R.id.Name);
        surname = (EditText) findViewById(R.id.Surname);
        town = (EditText) findViewById(R.id.Hometown);
        number = (EditText) findViewById(R.id.IdNumber);
        phonenumber = (EditText) findViewById(R.id.PhoneNumber);
        dogumTarihi = (DatePicker)findViewById(R.id.datePick);
        kaydet = (Button) findViewById(R.id.kaydet);
        foto.setImageDrawable(MainActivity.imageDrawable);
        sil = (Button) findViewById(R.id.sil);


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser();
            }
        });
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageGalleryClicked();
            }
        });
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                surname.setText("");
                phonenumber.setText("");
                town.setText("");
                number.setText("");
            }
        });
        }

    private void onImageGalleryClicked() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();
        Uri data = Uri.parse(pictureDirectoryPath);
        photoPickerIntent.setDataAndType(data, "image/*");
        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == IMAGE_GALLERY_REQUEST){
            if(resultCode == RESULT_OK){
                Uri imageUri = data.getData();
                InputStream inputStream;
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    foto.setImageBitmap(image);
                    MainActivity.imageDrawable=foto.getDrawable();

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(this,"foto yok",Toast.LENGTH_LONG).show();
                }

            }
        }//else if (requestCode==PICK_CONTACT_REQUEST){
            //if(resultCode == RESULT_OK){
                //Uri contac

    }

    private void createNewUser() {

        int gun,ay,yil;
        String userName = name.getText().toString();
        String userSurname = surname.getText().toString();
        String homeTown = town.getText().toString();
        String userId = number.getText().toString();
        String userPhone= phonenumber.getText().toString();
        gun=dogumTarihi.getDayOfMonth();
        ay=dogumTarihi.getMonth()+1;
        yil=dogumTarihi.getYear();
        user=new User(userName,userSurname,gun,ay,yil,homeTown,userId,userPhone);

        final String username=userName;

       if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Adinizi Giriniz.", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(userSurname)){
            Toast.makeText(this, "Soyadinizi Giriniz.", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(userId)){
            Toast.makeText(this, "TC. Kimlik Numaranızı Giriniz.", Toast.LENGTH_SHORT).show();
        }
        else if(userId.length()!=11){
            Toast.makeText(this, "TC. Kimlik Numaranızı Eksik \n Girdiniz Tekrar Giriniz.", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(userPhone)){
            Toast.makeText(this, "Telefon Numaranızı Giriniz.", Toast.LENGTH_SHORT).show();
        }
        else if(userPhone.length()!=10){
            Toast.makeText(this, "Telefon Numaranızı Eksik \n Girdiniz Tekrar Giriniz.", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(homeTown)){
            Toast.makeText(this, "Doğum Yerinizi Giriniz.", Toast.LENGTH_SHORT).show();
        }

        else {
           SendUserToSecondActivity();
        }
    }

    private void SendUserToSecondActivity() {
        Intent secondIntent = new Intent(MainActivity.this,SecondActivity.class);
        secondIntent.putExtra("userInfo",user);
        startActivity(secondIntent);
        finish();
    }
}
