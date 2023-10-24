package tn.esprit.forummicroservice.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.forummicroservice.Entities.Comment;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;
import tn.esprit.forummicroservice.Repositories.CommentRepository;
import tn.esprit.forummicroservice.Repositories.ForumRepository;
import tn.esprit.forummicroservice.Repositories.PostRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService implements IComment{

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    @Override
    public Comment addComment(Comment comment, Long idPost) {
        Post post = postRepository.findById(idPost).orElse(null);

        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }



    @Override
    public void deleteComment(Long idComment) {

        commentRepository.deleteById(idComment);
    }

    @Override
    public List<Comment> retrieveAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment retrieveCommentById(Long idComment) {
        return commentRepository.findById(idComment).orElse(null);
    }
}
