package in.sb.socialmediaapp.Service;

import in.sb.socialmediaapp.Models.Post;
import in.sb.socialmediaapp.Repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(@Valid Post post) {
        return postRepository.save(post);
    }
}
