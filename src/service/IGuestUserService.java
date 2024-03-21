package service;

import model.Page;
import model.Post;
import model.User;

import java.util.ArrayList;

public interface IGuestUserService {
    public abstract ArrayList<User> findUsers(String nameOrSurname) throws Exception;
    public abstract ArrayList<Page> findPages(String titleOrDescription) throws Exception;
    public abstract ArrayList<Post> findInfoINPublicPosts(String msg) throws Exception;
}
