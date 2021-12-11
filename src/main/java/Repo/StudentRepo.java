package Repo;

import Uni.Course;
import Uni.ICrudRepository;
import Uni.IMemoryRepository;
import Uni.Student;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements ICrudRepository<Student>{


    public StudentRepo() {
    }

    @Override
    public Student create(Student obj) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/University", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "insert into Student (FirstName,LastName,StudentId,Credits) Values ("+"'"+obj.getFirstname()+"'" +","+"'"+obj.getLastname()+"'"+","+"'"+obj.getStudentId()+"'"+","+"'"+obj.getTotalCredits()+"'"+");";
            statement=con.createStatement();
            int rowcount=statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public List<Student> getAll(){
    List<Student> allStudents = new ArrayList<>();
    //setting up the connection
        try (Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
        Statement statement = null;
        //getting all the values from Student
        String Query = "select * From University.Student"; // getting the values of the parameters except the lists
        statement=con.createStatement();
        ResultSet resultSet= statement.executeQuery(Query);



        while(resultSet.next()){
            Student parsingStudent = new Student("","",0,0,null);
            parsingStudent.setFirstname(resultSet.getString("FirstName"));
            parsingStudent.setLastname(resultSet.getString("LastName"));
            parsingStudent.setTotalCredits(resultSet.getInt("Credits"));
            //adding all the students into the student list
            allStudents.add(parsingStudent);
            parsingStudent=null;
        }



            //parsing each student and setting his courses
            for (Student student :allStudents
            ) {

                String joins = "select * from  University.Course " +
                        "inner join University.StudentCourse" +
                        " on Course.CourseId=StudentCourse.CourseId " +
                        "inner join University.Student " +
                        "on StudentCourse.StudentId=Student.StudentId " +
                        "where StudentCourse.StudentId =" + student.getStudentId();
                Statement stm = con.createStatement();
                ResultSet Courseset = stm.executeQuery(joins);
                List<Course> courseList = new ArrayList<>();
                while(Courseset.next()){
                    Course pasrsingCourse = new Course("",null,0,0,null);
                    pasrsingCourse.setName(Courseset.getString("Name"));
                    pasrsingCourse.setCredits(Courseset.getInt("Credits"));
                    pasrsingCourse.setMaxEnrollment(Courseset.getInt("MaxEnrollment"));
                    pasrsingCourse.setCourseId(Courseset.getInt("CourseId"));
                    courseList.add(pasrsingCourse);
                    pasrsingCourse=null;
                }
                student.setEnrolledCourses(courseList);
            }
    } catch (SQLException e) {
        e.printStackTrace();
    }


            return allStudents;
}

    @Override
    public Student update(Student obj) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "update University.Student set Credits = " + obj.getTotalCredits() + "where studentId = "+obj.getStudentId();
            statement=con.createStatement();
            int rowcount= statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Student obj) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = " delete from University.Student where studentId = "+obj.getStudentId();
            statement=con.createStatement();
             int rowcount=statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
