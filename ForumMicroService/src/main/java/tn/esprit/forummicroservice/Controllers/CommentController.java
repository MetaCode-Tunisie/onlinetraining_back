package tn.esprit.forummicroservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.forummicroservice.Entities.Comment;
import tn.esprit.forummicroservice.Services.IComment;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class CommentController {

    private IComment iCommentService;

    @PostMapping("/addComment/{idPost}")
    public Comment addComment(@RequestBody Comment comment, @PathVariable Long idPost){
        return iCommentService.addComment(comment,idPost);
    }

    @PutMapping("/updateComment")
    public Comment updateComment (@RequestBody Comment comment){
        return iCommentService.updateComment(comment);
    }

    @DeleteMapping("/deleteComment/{idComment}")
    public void deleteComment (@PathVariable Long idComment){
        iCommentService.deleteComment(idComment);
    }

    @GetMapping("/retrieveAllComments")
    public List<Comment> retrieveAllComments(){
        return iCommentService.retrieveAllComments();
    }

    @GetMapping("/retrieveCommentById/{idComment}")
    public Comment retrieveCommentById(@PathVariable Long idComment){
        return iCommentService.retrieveCommentById(idComment);
    }
}
