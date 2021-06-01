package ztpai.ztpai.exception.forum;

public class ForumNotFoundException extends RuntimeException {
    public ForumNotFoundException(Long id){
        super("Could not find forum: " + id);
    }

}
