package A1_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

    private String name;
    private School school;
    private List<Instructor> instructors = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    public Department(String name, School school) {
        this.name = name;
        this.school = school;
        school.addDepartment(this);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        instructor.setDepartment(this);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setDepartment(this);
    }

    public List<Instructor> getInstructors() {
        return Collections.unmodifiableList(instructors);
    }

    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }
}
