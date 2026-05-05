package in.sb.socialmediaapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "SocialMediaApp is running. Try /users or /swagger-ui.html";
    }
}

