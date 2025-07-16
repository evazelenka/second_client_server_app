package org.krivo.Exceptions;

public class WrongServerException extends RuntimeException{
    public WrongServerException(String msg){
        super(msg);
    }
}
