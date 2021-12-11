package Repo;

import Uni.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements ICrudRepository<Teacher> {
    public TeacherRepo(){

    }


    @Override
    public Teacher create(Teacher obj) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Teacher
            String Query = "insert into University.Teacher(FirstName, LastName, TeacherID) Values ("+"'"+obj.getFirstname()+"'" + ","+"'"+obj.getLastname()+"'"+","+"'"+obj.getTeacherId()+"'"+")";
            statement=con.createStatement();
            int rowcount = statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public List<Teacher> getAll(){
        List<Teacher> allTeachers = new ArrayList<>();
        //setting up the connection
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "select * From University.Teacher";
            statement=con.createStatement();
            ResultSet resultSet= statement.executeQuery(Query);

            while(resultSet.next()){
                Teacher parsingTeacher = new Teacher("","",null,0);
                parsingTeacher.setFirstname(resultSet.getString("FirstName"));
                parsingTeacher.setLastname(resultSet.getString("LastName"));
                //adding all the students into the student list
                allTeachers.add(parsingTeacher);
                parsingTeacher=null;
            }


            for (Teacher teacher :allTeachers
                ) {
               String joins = "select * from  University.Course " +
                        "inner join University.TeacherCourse" +
                        " on Course.CourseId=University.TeacherCourse.CourseId" +
                        " inner join University.Teacher" +
                        " on TeacherCourse.TeacherId=Teacher.TeacherID" +
                        " where University.TeacherCourse.TeacherId =" + teacher.getTeacherId();
                Statement stm = con.createStatement();
                ResultSet Courseset = stm.executeQuery(joins);
                List<Course> courseList = new ArrayList<>();
                while(Courseset.next()){
                    Course parsingCourse = new Course("",null,0,0,null);
                    parsingCourse.setName(Courseset.getString("Name"));
                    parsingCourse.setMaxEnrollment(Courseset.getInt("MaxEnrollment"));
                    parsingCourse.setCredits(Courseset.getInt("Credits"));
                    parsingCourse.setCourseId(Courseset.getInt("CourseId"));
                    courseList.add(parsingCourse);
                    parsingCourse=null;
                }
                teacher.setCourses(courseList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allTeachers;


    }

    @Override
    public Teacher update(Teacher obj) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "update University.Teacher set FirstName = " + obj.getFirstname() + " where TeacherId ="+obj.getTeacherId();
            statement=con.createStatement();
            int rowcount= statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Teacher obj) {

        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Access0740188658")) {
            Statement statement = null;
            //getting all the values from Student
            String Query = "delete from University.Teacher where TeacherId = "+obj.getTeacherId();
            statement=con.createStatement();
            int rowcount= statement.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


