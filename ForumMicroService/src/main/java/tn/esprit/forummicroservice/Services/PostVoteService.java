package tn.esprit.forummicroservice.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;
import tn.esprit.forummicroservice.Entities.PostVote;
import tn.esprit.forummicroservice.Entities.TypeVote;
import tn.esprit.forummicroservice.Repositories.ForumRepository;
import tn.esprit.forummicroservice.Repositories.PostRepository;
import tn.esprit.forummicroservice.Repositories.PostVoteRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostVoteService implements IPosteVote {

    PostVoteRepository postVoteRepository;
    ForumRepository forumRepository;
    PostRepository postRepository;




    @Override
    public void vote(Long idPost, TypeVote typeVote) {
        Post post=postRepository.findById(idPost).orElse(null);
        //Optional<PostVote> optionalVote = postVoteRepository.findByPost(post);
        //if (optionalVote.isPresent()) {
          //  PostVote vote = optionalVote.get();

           /* if (vote.getVoteType().equals(typeVote)) {
                // user is trying to vote again with the same vote type, return error
                System.out.println("You have already " + typeVote.toString().toLowerCase() + "d this post.");
            } else {
                // user is changing his vote
                vote.setVoteType(typeVote);
                postVoteRepository.save(vote);*/

                if (typeVote.equals(TypeVote.UPVOTE)) {
                    post.setLikes(post.getLikes() + 1);
                   // post.setDislikes(post.getDislikes() - 1);
                } else {
                   // post.setLikes(post.getLikes() - 1);
                    post.setDislikes(post.getDislikes() + 1);
                }

                postRepository.save(post);

            }
         /*else {
            // create new vote
            PostVote vote = new PostVote();
            vote.setPost(post);
            vote.setVoteType(typeVote);

            postVoteRepository.save(vote);

            if (typeVote.equals(TypeVote.UPVOTE)) {
                post.setLikes(post.getLikes() + 1);
            } else {
                post.setDislikes(post.getDislikes() + 1);
            }

            postRepository.save(post);

        }*/

    }

