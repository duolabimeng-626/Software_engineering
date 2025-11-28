package A1_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private String name;
    private School school;
    private List<Subject> subjects = new ArrayList<>();

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
        school.addStudent(this);
    }

    void setSchool(School school) {
        this.school = school;
    }

    public void enroll(Subject subject) {
        subject.enrollStudent(this);
    }

    void addSubjectInternal(Subject subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
        }
    }

    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }
}
