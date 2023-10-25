package com.example.forumservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.forumservice.Entities.Comment;
import com.example.forumservice.Entities.Post;
import com.example.forumservice.Services.IPost;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class PostController {

    private IPost iPostService;


    @PostMapping(path="/admin/addPost/{idForum}",consumes = {MULTIPART_FORM_DATA_VALUE  })
    public Post addPost (@RequestParam MultipartFile image,@PathVariable Long idForum) throws IOException{
        return iPostService.addPost(image,idForum);
    }

    @PostMapping(path = "/admin/updatePost/{idForum}/{idPost}",consumes = {MULTIPART_FORM_DATA_VALUE  })
    public Post updatePost (@RequestParam MultipartFile image,@PathVariable Long idForum, @PathVariable Long idPost) throws IOException{
        return iPostService.updatePost(image,idForum,idPost);
    }

    @DeleteMapping("/admin/deletePost/{idPost}")
    public void deletePost(@PathVariable Long idPost){
        iPostService.deletePost(idPost);
    }

    @GetMapping("/user/retrievePostById/{idPost}")
    public Post retrievePostById(@PathVariable Long idPost){
        return iPostService.retrievePostById(idPost);
    }
    @GetMapping("/user/retrieveAllPosts")
    public List<Post> retrieveAllPosts(){
        return iPostService.retrieveAllPosts();
    }

    @GetMapping("/user/getAllCommentsByPost/{idPost}")
    public List<Comment> getAllCommentsByPost(@PathVariable Long idPost){
        return iPostService.getAllCommentsByPost(idPost);
    }
}
