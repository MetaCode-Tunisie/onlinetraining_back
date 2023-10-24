package tn.esprit.forummicroservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.forummicroservice.Entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post , Long> {


}
