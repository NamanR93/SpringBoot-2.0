package in.sb.socialmediaapp.Repository;

import in.sb.socialmediaapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
