package com.example.individualproject.Manager;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public abstract class Manager<T> extends LoopingThread {
    public List<T> list = new ArrayList<>();

    public Manager(Context context) {
        super(context);
    }

    public void Add(T object){
        list.add(object);
    }

}
