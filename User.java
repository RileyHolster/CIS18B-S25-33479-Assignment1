import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class User {
    public void main(String[] args) throws IOException {
        ATM atm = null;
        boolean stayInLoop = true;
        while (stayInLoop) {

            if (atm == null){
                try {
                    atm = signInOrCreateNewAtm();
                } catch (IOException exception) {
                    System.out.println("There was an error creating your account, try again");
                    continue;
                }
            }

            displayOptions(atm);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String response = bufferedReader.readLine();

            switch (response) {
                case "1":
                    boolean depositSuccessful = false;
                    while(!depositSuccessful) {
                        System.out.println("How much would you like to deposit?");
                        String amount = bufferedReader.readLine();
                        Float convertedAmount = isValidNumber(amount);
                        if(convertedAmount != null) {
                            atm.depositMoney(convertedAmount);
                            displayAccountBalance(atm);
                            depositSuccessful = true;                           
                        } else {
                            System.out.println("That's not a valid number!");
                        }
                    }
                    break;
                
                case "2":
                    boolean withdrawSuccessful = false;
                    while (!withdrawSuccessful) {
                        System.out.println("How much do you want to withdraw?");
                        String amount = bufferedReader.readLine();
                        Float convertedAmount = isValidNumber(amount);
                        if(convertedAmount != null) {
                            atm.withdrawMoney(convertedAmount);
                            displayAccountBalance(atm);
                            withdrawSuccessful = true;                           
                        } else {
                            System.out.println("That's not a valid number!");
                        }
                    }
                    break;

                case "3":
                    displayAccountBalance(atm);
                    break;

                case "4":
                    stayInLoop = false;
                    break;
                
                default:
                    System.out.println("Not a valid option, try again.");
                    break;
                
            }   
        }
    }
    private ATM signInOrCreateNewAtm() throws IOException {
        System.out.println("Welcome to the Bank!");
        System.out.println("Let's get started and create and account for you.");
        System.out.println("What's your first name?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();

        System.out.println("What's your last name?");
        String lastName = reader.readLine();

        System.out.println("What's your email?");
        String email = reader.readLine();

        

        String pin = "";
        boolean isValidPin = false;
        while (!isValidPin){
            System.out.println("What is your pin?");
            pin = reader.readLine();

            if (pin.length() != 4) {
                Float integer = isValidNumber(pin);
                
                if (integer == null) {
                    System.out.println("Pin was invalid, needs to be all digits");
                } else {
                    isValidPin = true;
                }

            } else {
                System.out.println("PIN was not 4 digits long.");
            }
        }

        ATM atm = new ATM(firstName, lastName, pin, email, (float) 0);
        
        System.out.println("Would you like to make a deposit? Type yes if so");
        String answer = reader.readLine();

        if("yes".equalsIgnoreCase(answer)) {
            System.out.println("Great! How much?");
            String amount = reader.readLine();

            Float covertedAmount = isValidNumber(amount);
            if (covertedAmount != null) {
                atm.depositMoney(covertedAmount);
            } else {
                System.out.println("That's not a valid amount!");
            }
        }

        return atm;

    }

    private Float isValidNumber(String value) {
        try{
            Float isValid = Float.parseFloat(value);
            return isValid;
        } catch (Exception exception) {
            return null;
        }
    }

    private void displayOptions(ATM atm) {
        System.out.println("Hello " + atm.getFirstName() + " what can the Bank do?");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");


    }

    private void displayAccountBalance(ATM atm) {
        System.out.println("Your new balance is $" + atm.getAccountBalance());
    }

}
