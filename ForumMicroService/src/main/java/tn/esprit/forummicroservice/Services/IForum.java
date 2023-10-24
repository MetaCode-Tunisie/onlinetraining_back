package tn.esprit.forummicroservice.Services;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IForum {

    public Forum getForumById(Long idForum);



    public List<Forum> getAllForums();


    public Forum addForum(Forum forum);


    public Forum updateForum(Forum forum);


    public void deleteForum(Long idForum);


    public List<Post> getAllPostsByForum(Long idForum);
}
