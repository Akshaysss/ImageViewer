package com.imageviewer;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.imageviewer.utils.Constants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

import static com.imageviewer.R.id.save;
import static com.imageviewer.R.id.set;

public class ImageDescription extends AppCompatActivity {

    ImageView imageView;
    Button setWallpaper;
    Button saveWallpaper;
    Bitmap currentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_description);

        //To enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //here m getting url of image from previous activity
        final String imageUrl = getIntent().getExtras().getString("image_url");

        imageView = (ImageView) findViewById(R.id.id_image);
        setWallpaper = (Button) findViewById(set);
        saveWallpaper = (Button) findViewById(save);

        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                /*In target when image loads i get bitmap then i set that bitmp to imageView*/

                currentImage = bitmap;
                imageView.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        };

 /*Instead of loading image into a In=mageView we passed to target in target i get image in bitmap format*/
        Picasso.with(this).load(imageUrl).into(target);

        saveWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImage != null) {
                    Constants.saveToInternalStorage(currentImage, getApplicationContext());
                    Toast.makeText(ImageDescription.this, "Wallpaper saved Sucessfully!...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ImageDescription.this, "download error...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                WallpaperManager wm = WallpaperManager.getInstance(ImageDescription.this);

                if (currentImage != null) {
                    try {
                        wm.setBitmap(currentImage);
                        Toast.makeText(ImageDescription.this, "Wallpaper setted Sucessfully!...", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(ImageDescription.this, "Image not loaded yet please wait!...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //on back button below method is called
    @Override
    public void onBackPressed() {
        //default code to get one step back
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

