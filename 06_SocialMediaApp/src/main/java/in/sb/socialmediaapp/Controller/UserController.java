package in.sb.socialmediaapp.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import in.sb.socialmediaapp.Models.Post;
import in.sb.socialmediaapp.Models.User;
import in.sb.socialmediaapp.Service.PostService;
import in.sb.socialmediaapp.Service.UserService;

import in.sb.socialmediaapp.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;



    @GetMapping("/users")
    public List<User> getAllUsers(){

        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveOne(@PathVariable int id){

        User user =  userService.findOne(id);
        if(user == null){
                throw new UserNotFoundException("id: "+ id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

            User saved = userService.save(user);

            URI Location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saved)
                    .toUri();
        return ResponseEntity.created(Location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable int id){
        userService.deleteById(id);
    }


    @GetMapping("/users/{id}/posts")
    public List<Post> getPostsForUser(@PathVariable int id){
        User user =  userService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id: "+ id);
        }
        return user.getPosts();

    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        User user =  userService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id: "+ id);
        }
        post.setUser(user);
        Post savedPost =  postService.save(post);
        URI Location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(Location).build();

    }
}
