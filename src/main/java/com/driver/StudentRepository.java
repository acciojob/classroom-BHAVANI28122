package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentdb;

    HashMap<String,Teacher> teacherdb;
    HashMap<String,List<String>> teacher_student_pair;

    public StudentRepository(HashMap<String, Student> studentdb, HashMap<String, Teacher> teacherdb, HashMap<String, List<String>> teacher_student_pair) {
        this.studentdb = studentdb;
        this.teacherdb = teacherdb;
        this.teacher_student_pair = teacher_student_pair;
    }
    public void addstudentdb(Student s){

        studentdb.put(s.getName(),s);

    }
    public void addteacherdb(Teacher t){

        teacherdb.put(t.getName(),t);

    }
    public void student_teacher(String student,String teacher){

        if(studentdb.containsKey(student) && teacherdb.containsKey(teacher)) {
            List<String> teacher_student = new ArrayList<>();
            if(teacher_student_pair.containsKey(teacher))
                teacher_student = teacher_student_pair.get(teacher);
            teacher_student.add(student);
            teacher_student_pair.put(teacher,teacher_student);
        }
    }
    public Student getbyStudentname(String name){
        return studentdb.get(name);
    }
    public Teacher getbyTeachername(String name){
        return teacherdb.get(name);
    }
    public List<String> getstudentsbyteachername(String name){
        List<String> studentlist = new ArrayList<>();
        if(teacher_student_pair.containsKey(name)){
            studentlist =teacher_student_pair.get(name);
        }
        return studentlist;
    }

    public List<String> getallStudents(){

        return new ArrayList<>(studentdb.keySet());
    }
    public void removeteacher(String name){

        List<String> students = new ArrayList<>();
        if(teacher_student_pair.containsKey(name)){
            students = teacher_student_pair.get(name);

            for(String m : students){
                if(studentdb.containsKey(m)){
                    studentdb.remove(m);
                }
            }
            teacher_student_pair.remove(name);
        }
        if(teacherdb.containsKey(name)){
            teacherdb.remove(name);
        }
    }
    public void removeStudentsAndTeachers(){

        List<String> students = new ArrayList<>();
        teacherdb = new HashMap<>();

        for(String t:teacher_student_pair.keySet()){

            for(String m: teacher_student_pair.get(t)){
                students.add(m);
            }
        }
        for(String s:students){
            if(studentdb.containsKey(s)){
                studentdb.remove(s);
            }
        }
    }


}
