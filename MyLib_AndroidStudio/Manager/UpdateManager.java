package com.example.individualproject.Manager;

import android.content.Context;

import com.example.individualproject.CommonClass.MySystem;

public class UpdateManager extends Manager<UpdateObject> {

    public UpdateManager(Context context) {
        super(context);
    }

    private double previousTime;
    private double deltaTime;

    @Override
    public void ThreadStart() {
        previousTime = MySystem.secondTime();

        for (int i = 0; i < list.size(); i++) {
            list.get(i).Start();
        }
    }

    @Override
    public void ThreadUpdate() {
        deltaTime = MySystem.secondTime() - previousTime;
        previousTime = MySystem.secondTime();

        for (int i = 0; i < list.size(); i++) {
            list.get(i).Update(deltaTime);
        }
    }
}
