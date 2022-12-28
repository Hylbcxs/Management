package usts.cs2020.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cs2020.management.model.Student;
import usts.cs2020.management.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public int registerNewStudentServiceMethod(String name,String number,String classname,String role,String email,String password){
        return studentRepository.registerNewStudent(
                name, number, classname, role, email, password);
    }

    public List<String> checkStudentName(String name){
        return studentRepository.checkStudentName(name);
    }

    public String checkStudentPasswordByName(String name){
        return studentRepository.checkStudentPasswordByName(name);
    }

    public Student GetStudentDetailsByName(String name){
        return studentRepository.GetStudentDetailsByName(name);
    }
}
