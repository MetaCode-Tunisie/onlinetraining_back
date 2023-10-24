package tn.esprit.forummicroservice.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.forummicroservice.Entities.Comment;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;
import tn.esprit.forummicroservice.Entities.PostVote;
import tn.esprit.forummicroservice.Repositories.CommentRepository;
import tn.esprit.forummicroservice.Repositories.ForumRepository;
import tn.esprit.forummicroservice.Repositories.PostRepository;
import tn.esprit.forummicroservice.Repositories.PostVoteRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PostService implements IPost{

 private PostRepository postRepository;
 private ForumRepository forumRepository;
 private CommentRepository commentRepository;
 private PostVoteRepository postVoteRepository;

 @Override
 public Post addPost (MultipartFile image, Long idForum) throws IOException {
     Post post = new Post();
     Forum forum = forumRepository.findById(idForum).orElse(null);
     String filename = StringUtils.cleanPath(image.getOriginalFilename());
     if (filename.contains("..")) {
         System.out.println("!!! Not a valid File");
     }
     post.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
     post.setForum(forum);
     return postRepository.save(post);
 }

 @Override
 public Post updatePost (MultipartFile image,Long idForum, Long idPost) throws IOException{
     Post post = postRepository.findById(idPost).orElse(null);
     Forum forum = forumRepository.findById(idForum).orElse(null);
     String filename = StringUtils.cleanPath(image.getOriginalFilename());
     if (filename.contains("..")) {
         System.out.println("!!! Not a valid File");
     }
     post.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
     post.setForum(forum);
     return postRepository.save(post);
 }

 @Override
 public void deletePost(Long idPost){

     Post post = postRepository.findById(idPost).orElse(null);
     for(Comment c :post.getComments()){
         commentRepository.deleteById(c.getId());
     }
     for(PostVote p :post.getPostVotes()){
         postVoteRepository.deleteById(p.getVoteId());
     }
     postRepository.deleteById(idPost);
 }

 @Override
 public Post retrievePostById(Long idPost){
     return postRepository.findById(idPost).orElse(null);
 }

 @Override
 public List<Post> retrieveAllPosts(){
     return postRepository.findAll();
 }

 @Override
    /*public List<Comment> getAllCommentsByPost(Long idPost) {
        Post post=postRepository.findById(idPost).orElse(null);
        Set<Comment> comments=post.getComments();
        List<Comment> listComments=new ArrayList<>();
        for (Comment c : comments){
            listComments.add(c);
        }
        return listComments;
    }*/
 public List<Comment> getAllCommentsByPost(Long idPost) {
     Post post = postRepository.findById(idPost).orElse(null);

     if (post == null) {
         return new ArrayList<>(); // Retourner une liste vide si le post n'existe pas
     }

     Set<Comment> comments = post.getComments();
     List<Comment> listComments = new ArrayList<>();

     for (Comment c : comments) {
         listComments.add(c);
     }

     return listComments;
 }






}




