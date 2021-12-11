package Repo;

import Uni.Student;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {

    @org.junit.jupiter.api.Test
    void create() {
        Student testStudent = new Student("Andrei", "Pop", 5, 55, null);
        StudentRepo testrepo = new StudentRepo();
        testrepo.create(testStudent);
        assert (testrepo.getAll().size() == 4);
        assert (testrepo.getAll().get(3).getTotalCredits() == 55);
        testrepo.delete(testStudent);
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        StudentRepo repo = new StudentRepo();
        assert (repo.getAll().size() == 3);
    }

    @org.junit.jupiter.api.Test
    void update() {


    }

    @org.junit.jupiter.api.Test
    void delete() {

        StudentRepo repo = new StudentRepo();

        Student teststudent = new Student("Ivan", "Turbica", 3, 60, null);
        repo.delete(teststudent);
        assert (repo.getAll().size() == 2);
        teststudent.setFirstname("Ivan");
        teststudent.setLastname("Turbinca");
        teststudent.setStudentId(3);
        teststudent.setTotalCredits(60);
        repo.create(teststudent);
    }
}
