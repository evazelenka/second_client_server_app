package org.example;

import java.io.IOException;
import java.io.InputStream;

public class ReaderFile {
    public static void main(String[] args) {
        System.out.println(new ReaderFile().read());
    }
    
    private String read(){
        String result;
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("test.txt");
        ){
            result = new String(resourceAsStream.readAllBytes());
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
