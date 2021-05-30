package com.group3.license;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LicenseActivity extends AppCompatActivity {

    TextView nameRes,addressRes,bdayRes;
    int SELECT_PHOTO = 1;
    ImageView imageView;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

//Getting text from registration
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String address = intent.getStringExtra("Address");
        String bday = intent.getStringExtra("Birthday");

        nameRes = findViewById(R.id.name);
        addressRes = findViewById(R.id.addressVal);
        bdayRes = findViewById(R.id.bdayVal);
//setting text
        nameRes.setText("Name:"+name);
        addressRes.setText("Address"+address);
        bdayRes.setText("Birthday"+bday);

// image selector
        Button choose = findViewById(R.id.picSelect);
        imageView = findViewById(R.id.idpic);

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_PHOTO);
            }
        });

    }
//image assignment
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==SELECT_PHOTO && resultCode == RESULT_OK && data != null && data.getData() != null ){
            uri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}