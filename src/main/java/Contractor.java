public class Contractor {

    private String Name;
    private String SecondName;
    private String status;
    private String accountNumber;

    public Contractor(String name, String status, String accountNumber) {
        Name = name;
        this.status = status;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return Name;
    }

    public String getStatus() {
        return status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
