package A1_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subject {

    private String name;
    private Department department;
    private List<Instructor> instructors = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Subject(String name, Department department) {
        this.name = name;
        department.addSubject(this);
    }

    void setDepartment(Department department) {
        this.department = department;
    }

    void addInstructor(Instructor instructor) {
        if (!instructors.contains(instructor)) {
            instructors.add(instructor);
        }
    }

    public void enrollStudent(Student student) {
        if (student.getSubjects().size() >= 5) {
            throw new IllegalStateException("Student can take at most 5 subjects");
        }
        students.add(student);
        student.addSubjectInternal(this);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
