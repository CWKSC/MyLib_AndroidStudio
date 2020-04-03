package com.example.individualproject.CommonClass;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class Vector2 {

    public float x;
    public float y;

    // Constructor //

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vector2(Vector2 vector2) {
        x = vector2.x;
        y = vector2.y;
    }

    public Vector2 Clone() {
        return new Vector2(this);
    }

    // Assign //
    public Vector2 Assign(Vector2 vector2){
        x = vector2.x;
        y = vector2.y;
        return this;
    }

    // Add //

    /** return new Vector2 */
    public static Vector2 Add(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }
    public Vector2 Add(Vector2 add){
        x += add.x;
        y += add.y;
        return this;
    }
    public Vector2 Add(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }


    // Sub //

    /** return new Vector2 */
    public static Vector2 Sub(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }
    public Vector2 Sub(Vector2 add){
        x -= add.x;
        y -= add.y;
        return this;
    }
    public Vector2 Sub(float x, float y){
        this.x -= x;
        this.y -= y;
        return this;
    }


    // Mult //

    /** return new Vector2 */
    public static Vector2 MultScalar(Vector2 a, float scalar){
        return new Vector2(a.x * scalar, a.y * scalar);
    }
    public Vector2 MultScalar(float scalar){
        x *= scalar;
        y *= scalar;
        return this;
    }


    // Divide //

    /** return new Vector2 */
    public static Vector2 DivideScalar(Vector2 a, float scalar){
        return new Vector2(a.x / scalar, a.y / scalar);
    }
    public Vector2 DivideScalar(float scalar){
        x /= scalar;
        y /= scalar;
        return this;
    }


    // Get Unit Vector //

    /** return new Vector2 */
    public static Vector2 GetUnitVector(Vector2 vector2){
        float length = vector2.Length();
        return new Vector2(vector2.x / length, vector2.y / length);
    }
    /** return new Vector2 */
    public Vector2 GetUnitVector(){
        float length = Length();
        return new Vector2(x / length, y / length);
    }


    // Direction Vector //

    public static Vector2 GetZero(){
        return new Vector2(0, 0);
    }


    /** up is (0, -1), not (0 , 1) */
    public static Vector2 GetUp(){
        return new Vector2(0, -1);
    }
    public static Vector2 GetDown(){
        return new Vector2(0, 1);
    }
    public static Vector2 GetLeft(){
        return new Vector2(-1, 0);
    }
    public static Vector2 GetRight(){
        return new Vector2(1, 0);
    }


    // Length //

    public static float Length(Vector2 vector2){
        return vector2.Length();
    }
    public float Length(){
        return (float) Math.sqrt(x*x + y*y);
    }


    public static Vector2 AToB(Vector2 a, Vector2 b) {
        return Sub(b, a);
    }


    public static double Distance(Vector2 a, Vector2 b) {
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.sqrt(dx*dx + dy*dy);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Vector2 rand(float xMin, float xMax, float yMin, float yMax){
        return new Vector2(MyMath.random(xMin, xMax), MyMath.random(yMin, yMax));
    }

    @NonNull
    @Override
    public String toString() {
        return "x: "+ x +" y: "+ y;
    }
}
