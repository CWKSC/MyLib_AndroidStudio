package com.example.individualproject.CommonClass;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

import com.example.individualproject.GamePanel;


import com.example.individualproject.R;

public class MyUI {

    public static int screenWidth;
    public static int screenHeight;

    public static int middleX(){
        return screenWidth / 2;
    }
    public static int middleY() {
        return screenHeight / 2;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void recordScreenWidthHeight(Activity activity){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
        screenWidth = displaymetrics.widthPixels;
        screenHeight = displaymetrics.heightPixels;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void setImmersiveSticky(Activity activity){
        int option =  View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        activity.getWindow().getDecorView().setSystemUiVisibility(option);
    }


    @SuppressLint("SourceLockedOrientationActivity")
    static void setLandscape(Activity activity){
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @SuppressLint("SourceLockedOrientationActivity")
    static void setPortrait(Activity activity){
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    static void setFillscreen(Activity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static float perW_px(float percentWidth){
        return percentWidth * screenWidth / 100;
    }

    public static float perH_px(float percentHeight){
        return percentHeight * screenHeight / 100;
    }

    public static Vector2 GameWorldToCameraPosition(Vector2 position){
        return GameWorldToCameraPosition(position, new Vector2(0, 0));
    }

    public static Vector2 GameWorldToCameraPosition(Vector2 position, Vector2 referencePosition){
        return GameWorldToCameraPosition(position, referencePosition,1);
    }

    public static Vector2 GameWorldToCameraPosition(Vector2 position, Vector2 referencePosition, float canvasScale){
        Vector2 relative = Vector2.AToB(referencePosition, position);
        relative.x += middleX() / canvasScale;
        relative.y += middleY() / canvasScale;
        return relative;
    }

    public static boolean XYinRect(Rect rect, float x, float y){
        return (x >= rect.left && x <= rect.right) &&
                (y >= rect.top && y <= rect.bottom);
    }


}
