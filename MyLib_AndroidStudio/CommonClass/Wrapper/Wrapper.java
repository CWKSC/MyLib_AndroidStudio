package com.example.individualproject.CommonClass.Wrapper;

// https://stackoverflow.com/questions/430479/how-do-i-use-an-equivalent-to-c-reference-parameters-in-java/431152#431152
// https://stackoverflow.com/questions/2806545/does-java-have-something-like-cs-ref-and-out-keywords
public class Wrapper<T> {
    private T ref;
    public Wrapper(){

    }
    public Wrapper(T object){
        ref = object;
    }
    public T g() { return ref; }
    public T s( T e ){ this.ref = e; return ref;}

    public String toString() {
        return ref.toString();
    }

}