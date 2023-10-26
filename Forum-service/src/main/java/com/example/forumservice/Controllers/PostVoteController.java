package com.example.forumservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.forumservice.Entities.TypeVote;
import com.example.forumservice.Services.IPosteVote;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class PostVoteController {

    private IPosteVote iPosteVoteService;




    @GetMapping("/user/like/{postId}")
    public ResponseEntity<String> likePost(@PathVariable("postId") Long postId) {
        iPosteVoteService.vote(postId, TypeVote.UPVOTE);
        //comment
        return new ResponseEntity<>( HttpStatus.OK);
    }

    //response
    @GetMapping("/user/dislike/{postId}")
    public ResponseEntity<String> dislikePost(@PathVariable("postId") Long postId) {
        iPosteVoteService.vote(postId, TypeVote.DOWNVOTE);
        return new ResponseEntity<>( HttpStatus.OK);


    }
}
