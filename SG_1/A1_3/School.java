package A1_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {

    private String name;
    private List<Department> departments = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public void addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("department cannot be null");
        }
        departments.add(department);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student cannot be null");
        }
        students.add(student);
        student.setSchool(this);
    }

    public List<Department> getDepartments() {
        return Collections.unmodifiableList(departments);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
