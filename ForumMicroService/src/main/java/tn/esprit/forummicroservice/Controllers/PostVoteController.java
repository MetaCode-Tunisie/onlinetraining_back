package tn.esprit.forummicroservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.forummicroservice.Entities.TypeVote;
import tn.esprit.forummicroservice.Services.IPosteVote;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
public class PostVoteController {

    private IPosteVote iPosteVoteService;




    @GetMapping("/like/{postId}")
    public ResponseEntity<String> likePost(@PathVariable("postId") Long postId) {
        iPosteVoteService.vote(postId, TypeVote.UPVOTE);
        //comment
        return new ResponseEntity<>( HttpStatus.OK);
    }

    //response
    @GetMapping("/dislike/{postId}")
    public ResponseEntity<String> dislikePost(@PathVariable("postId") Long postId) {
        iPosteVoteService.vote(postId, TypeVote.DOWNVOTE);
        return new ResponseEntity<>( HttpStatus.OK);


    }
}
