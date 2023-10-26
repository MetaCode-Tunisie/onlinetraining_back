package com.example.forumservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.forumservice.Entities.Forum;
import com.example.forumservice.Entities.Post;
import com.example.forumservice.Services.IForum;

import java.util.List;


@RestController
@AllArgsConstructor
public class ForumController {
    private IForum iForumService;


@GetMapping("/user/getForumById/{idForum}")
    public Forum getForumById(@PathVariable Long idForum){
    return iForumService.getForumById(idForum);
}


@GetMapping("/user/getAllForums")
    public List<Forum> getAllForums(){
    return iForumService.getAllForums();
}


@GetMapping("/admin/addForum")
    public Forum addForum(@RequestBody Forum forum){
    return iForumService.addForum(forum);
}


@PostMapping("/admin/updateForum")
    public Forum updateForum(@RequestBody Forum forum){
    return iForumService.updateForum(forum);
}


@DeleteMapping("/admin/deleteForum/{idForum}")
    public void deleteForum(@PathVariable Long idForum){
    iForumService.deleteForum(idForum);
}


@GetMapping("/user/getAllPostsByForum/{idForum}")
    public List<Post> getAllPostsByForum(@PathVariable Long idForum){
    return iForumService.getAllPostsByForum(idForum);
}




}
