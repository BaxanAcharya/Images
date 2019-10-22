package com.biplav.images;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbjoker,rbspace,rbwhite;
    ImageView image;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbjoker=findViewById(R.id.txtjoker);
        rbspace=findViewById(R.id.txtspace);
        rbwhite=findViewById(R.id.txtwhite);
        image=findViewById(R.id.imgmy);

        builder=new AlertDialog.Builder(this);
        rbjoker.setOnClickListener(this);
        rbspace.setOnClickListener(this);
        rbwhite.setOnClickListener(this);
    }

    public void dialogbox(final int imagepar)
    {

        builder.setMessage("Do you want to view the image? ").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        image.setImageResource(imagepar);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert=builder.create();
        alert.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.txtjoker :
                dialogbox(R.drawable.joker);
                break;

            case R.id.txtspace :
                dialogbox(R.drawable.space);
                break;

            case R.id.txtwhite :
                dialogbox(R.drawable.white);
                break;
        }


    }
}
