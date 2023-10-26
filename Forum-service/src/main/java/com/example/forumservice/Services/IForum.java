package com.example.forumservice.Services;

import com.example.forumservice.Entities.Forum;
import com.example.forumservice.Entities.Post;

import java.util.List;

public interface IForum {

    public Forum getForumById(Long idForum);



    public List<Forum> getAllForums();


    public Forum addForum(Forum forum);


    public Forum updateForum(Forum forum);


    public void deleteForum(Long idForum);


    public List<Post> getAllPostsByForum(Long idForum);
}
