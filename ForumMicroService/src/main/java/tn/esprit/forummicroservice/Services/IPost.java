package tn.esprit.forummicroservice.Services;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.forummicroservice.Entities.Comment;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

public interface IPost {
    public Post addPost (MultipartFile image, Long idForum) throws IOException;

    public Post updatePost (MultipartFile image,Long idForum,Long idPost) throws IOException;

    public void deletePost(Long idPost);

    public Post retrievePostById(Long idPost);
    public List<Post> retrieveAllPosts();

    public List<Comment> getAllCommentsByPost(Long idPost);
}
