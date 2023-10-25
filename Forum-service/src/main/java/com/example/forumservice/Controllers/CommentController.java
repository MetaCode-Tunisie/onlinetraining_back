package com.example.forumservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.forumservice.Entities.Comment;
import com.example.forumservice.Services.IComment;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CommentController {

    private IComment iCommentService;

    @PostMapping("/admin/addComment/{idPost}")
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

    @GetMapping("/user/retrieveCommentById/{idComment}")
    public Comment retrieveCommentById(@PathVariable Long idComment){
        return iCommentService.retrieveCommentById(idComment);
    }
}
