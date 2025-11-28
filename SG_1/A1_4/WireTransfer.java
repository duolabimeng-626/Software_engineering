package A1_4;

public class WireTransfer extends Payment {

    private String bankID;
    private String bankName;

    public WireTransfer(double amount, String bankID, String bankName) {
        super(amount);
        this.bankID = bankID;
        this.bankName = bankName;
    }
}
