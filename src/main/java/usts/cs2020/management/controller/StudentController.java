package usts.cs2020.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.management.model.Login;
import usts.cs2020.management.model.Student;
import usts.cs2020.management.service.StudentService;

import java.util.List;

@Repository
@RequestMapping(value = "/student",method = {RequestMethod.GET,RequestMethod.POST})
public class StudentController {

    @Autowired
    StudentService studentService;

    //注册
    @PostMapping("/register")
    public ResponseEntity registerNewStudent(@RequestParam("name")String name,
                                             @RequestParam("number")String number,
                                             @RequestParam("classname")String classname,
                                             @RequestParam("role")String role,
                                             @RequestParam("email")String email,
                                             @RequestParam("password")String password){
        //将数据发布到controller之前已经在应用程序本身中检查了
        if(name.isEmpty() || number.isEmpty() || classname.isEmpty() || email.isEmpty() || password.isEmpty()){
            return new ResponseEntity<>("请完成所有的信息填写", HttpStatus.BAD_REQUEST);
        }

        //加密 解密
        String hashed_password = BCrypt.hashpw(password,BCrypt.gensalt());

        //注册新用户
        int result = studentService.registerNewStudentServiceMethod(name, number, classname, role,email, hashed_password);
        if(result != 1){
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }
    //登陆
    @PostMapping("/login")
    public ResponseEntity authenticateStudent(@RequestBody Login login){

        //Get Student Name
        List<String> studentname = studentService.checkStudentName(login.getName());
        //check if name is empty
        if(studentname.isEmpty() || studentname == null){
            return new ResponseEntity("name does not exist",HttpStatus.NOT_FOUND);
        }

        //Get hashed Student Password
        String hashed_password = studentService.checkStudentPasswordByName(login.getName());
        //Validate Student Password
        if(!BCrypt.checkpw(login.getPassword(),hashed_password)){
            return new ResponseEntity("Incorrect name or password",HttpStatus.BAD_REQUEST);
        }

        Student student = studentService.GetStudentDetailsByName(login.getName());
        return new ResponseEntity(student,HttpStatus.OK);
    }
}
