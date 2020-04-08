package com.example.individualproject.Manager;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Manager<T> extends LoopingThread {
    public final CopyOnWriteArrayList<T> list = new CopyOnWriteArrayList<>();

    public Manager(Context context) {
        super(context);
    }


    public void Add(T object){
        list.add(object);
    }

    public void AddAll(Collection<? extends T> objects){
        list.addAll(objects);
    }


    public synchronized void SafeAdd(T element){
        list.add(element);
    }
    public synchronized void SafeAddAll(Collection<? extends T> elements){
        list.addAll(elements);
    }

    public synchronized void SafeRemove(T element){
        list.remove(element);
    }
    public synchronized void SafeRemoveAll(Collection<? extends T> elements){
        list.removeAll(elements);
    }

}
