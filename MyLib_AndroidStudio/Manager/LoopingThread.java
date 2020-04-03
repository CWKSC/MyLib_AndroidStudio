package com.example.individualproject.Manager;

import android.content.Context;

public abstract class LoopingThread extends Thread {

    public boolean running = true;
    public Context context;

    public LoopingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        ThreadStart();
        while (running) {
            ThreadUpdate();
        }
    }

    public abstract void ThreadStart();

    public abstract void ThreadUpdate();
}


