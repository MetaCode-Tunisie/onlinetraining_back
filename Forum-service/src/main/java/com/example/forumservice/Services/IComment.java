package com.example.forumservice.Services;

import com.example.forumservice.Entities.Comment;

import java.util.List;

public interface IComment {

    public Comment addComment(Comment comment, Long idPost);

    public Comment updateComment (Comment Comment);

    public void deleteComment (Long idComment);

    public List<Comment> retrieveAllComments();

    public Comment retrieveCommentById(Long idComment);
}
