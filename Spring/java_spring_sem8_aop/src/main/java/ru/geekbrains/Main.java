package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.ProjectConfiguration;
import ru.geekbrains.model.Comment;
import ru.geekbrains.service.CommentService;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var service = c.getBean(CommentService.class);

        Comment  comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Eva");
        String value = service.publishComment(comment);

//        service.method1();
    }
}