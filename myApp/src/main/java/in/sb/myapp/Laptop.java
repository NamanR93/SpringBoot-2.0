package in.sb.myapp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public void compiler(){
        System.out.println("works");
    }
}
