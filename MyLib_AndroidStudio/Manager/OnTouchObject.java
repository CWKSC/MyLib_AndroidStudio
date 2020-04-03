package com.example.individualproject.Manager;

public interface OnTouchObject {
    void OnTouchDown(double deltaTime);
    void OnTouchDownAndMove(double deltaTime);
    void OnTouchUp(double deltaTime);
}
