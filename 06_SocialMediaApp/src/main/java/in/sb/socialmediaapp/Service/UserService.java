package in.sb.socialmediaapp.Service;

import in.sb.socialmediaapp.Models.User;

import in.sb.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

//    private static List<User> users = new ArrayList<>();
//
//    static{
//        users.add(new User(1,"Adam", LocalDate.now().minusYears(30)));
//        users.add(new User(2,"Eve", LocalDate.now().minusYears(25)));
//        users.add(new User(3,"Jim", LocalDate.now().minusYears(20)));
//    }

    @Autowired
    private UserRepository userRepository;
    public List<User> getAll(){

        return userRepository.findAll();
    }

    public User findOne(int id) {

//        User user =  users.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
//        return user;
        return userRepository.findById(id).orElse(null);
    }


    public User save(User user) {

//         users.add(user);
//
//        return user;
        return userRepository.save(user);
    }

    public void deleteById(int id) {

//        users.removeIf(p->p.getId().equals(id));
        userRepository.deleteById(id);
    }
}
