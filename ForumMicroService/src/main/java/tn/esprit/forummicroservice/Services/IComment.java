package tn.esprit.forummicroservice.Services;

import tn.esprit.forummicroservice.Entities.Comment;
import tn.esprit.forummicroservice.Entities.Forum;

import java.util.List;

public interface IComment {

    public Comment addComment(Comment comment, Long idPost);

    public Comment updateComment (Comment Comment);

    public void deleteComment (Long idComment);

    public List<Comment> retrieveAllComments();

    public Comment retrieveCommentById(Long idComment);
}
