package org.jilali;

public class ZeroSubscribersException extends RuntimeException{
    public ZeroSubscribersException(){
        super("You have no subscribers");
    }
}
