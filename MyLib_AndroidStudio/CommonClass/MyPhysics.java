package com.example.individualproject.CommonClass;

import androidx.annotation.Nullable;

public class MyPhysics {


    public static float gravity = 9.81f;

    public static boolean CircleCollision(Vector2 a, float r1, Vector2 b, float r2){
        double distance = Vector2.Distance(a, b);
        return  distance <= r1 + r2;
    }




    public static Float F_ma(Float F, Float m, Float a){
        return F == null ? m * a :
               m == null ? F / a :
               a == null ? F / m :
               null;
    }

}
