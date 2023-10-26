package com.example.forumservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forumservice.Entities.Post;

public interface PostRepository extends JpaRepository<Post , Long> {


}
