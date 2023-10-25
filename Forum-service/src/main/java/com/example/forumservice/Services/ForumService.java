package com.example.forumservice.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.forumservice.Entities.Forum;
import com.example.forumservice.Entities.Post;
import com.example.forumservice.Repositories.ForumRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ForumService implements IForum{

    private ForumRepository forumRepository;

    @Override
    public Forum getForumById(Long idForum) {
        return forumRepository.findById(idForum).orElse(null);
    }

    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    @Override
    public Forum addForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public Forum updateForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public void deleteForum(Long idForum) {
        forumRepository.deleteById(idForum);
    }

    @Override
    public List<Post> getAllPostsByForum(Long idForum) {
        Forum forum=forumRepository.findById(idForum).orElse(null);
        Set<Post> posts=forum.getPosts();
        List<Post> listPosts=new ArrayList<>();
        for (Post p : posts){

            listPosts.add(p);

        }
        return listPosts;
    }
}
