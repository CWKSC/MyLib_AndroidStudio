package com.example.individualproject.CommonClass;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class MyViewGroup {

    public static void SafeAddView(ViewGroup viewGroup, View child){
        ViewParent viewParent = child.getParent();
        if(viewParent != null) ((ViewGroup)viewParent).removeView(child);
        viewGroup.addView(child);
    }


}
