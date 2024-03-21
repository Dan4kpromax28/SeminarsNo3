package service;

import model.Post;
import model.PostType;

public interface PostService {
    public abstract Post publishPost(PostType type, String msg) throws Exception;

}
