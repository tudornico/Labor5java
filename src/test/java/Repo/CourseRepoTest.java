package Repo;

import Uni.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepoTest {

    @Test
    void create() {
        Course course = new Course("Analiza",null,40,5,null);
        CourseRepo repo = new CourseRepo();
        repo.create(course);
        assert(repo.getAll().size()==4);
        repo.delete(course);
    }

    @Test
    void getAll() {
        Course course = new Course("Analiza",null,40,5,null);
        CourseRepo repo = new CourseRepo();
        assert(repo.getAll().size()==3);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        Course course = new Course("Analiza",null,40,5,null);
        CourseRepo repo = new CourseRepo();
        repo.create(course);
        repo.delete(course);
        assert(repo.getAll().size()==3);
    }
}