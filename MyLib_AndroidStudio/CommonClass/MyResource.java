package com.example.individualproject.CommonClass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MyResource {

    public static Bitmap getBitmap(Context context, int id){
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

}
