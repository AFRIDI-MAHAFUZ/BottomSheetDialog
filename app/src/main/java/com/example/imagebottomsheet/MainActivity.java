package com.example.imagebottomsheet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SelecFileBottomSheetDialog.ItemClickListener{

    private Button selectFileBtn;
    private ImageView imageView;
    private Uri imageUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        selectFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SelecFileBottomSheetDialog selecFileBottomSheetDialog = new SelecFileBottomSheetDialog();
                selecFileBottomSheetDialog.show(getSupportFragmentManager(),"select file bottom sheet");
            }
        });
    }

    private void init() {

        selectFileBtn = findViewById(R.id.selectFileBtn);
        imageView = findViewById(R.id.imageView);
    }


    @Override
    public void onGalleryClick(Intent intent) {

        intent.setType("image/*");
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && requestCode == RESULT_OK && data!=null){

            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
        else {
            Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
