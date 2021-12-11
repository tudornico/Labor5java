package Registration;

import Repo.CourseRepo;
import Repo.StudentRepo;
import Repo.TeacherRepo;
import Uni.Course;
import Uni.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {

    @Test
    void register() {
        CourseRepo courseRepo= new CourseRepo();
        TeacherRepo teacherRepo = new TeacherRepo();
        StudentRepo studentRepo = new StudentRepo();
        RegistrationSystem registrationSystem = new RegistrationSystem(courseRepo,teacherRepo,studentRepo);
        Course course = new Course("DatenBanken",null,60,6,null);
        course.setCourseId(1);
        Student student = new Student("Tudor","Nicolaescu",1,60,null);
        assert(!registrationSystem.register(course,student));
    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        CourseRepo courseRepo= new CourseRepo();
        TeacherRepo teacherRepo = new TeacherRepo();
        StudentRepo studentRepo = new StudentRepo();
        RegistrationSystem registrationSystem = new RegistrationSystem(courseRepo,teacherRepo,studentRepo);
        //assert(registrationSystem.retrieveCoursesWithFreePlaces().size()==3);
    }

    @Test
    void retrieveStudentsEnrolledforaCourse() {
        CourseRepo courseRepo= new CourseRepo();
        TeacherRepo teacherRepo = new TeacherRepo();
        StudentRepo studentRepo = new StudentRepo();
        RegistrationSystem registrationSystem = new RegistrationSystem(courseRepo,teacherRepo,studentRepo);
        Course course = new Course("MAP",null,60,5,null);
        course.setCourseId(2);
        registrationSystem.retrieveStudentsEnrolledforaCourse(course);
        assert(registrationSystem.retrieveStudentsEnrolledforaCourse(course).size()==1);
    }

    @Test
    void getAllCourses() {
        CourseRepo courseRepo= new CourseRepo();
        TeacherRepo teacherRepo = new TeacherRepo();
        StudentRepo studentRepo = new StudentRepo();
        RegistrationSystem registrationSystem = new RegistrationSystem(courseRepo,teacherRepo,studentRepo);
        assert(registrationSystem.getAllCourses().size()==3);
    }
}