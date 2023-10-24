package tn.esprit.forummicroservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.forummicroservice.Entities.Comment;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;
import tn.esprit.forummicroservice.Services.IPost;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
public class PostController {

    private IPost iPostService;


    @PostMapping(path="/addPost/{idForum}",consumes = {MULTIPART_FORM_DATA_VALUE  })
    public Post addPost (@RequestParam MultipartFile image,@PathVariable Long idForum) throws IOException{
        return iPostService.addPost(image,idForum);
    }

    @PostMapping(path = "/updatePost/{idForum}/{idPost}",consumes = {MULTIPART_FORM_DATA_VALUE  })
    public Post updatePost (@RequestParam MultipartFile image,@PathVariable Long idForum, @PathVariable Long idPost) throws IOException{
        return iPostService.updatePost(image,idForum,idPost);
    }

    @DeleteMapping("/deletePost/{idPost}")
    public void deletePost(@PathVariable Long idPost){
        iPostService.deletePost(idPost);
    }

    @GetMapping("/retrievePostById/{idPost}")
    public Post retrievePostById(@PathVariable Long idPost){
        return iPostService.retrievePostById(idPost);
    }
    @GetMapping("/retrieveAllPosts")
    public List<Post> retrieveAllPosts(){
        return iPostService.retrieveAllPosts();
    }

    @GetMapping("/getAllCommentsByPost/{idPost}")
    public List<Comment> getAllCommentsByPost(@PathVariable Long idPost){
        return iPostService.getAllCommentsByPost(idPost);
    }
}
