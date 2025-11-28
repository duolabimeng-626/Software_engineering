package A1_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instructor {

    private String name;
    private Department department;
    private List<Subject> subjects = new ArrayList<>();

    public Instructor(String name, Department department) {
        this.name = name;
        department.addInstructor(this);
    }

    void setDepartment(Department department) {
        this.department = department;
    }

    public void addSubject(Subject subject) {
        if (subjects.size() >= 3) {
            throw new IllegalStateException("Instructor can teach at most 3 subjects");
        }
        subjects.add(subject);
        subject.addInstructor(this);
    }

    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }
}
