package com.imageviewer.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Akshay Jindam on 29-03-2017.
 */

public class Constants {

    public static List<String> data;

    public static List<String> getFavourateList() {
        data = new ArrayList<>();
        data.add("1");
        data.add("4");
        data.add("6");
        data.add("8");
        return data;
    }


    public static void saveToInternalStorage(Bitmap finalBitmap, Context context) {


        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/saved_images");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);

        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);

            out.flush();
            out.close();

            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
