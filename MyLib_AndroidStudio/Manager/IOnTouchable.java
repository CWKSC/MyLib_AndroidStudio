package com.example.individualproject.Manager;

public interface IOnTouchable {
    void OnTouchDown(double deltaTime);
    void OnTouchDownAndMove(double deltaTime);
    void OnTouchUp(double deltaTime);
}
