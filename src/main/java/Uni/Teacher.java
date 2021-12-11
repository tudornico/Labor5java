package Uni;



import java.util.List;

/**
 * class describing what a teacher is
 */
public class Teacher extends Person {
    private List<Course> courses;
    private int TeacherId;

    @Override
    public String toString() {
        return "Teacher{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", courses=" + courses +
                ", TeacherId=" + TeacherId +
                '}';
    }

    /**
     * constructor for the class teacher
     * @param courses the list of courses that one teacher teaches
     */
    public Teacher(String firstname,String lastname,List<Course> courses, int TeacherId) {
        super(firstname,lastname);
        super.firstname=firstname;
        super.lastname=lastname;
        this.courses = courses;
        this.TeacherId = TeacherId;

    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
