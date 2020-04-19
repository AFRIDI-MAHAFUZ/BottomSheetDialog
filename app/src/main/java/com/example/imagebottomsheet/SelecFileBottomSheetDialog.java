package com.example.imagebottomsheet;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.net.URI;

public class SelecFileBottomSheetDialog extends BottomSheetDialogFragment {

    SelecFileBottomSheetDialog selecFileBottomSheetDialog;
    Uri imageUri;
    ItemClickListener itemClickListener;



    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottom_sheet_layout,container,false);

        LinearLayout layout = view.findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);;

                itemClickListener.onGalleryClick(intent1);
                dismiss();
            }
        });


        return view;
    }






    public interface ItemClickListener{

        void onGalleryClick(Intent intent);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            itemClickListener =(ItemClickListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()+
                    "must implement itemClickListener");
        }
    }
}
