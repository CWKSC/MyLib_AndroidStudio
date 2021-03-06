package com.example.individualproject.Manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class DrawManager extends Manager<IDrawable> {

    public SurfaceHolder surfaceHolder;
    public Canvas canvas;

    public static float canvasScale;

    public DrawManager(Context context, SurfaceHolder surfaceHolder) {
        super(context);
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void ThreadStart() { }


    @Override
    public void ThreadUpdate() {
        canvas = surfaceHolder.lockCanvas();
        if (canvas == null) {
            return;
        }

        canvas.scale(canvasScale, canvasScale);
        canvas.drawColor(Color.WHITE); // Background Color

        synchronized (list){
            for (int i = 0; i < list.size(); i++) {
                IDrawable drawable = list.get(i);
                if(drawable != null){ // Defensive programming
                    drawable.Draw(canvas);
                }
            }
        }

        surfaceHolder.unlockCanvasAndPost(canvas);
    }


}
