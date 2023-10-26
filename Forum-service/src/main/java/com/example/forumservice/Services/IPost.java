package com.example.forumservice.Services;

import org.springframework.web.multipart.MultipartFile;
import com.example.forumservice.Entities.Comment;
import com.example.forumservice.Entities.Post;

import java.io.IOException;
import java.util.List;

public interface IPost {
    public Post addPost (MultipartFile image, Long idForum) throws IOException;

    public Post updatePost (MultipartFile image,Long idForum,Long idPost) throws IOException;

    public void deletePost(Long idPost);

    public Post retrievePostById(Long idPost);
    public List<Post> retrieveAllPosts();

    public List<Comment> getAllCommentsByPost(Long idPost);
}
