package in.sb.socialmediaapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2,message = "name should have atLeast 2 characters")
    //@JsonProperty("user_name")
    private String name;

    @Past(message = "Birth date should be in the past")
   // @JsonProperty("birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

//    public User(Integer id, String name, LocalDate birthDate) {
//        this.id = id;
//        this.name = name;
//        this.birthDate = birthDate;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    @Override
//    public String toString() {
//        return "UserBean{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", birthDate=" + birthDate +
//                '}';
//    }
}
