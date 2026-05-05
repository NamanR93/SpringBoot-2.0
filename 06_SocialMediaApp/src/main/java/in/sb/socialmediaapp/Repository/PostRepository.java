package in.sb.socialmediaapp.Repository;

import in.sb.socialmediaapp.Models.Post;
import in.sb.socialmediaapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
