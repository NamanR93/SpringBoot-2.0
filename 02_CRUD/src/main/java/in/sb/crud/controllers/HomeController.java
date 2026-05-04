package in.sb.crud.controllers;

import in.sb.crud.models.Student;
import in.sb.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String greet(){
        return "Hi there!!";
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> list =  studentService.getAllStudent();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable int id){
        Student std =  studentService.getById(id);
        return ResponseEntity.ok(std);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student saved =  studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        Student updated = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
         studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
