package com.example.forumservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forumservice.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
