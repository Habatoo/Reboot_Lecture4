package valiullin.exceptions;

public class MyRuntimeExeption extends RuntimeException{

    public MyRuntimeExeption(String msg){
        super("MyRuntimeExeption: " + msg);
    }
}
