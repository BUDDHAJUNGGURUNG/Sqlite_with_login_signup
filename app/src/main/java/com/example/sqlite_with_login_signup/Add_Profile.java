package com.example.sqlite_with_login_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqlite_with_login_signup.databinding.ActivityAddProfileBinding;

public class Add_Profile extends AppCompatActivity {

    ActivityAddProfileBinding binding;

    public  static final  int CAMERA_REQUEST_CODE=100;
    public  static final  int STORAGE_REQUEST_CODE=101;

    public  static  final int IMAGE_PICK_CAMERA_CODE=102;
    public static  final int IMAGE_PICK_GALLERY_CODE=103;

    private String[] cameraPermission;
    private String[] storagePermission;

    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cameraPermission=new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};

        storagePermission=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        binding.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagePickDialog();
            }
        });

    }

    private void imagePickDialog() {
        String[] option ={"Camera","Gallery"};
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Pick Image from");
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (which==0){
                    if (!checkCameraPermission()){
                        requestCameraPermission();
                    }else {
                        pickFromCamera();
                    }
                } else if (which==1) {
                    if (!checkStoragePermission()){
                        requestStoragePermission();
                    }else {
                        pickFromGallery();
                    }
                }
            }
        });
        builder.create().show();
    }

    private void pickFromGallery() {

    }

    private void pickFromCamera() {
    }

    private  boolean checkStoragePermission(){
        //set storage allow permission from mobile device
        boolean result= ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                ==(PackageManager.PERMISSION_GRANTED);
        return  result;

    }

    private  void requestStoragePermission(){
        ActivityCompat.requestPermissions(this,storagePermission,STORAGE_REQUEST_CODE);

    }
    //set camera allow permission from mobile device
    private  boolean checkCameraPermission(){

        boolean result= ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                ==(PackageManager.PERMISSION_GRANTED);

        boolean result1= ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                ==(PackageManager.PERMISSION_GRANTED);

        return  result && result1;

    }
    private  void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, cameraPermission, STORAGE_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case CAMERA_REQUEST_CODE:{
                boolean cameraAccepted=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                boolean storageAccepted=grantResults[1]==PackageManager.PERMISSION_GRANTED;
                if (cameraAccepted && storageAccepted){
                    pickFromCamera();
                }else {
                    Toast.makeText(this, "Camera and Gallery permission are required", Toast.LENGTH_SHORT).show();
                }

            }break;
            case STORAGE_REQUEST_CODE:{
                boolean storageAccepted=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                if (storageAccepted){
                    pickFromGallery();
                }else {
                    Toast.makeText(this, "Storage Permission Required", Toast.LENGTH_SHORT).show();
                }
            }break;
        }
    }
}