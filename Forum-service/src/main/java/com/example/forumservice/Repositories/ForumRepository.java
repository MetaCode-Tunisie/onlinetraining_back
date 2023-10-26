package com.example.forumservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forumservice.Entities.Forum;

public interface ForumRepository extends JpaRepository<Forum, Long> {
}
