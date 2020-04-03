package com.example.individualproject.Manager;

import java.util.ArrayList;
import java.util.List;

public class LoopingThreadManager {

    public List<LoopingThread> loopingThreadList = new ArrayList<>();

    public void Add(LoopingThread loopingThread) {
        loopingThreadList.add(loopingThread);
    }

    public void DestoryAll() {
        try {
            for (LoopingThread loopingThread : loopingThreadList) {
                loopingThread.running = false;
            }
            for (LoopingThread loopingThread : loopingThreadList) {
                loopingThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void StartAll() {
        for (LoopingThread loopingThread : loopingThreadList) {
            loopingThread.start();
        }
    }

}
