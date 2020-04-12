package com.theflown.theflownapp.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Utils {

    public static boolean saveImageToInternalStorage(final Context context, final Bitmap image, String fileName) {

        try {
            final FileOutputStream fos = context.openFileOutput(fileName+".png", Context.MODE_PRIVATE);
            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();

            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public static String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
    }

    public static void startSelectImageIntent(AppCompatActivity appCompatActivity, int reqCode) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        appCompatActivity.startActivityForResult(intent, reqCode);

        //onActivityResult:
        //bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),data.getdata());
    }

    public static enum Status_codes{
        Opened,
        Held,
        Old
    }

    public static void mStartActivity(Context context, Class X) {
        Intent intent = new Intent(context, X);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public static Bitmap loadImageBitmap(final Context context,String name) {

        final FileInputStream fileInputStream;
        Bitmap bitmap = null;
        try {
            fileInputStream = context.openFileInput(name+".png");

            bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static boolean fileExist(final Context context,String  name) {
        return context.getFileStreamPath(name).exists();

    }

}
