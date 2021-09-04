package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var tvButton: Button
    private lateinit var tvImgbutton : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvButton = findViewById(R.id.tvButton)
        this.tvImgbutton = findViewById(R.id.tvImgbutton)

        val cameraFoto = registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
            this.tvImgbutton.setImageBitmap(it)
        }
        this.tvButton.setOnClickListener {
            cameraFoto.launch(null)
        }
    }
}