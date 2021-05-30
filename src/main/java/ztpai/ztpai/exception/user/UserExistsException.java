package ztpai.ztpai.exception.user;

public class UserExistsException extends RuntimeException{

    public UserExistsException(){
        super("User of this attribute already exists.");
    }
}
