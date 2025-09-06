package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.aspect.ToLog;
import ru.geekbrains.model.Comment;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment){
        System.out.println("Comment published: " + comment.getText());
        return "SUCCESS";
    }

//    public void method1(){
//        System.out.println("Method 1 executed");
//    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
