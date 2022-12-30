package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository sr;

    public void addstudent(Student s){
        sr.addstudentdb(s);
    }
    public void addteacher(Teacher t){
        sr.addteacherdb(t);
    }
    public void student_teacher(String student,String teacher){
        sr.student_teacher(student, teacher);
    }
    public Student getbyStudentname(String name){
       return sr.getbyStudentname(name);
    }
    public Teacher getbyTeachername(String name){
        return sr.getbyTeachername(name);
    }
    public List<String> getstudentsbyteachername(String name){
        return sr.getstudentsbyteachername(name);
    }
    public List<String> getallstudent(){
        return sr.getallStudents();
    }
    public void removeteacher(String name){
        sr.removeteacher(name);
    }
    public void removeStudentsAndTeachers(){
        sr.removeStudentsAndTeachers();
    }
}
