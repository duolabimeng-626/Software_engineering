package A1_4;

import java.time.LocalDate;

public class Credit extends Payment {

    private String number;
    private String type;
    private LocalDate expireDate;

    public Credit(double amount, String number, String type, LocalDate expireDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expireDate = expireDate;
    }
}
