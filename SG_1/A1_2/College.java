package A1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class College {

    private String name;
    // aggregation: College has a collection of Building
    private List<Building> buildings = new ArrayList<>();
    // composition: College owns Courses
    private List<Course> courses = new ArrayList<>();

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // aggregation: just stores the reference
    public void addBuilding(Building building) {
        if (building == null) {
            throw new IllegalArgumentException("Building cannot be null");
        }
        buildings.add(building);
    }

    // composition + constraint: course must be in one of the college's buildings
    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        Building b = course.getBuilding();
        if (!buildings.contains(b)) {
            throw new IllegalArgumentException(
                "Course's building must belong to this college");
        }
        courses.add(course);
    }

    public List<Building> getBuildings() {
        return Collections.unmodifiableList(buildings);
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}
