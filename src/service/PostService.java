package service;

import model.PostType;

public interface PostService {
    public abstract void publishPost(PostType type, String msg) throws Exception;

}
