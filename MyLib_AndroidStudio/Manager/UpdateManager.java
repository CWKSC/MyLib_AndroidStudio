package com.example.individualproject.Manager;

import android.content.Context;

import com.example.individualproject.CommonClass.MySystem;

import java.util.Collection;

public class UpdateManager extends Manager<IUpdatable> {

    public UpdateManager(Context context) {
        super(context);
    }

    private double previousTime;
    private double deltaTime;

    @Override
    public void ThreadStart() {
        previousTime = MySystem.secondTime();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).Start();
        }
    }

    @Override
    public void ThreadUpdate() {
        deltaTime = MySystem.secondTime() - previousTime;
        previousTime = MySystem.secondTime();

        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                IUpdatable updatable = list.get(i);
                if(updatable != null) { // Defensive programming
                    updatable.Update(deltaTime);
                }
            }
        }
    }



}
