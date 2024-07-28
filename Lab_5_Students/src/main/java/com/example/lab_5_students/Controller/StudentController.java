package com.example.lab_5_students.Controller;

import com.example.lab_5_students.Api.ApiResponse;
import com.example.lab_5_students.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<Student>();


    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student added");
    }

    @GetMapping("/get/{index}")
    public Student getStudent(@PathVariable int index) {
        return students.get(index);
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody Student student, @PathVariable int index) {
        students.set(index, student);
        return new ApiResponse("Student updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Student deleted");
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @GetMapping("/name/{index}")
    public String getName(@PathVariable int index) {
        return students.get(index).getName();
    }

    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index){
        return students.get(index).getAge();
    }

    @GetMapping("/college/degree/{index}")
    public String getDegree(@PathVariable int index){
        return students.get(index).getDegree();
    }

    @GetMapping("/study/status/{index}")
    public boolean getStatus(@PathVariable int index){
        return students.get(index).getStatus();
    }







}
