package A1_4;

public class AliPay extends Payment {

    private String number;

    public AliPay(double amount, String number) {
        super(amount);
        this.number = number;
    }
}
