package Uni;


import java.util.List;

/**
 * class extending the person and also describing what student
 */
public class Student extends Person {

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", studentId=" + studentId +
                ", totalCredits=" + totalCredits +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }

    private long studentId;
    private int totalCredits;
    private List<Course> enrolledCourses;

    /**
     * constructor for the Student class
     * @param studentId id for a student
     * @param totalCredits the number of credits accumulated along the years by the student
     * @param enrolledCourses the courses that one student takes currently
     */
    public Student(String Firstname,String Lastname,long studentId, int totalCredits, List<Course> enrolledCourses) {
        super(Firstname,Lastname);
        super.firstname=Firstname;
        super.lastname=Lastname;
        this.studentId = studentId;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
