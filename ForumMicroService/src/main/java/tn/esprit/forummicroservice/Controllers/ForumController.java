package tn.esprit.forummicroservice.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;
import tn.esprit.forummicroservice.Services.IForum;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class ForumController {
    private IForum iForumService;


@GetMapping("/getForumById/{idForum}")
    public Forum getForumById(@PathVariable Long idForum){
    return iForumService.getForumById(idForum);
}


@GetMapping("/getAllForums")
    public List<Forum> getAllForums(){
    return iForumService.getAllForums();
}


@PostMapping("/addForum")
    public Forum addForum(@RequestBody Forum forum){
    return iForumService.addForum(forum);
}


@PostMapping("/updateForum")
    public Forum updateForum(@RequestBody Forum forum){
    return iForumService.updateForum(forum);
}


@DeleteMapping("/deleteForum/{idForum}")
    public void deleteForum(@PathVariable Long idForum){
    iForumService.deleteForum(idForum);
}


@GetMapping("/getAllPostsByForum/{idForum}")
    public List<Post> getAllPostsByForum(@PathVariable Long idForum){
    return iForumService.getAllPostsByForum(idForum);
}




}
