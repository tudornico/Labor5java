package Repo;

import Uni.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherRepoTest {

    @Test
    void create() {
        Teacher teacher = new Teacher("Cristian","Matei",null,5);
        TeacherRepo repo = new TeacherRepo();
        repo.create(teacher);
        assert (repo.getAll().size()==4);
        repo.delete(teacher);
    }

    @Test
    void getAll() {
        TeacherRepo repo = new TeacherRepo();
        assert(repo.getAll().size()==3);
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
        Teacher teacher = new Teacher("Cristian","Matei",null,5);
        TeacherRepo repo = new TeacherRepo();
        repo.create(teacher);
        assert(repo.getAll().size()==4);
        repo.delete(teacher);
        assert (repo.getAll().size()==3);
    }
}