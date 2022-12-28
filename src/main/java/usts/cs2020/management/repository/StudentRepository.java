package usts.cs2020.management.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usts.cs2020.management.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query(value = "SELECT name FROM students where name = :name",nativeQuery = true)
    List<String> checkStudentName(@Param("name") String name);

    @Query(value = "SELECT password FROM students WHERE name = :name",nativeQuery = true)
    String checkStudentPasswordByName(@Param("name") String name);

    //根据姓名查找信息
    @Query(value = "SELECT * FROM students WHERE name = :name",nativeQuery = true)
    Student GetStudentDetailsByName(@Param("name") String name);
    //插入数据
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO students(name,number,classname,role,email,password) VALUES(:name,:number,:classname,:role,:email,:password)",nativeQuery = true)
    int registerNewStudent(@Param("name") String name,
                           @Param("number") String number,
                           @Param("classname") String classname,
                           @Param("role") String role,
                           @Param("email") String email,
                           @Param("password") String password);
}
