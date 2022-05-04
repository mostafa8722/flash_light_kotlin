package com.example.flash_light_kotlin

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var  img_btn: ImageButton;
    private lateinit var  cameraManager:CameraManager;
    private var state:Boolean = false;
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        img_btn = findViewById(R.id.img_btn);
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager;
        img_btn.setOnClickListener{runFlashLight(it)}

    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun runFlashLight(v: View?){
        var cameraListId = cameraManager.cameraIdList[0];
        if(!state){
            cameraManager.setTorchMode(cameraListId,true);
            img_btn.setImageResource(R.drawable.torch_on);
        }else {
            cameraManager.setTorchMode(cameraListId,false);
            img_btn.setImageResource(R.drawable.torch_off);
        }
        state =  !state;
    }
}