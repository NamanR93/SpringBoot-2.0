package in.sb.crud.service;

import in.sb.crud.models.Student;
import in.sb.crud.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Student getById(int id) {
        return studentRepo.findById(id).orElse(null);
    }


    public Student addStudent(Student student) {
       return  studentRepo.save(student);
    }

    public void deleteStudent(int id) {
         studentRepo.deleteById(id);
    }

    public Student updateStudent(int id, Student student) {

        Student existing = studentRepo.findById(id).orElse(null);
        existing.setName(student.getName());
        existing.setMarks(student.getMarks());

        return studentRepo.save(existing);


    }
}
