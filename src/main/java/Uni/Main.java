package Uni;

import Repo.CourseRepo;
import Repo.StudentRepo;
import Repo.TeacherRepo;
import Uni.Student;
import com.sun.source.tree.CompilationUnitTree;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        StudentRepo studentRepo = new StudentRepo();
        CourseRepo courseRepo = new CourseRepo();
        TeacherRepo teacherRepo = new TeacherRepo();
        Student obj = new Student("FN","LN",0,30,null);
        System.out.println("insert into Student (FirstName,LastName,StudentId,Credits) Values ("+obj.getFirstname() + ","+obj.getLastname()+","+obj.getStudentId()+","+obj.getTotalCredits()+")");
//        System.out.println(studentRepo.getAll());
//
//        System.out.println(courseRepo.getAll());
//
//        System.out.println(teacherRepo.getAll());

    }

}
