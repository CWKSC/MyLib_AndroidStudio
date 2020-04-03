package com.example.individualproject.CommonClass;

public class MyPhysics {


    public static float gravity = 9.81f;

    public static boolean CircleCollision(Vector2 a, float r1, Vector2 b, float r2){
        double distance = Vector2.Distance(a, b);
        return  distance <= r1 + r2;
    }


    public enum Find {
        F, m, a
    }
    public static float F_ma(Find find, float p1, float p2){
        float F, m, a;
        switch (find) {
            case F:
                m = p1;
                a = p2;
                return m * a;
            case m:
                F = p1;
                a = p2;
                return F / a;
            case a:
                F = p1;
                m = p2;
                return F / m;
            default:
                throw new IllegalStateException("Unexpected value: " + find);
        }
    }

}
