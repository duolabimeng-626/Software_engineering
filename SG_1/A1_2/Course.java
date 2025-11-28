package A1_2;

public class Course {

    private String code;
    private String title;
    // each course must be held in some building
    private Building building;

    public Course(String code, String title, Building building) {
        if (building == null) {
            throw new IllegalArgumentException("Course must be held in a building");
        }
        this.code = code;
        this.title = title;
        this.building = building;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Building getBuilding() {
        return building;
    }
}
