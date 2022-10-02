package com.gl4.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class ImageUploadActivity : AppCompatActivity() {
    lateinit var imageView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_upload)
        imageView = findViewById(R.id.imageView2)
    }

    fun loadImage(view: View) {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        pickImage.launch(intent)
    }

    val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode == RESULT_OK){
            val uriImage = result.data?.data
            imageView.setImageURI(uriImage)
        }
    }
}

