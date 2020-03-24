package com.example.securityapplicationprototype.CameraFunsionality;

import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.securityapplicationprototype.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CamreaActivity extends AppCompatActivity  {

    private Camera camera;
    private FrameLayout frameLayout;
    ShowCamera showCamera;
    CardView gobackButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.frameLayout = findViewById(R.id.frameLayout);
        this.camera = Camera.open(1);
        this.showCamera = new ShowCamera(this, camera);
        frameLayout.addView(showCamera);
        this.gobackButton=findViewById(R.id.gobackButton);
        final CardView takePicture=findViewById(R.id.takePicture);



        int noOfSecond = 1;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //TODO Set your button auto perform click.
                takePicture.performClick();
            }
        }, noOfSecond * 1000);



        takePicture.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            takePic();
        }
    });

        gobackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
}

    private void takePic() {
        if (camera != null) {
            camera.takePicture(null, null, mPictureCallback);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                camera.enableShutterSound(false);
            }
        }
    }

    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            File picture_file = getOutMediaFile();

            if (picture_file == null) {
                return;
            } else {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(picture_file);
                    fileOutputStream.write(data);
                    fileOutputStream.close();
                    camera.startPreview();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    private File getOutMediaFile() {
        String state = Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            return null;
        } else {
            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "CameraFolder");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File outputFile = new File(folder, "temp.jpg");
            return outputFile;
        }
    }

}
