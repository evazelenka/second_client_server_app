package org.krivo.Exceptions;

public class ServerIsDownException extends RuntimeException{
    public ServerIsDownException(String msg){
        super(msg);
    }
}
