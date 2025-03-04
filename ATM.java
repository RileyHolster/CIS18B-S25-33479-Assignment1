public class ATM {
    private String firstName;
    private String lastName;
    private String pin;
    private String email;
    private Float accountBalance;
    
    public ATM(String firstName, String lastName, String pin, String email, Float accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.email = email;
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getAccountBalance() {
        return accountBalance;
    }

    public Float depositMoney(Float amount) {
        this.accountBalance += amount;
        return this.accountBalance;
    }

    public Float withdrawMoney(Float amount) {
        this.accountBalance -= amount;
        return this.accountBalance;
    }







}
