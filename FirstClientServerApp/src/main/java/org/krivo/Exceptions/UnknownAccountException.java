package org.krivo.Exceptions;

public class UnknownAccountException extends RuntimeException{
    public UnknownAccountException(String msg){
        super(msg);
    }
}
