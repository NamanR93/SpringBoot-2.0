package in.sb.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired                         // field injection
    @Qualifier("laptop")
    private Computer comp;

//    public Dev(Laptop laptop){           // contruction injection
//        this.laptop = laptop;
//    }

//    @Autowired
//    public void setLaptop(Laptop laptop){    //setter injection
//        this.laptop = laptop;
//    }

    public void build(){

        comp.compiler();
        System.out.println("lets build something");
    }
}
