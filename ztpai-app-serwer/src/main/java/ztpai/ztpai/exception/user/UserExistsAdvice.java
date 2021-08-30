package ztpai.ztpai.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExistsAdvice {

    @ResponseBody
    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.CREATED) //TODO sprawdzić czy jest ot doby wyjątek
    public String userExistsHandler(UserExistsException ex) {
        return ex.getMessage();
    }
}
