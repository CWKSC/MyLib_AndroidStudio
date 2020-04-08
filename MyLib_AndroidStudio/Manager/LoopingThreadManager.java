package com.example.individualproject.Manager;

import java.util.ArrayList;
import java.util.List;

public class LoopingThreadManager {

    public List<LoopingThread> loopingThreadList = new ArrayList<>();

    public void Add(LoopingThread loopingThread) {
        loopingThreadList.add(loopingThread);
    }

    public void DestoryAll() {
        int size = loopingThreadList.size();
        boolean retry = true;
        try {
            for (int i = 0; i < size; i++) {
                loopingThreadList.get(i).running = false;
            }
            for (int i = 0; i < size; i++) {
                retry = true;
                while (retry) {
                    loopingThreadList.get(i).join();
                    retry = false;
                }
            }
            loopingThreadList.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void StartAll() {
        int size = loopingThreadList.size();
        for (int i = 0; i < size; i++) {
            loopingThreadList.get(i).start();
        }
    }

}
