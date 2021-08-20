package valiullin.exceptions;

public class MyExeption extends Exception{

    public MyExeption(String msg){
        super("MyExeption: " + msg);
    }
}
