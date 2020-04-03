package com.example.individualproject.CommonClass;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.concurrent.ThreadLocalRandom;

public class MyMath {

    public static double nanoTimeToSecond(long nanoTime) {
        return nanoTime / 1_000_000_000d;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static float random(float min, float max){
        return ThreadLocalRandom.current().nextFloat() * (max - min) + min;
    }

    /**Tn = (2n - 1) <br/>
     * T = 1 3 5 7 9 11 13 <br/>
     * n = 1 2 3 4 5  6  7 */
    public static int ToOdd(int n){
        return 2*n - 1;
    }

    /**Tn = (2n + 1) / (2n - 1) <br/>
     * T = 3/1 5/3 7/5 9/7 11/9 13/11 15/13<br/>
     * n =   1   2   3   4    5     6     7*/
    public static float ToOddAfferDivideBefore(int n){
        return (2.0f*n + 1.0f) / (2.0f*n - 1.0f);
    }

    /**Tn = (2n - 1)^2 <br/>
     * T = 1 9 25 49  81 100 <br/>
     * n = 1 2  3  4   5   6 */
    public static int ToOddPow2(int n){
        return (int) Math.pow(ToOdd(n), 2);
    }

    public static float OddPow2ToN(int n){
        return (float) ((Math.sqrt(n) + 1) / 2f);
    }
    public static float OddPow2ToN(float n){
        return (float) ((Math.sqrt(n) + 1) / 2f);
    }

}
