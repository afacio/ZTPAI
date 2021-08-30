package ztpai.ztpai.exception.forum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ForumNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ForumNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String forumNotFoundHandler(ForumNotFoundException ex) {
        return ex.getMessage();
    }
}
