package tn.esprit.forummicroservice.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;
import tn.esprit.forummicroservice.Repositories.ForumRepository;

import java.io.IOException;
import java.util.*;

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
