package com.example.securityapplicationprototype;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class UnauthorizedPersonsInfoActivity extends AppCompatActivity {

    private ImageView unAuthorizedImageView;
    private Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + File.separator + "CameraFolder"
            + File.separator + "temp.jpg");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unautorized_personinfo);
        this.unAuthorizedImageView = findViewById(R.id.unAuthorizedImageView);
        unAuthorizedImageView.setImageBitmap(bitmap);
    }
}
