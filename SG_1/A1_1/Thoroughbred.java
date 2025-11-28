package A1_1;

import java.time.Year;

public class Thoroughbred {

    // attributes (all private)
    private Thoroughbred mother;
    private Thoroughbred father;
    private int birthYear;

    // constructor
    public Thoroughbred(Thoroughbred mother, Thoroughbred father, int birthYear) {
        this.mother = mother;
        this.father = father;
        this.birthYear = birthYear;
    }

    // operations
    public int getCurrentAge() {
        int currentYear = Year.now().getValue();
        return currentYear - birthYear;
    }

    public Thoroughbred getFather() {
        return father;
    }

    public Thoroughbred getMother() {
        return mother;
    }

    // 如果需要，也可以增加 birthYear 的 getter
    public int getBirthYear() {
        return birthYear;
    }
}
