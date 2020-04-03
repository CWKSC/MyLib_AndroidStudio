package com.example.individualproject.Manager;

import android.content.Context;
import android.view.MotionEvent;

import com.example.individualproject.CommonClass.MySystem;

public class OnTouchManager extends Manager<OnTouchObject> {

    public static MotionEvent event;
    public static boolean onTouch = false;
    public static float x;
    public static float y;
    public static int action;

    private double previousTime;
    private double deltaTime;

    public OnTouchManager(Context context) {
        super(context);
    }

    @Override
    public void ThreadStart() {
        previousTime = MySystem.secondTime();
    }

    @Override
    public void ThreadUpdate() {
        deltaTime = MySystem.secondTime() - previousTime;
        previousTime = MySystem.secondTime();

        if(!onTouch) { return; }

        // Down //
        if(action == MotionEvent.ACTION_DOWN){
            for (int i = 0; i < list.size(); i++) {
                OnTouchObject onTouchObject = list.get(i);
                onTouchObject.OnTouchDown(deltaTime);
                onTouchObject.OnTouchDownAndMove(deltaTime);
            }
            return;
        }

        // Move //
        if(action == MotionEvent.ACTION_MOVE){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).OnTouchDownAndMove(deltaTime);
            }
            return;
        }

        // Up //
        if(action == MotionEvent.ACTION_UP){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).OnTouchUp(deltaTime);
            }
        }

    }
}
