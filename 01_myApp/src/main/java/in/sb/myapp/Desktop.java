package in.sb.myapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Desktop implements Computer {

    public void compiler(){

        System.out.println("works fasterr..");
    }
}
