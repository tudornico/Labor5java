package Repo;

import Uni.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepo implements ICrudRepository<Course> {


    public CourseRepo() {

    }

    @Override
    public Course create(Course obj) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "insert into University.Course(Name, Credits, MaxEnrollment, CourseId) Values ("+"'"+obj.getName()+"'" + ","+"'"+obj.getCredits()+"'"+","+"'"+obj.getMaxEnrollment()+"'"+","+"'"+obj.getCourseId()+"'"+")";
            statement=con.createStatement();
            int rowcount= statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public List<Course> getAll() {

        List<Course> allCourses= new ArrayList<>();
        //setting up the connection
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "select * From University.Course";
            statement=con.createStatement();
            ResultSet resultSet= statement.executeQuery(Query);
            Course parsingCourse = new Course("",null,0,0,null);
            while(resultSet.next()){
                parsingCourse.setName(resultSet.getString("Name"));
                parsingCourse.setCredits(resultSet.getInt("Credits"));
                parsingCourse.setMaxEnrollment(resultSet.getInt("MaxEnrollment"));
                parsingCourse.setCourseId(resultSet.getInt("CourseId"));
                //adding all the courses into the student list
                allCourses.add(parsingCourse);
            }
            //setting the students for each course
            for (Course course:allCourses
                 ) {

                String joins= " select * from University.Student" +
                        " inner join StudentCourse " +
                        "on University.Student.StudentId = StudentCourse.StudentId" +
                        " inner join Course on StudentCourse.CourseId = Course.CourseId" +
                        " where Course.CourseId = "+course.getCourseId();

                Statement stm=con.createStatement();
                ResultSet Studentset = stm.executeQuery(joins);//getting all the studnts enrolled in a course
                List<Student> studentList = new ArrayList<>();
                while(Studentset.next()){
                    Student parsingStudent = new Student("","",0,0,null);
                    parsingStudent.setFirstname(Studentset.getString("FirstName"));
                    parsingStudent.setLastname(Studentset.getString("LastName"));
                    parsingStudent.setTotalCredits(Studentset.getInt("Credits"));
                    parsingStudent.setStudentId(Studentset.getInt("StudentId"));
                    studentList.add(parsingStudent);
                    parsingStudent=null;
                }
                course.setStudentsEnrolled(studentList);

            //setting the teacher for each course

            String currentteacher="Select * From Teacher" +
                    " Inner Join TeacherCourse " +
                    "on Teacher.TeacherID = TeacherCourse.TeacherId" +
                    " Inner Join Course " +
                    "on TeacherCourse.CourseId = "+ course.getCourseId();
            ResultSet teacher=stm.executeQuery(currentteacher);
            Teacher parsingTeacher = new Teacher("","",null,0);
            parsingTeacher.setFirstname(teacher.getString("FirstName"));
            parsingTeacher.setLastname(teacher.getString("LastName"));
            parsingTeacher.setTeacherId(teacher.getInt("TeacherID"));
            course.setTeacher(parsingTeacher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCourses;
    }



    @Override
    public Course update(Course obj) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "update University.Course set Name = " + obj.getName() + " where CourseId = "+obj.getCourseId();
            statement=con.createStatement();
            int rowcount= statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Course obj) {

        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Course
            String Query = "delete from University.Course where CourseId = "+obj.getCourseId();
            statement=con.createStatement();
            int rowcount= statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
