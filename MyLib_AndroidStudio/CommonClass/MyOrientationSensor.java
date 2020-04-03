package com.example.individualproject.CommonClass;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class MyOrientationSensor implements SensorEventListener {

    public Context context;
    public SensorManager sensorManager;

    public Sensor accelerometer;
    public Sensor magnetometer;

    public float[] accelerometerValues = new float[3];
    public float[] magneticFieldValues = new float[3];

    public float[] values = new float[3];

    MyOrientationSensor(Context context){
        this.context = context;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        assert sensorManager != null;
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    public void reset(){
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
    }

    public void cancel(){
        sensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_MAGNETIC_FIELD:
                magneticFieldValues = sensorEvent.values;
                break;
            case Sensor.TYPE_ACCELEROMETER:
                accelerometerValues = sensorEvent.values;
                break;
        }
        updateOrientation();
        Log.i("","z: " + values[0] + "\tx: " + values[1] + "\ty: " + values[2]);
    }

    private  void updateOrientation() {
        float[] R = new float[9];
        SensorManager.getRotationMatrix(R, null, accelerometerValues, magneticFieldValues);
        SensorManager.getOrientation(R, values);

        values[0] = (float) Math.toDegrees(values[0]);
        values[1] = (float) Math.toDegrees(values[1]);
        values[2] = (float) Math.toDegrees(values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.i("", "onAccuracyChanged()");
    }

}
