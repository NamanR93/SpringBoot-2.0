package in.sb.myapp3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "hello!!";
    }

    @RequestMapping("/about")
    public String about(){
        return "about page.";
    }
}
