/**
 * Customer Object
 * 
 * @author  Ajar Duishembieva

 */
public class Customer{

    /** The Customer's name                 */
    private String name;
    /** The Customer's phone number         */
    private String phoneNumber;
    /** The Customer's account balance      */
    private double accountBalance;

    /**
     * Constructor for Customer Object
     * 
     * @param name              Name for Customer
     * @param phoneNumber       Phone Number for Customer
     * @param accountBalance    Account Balance for Customer
     */
    public Customer(String name , String phoneNumber , double accountBalance) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setBalance(accountBalance);            
    }

    /**
     * Constructor for Customer Object without balance. The balance will be set to zero
     * 
     * @param name              Name for Customer
     * @param phoneNumber       PhoneNumber for Customer
     */
    public Customer(String name, String phoneNumber){
        this(name, phoneNumber, 0);
    }

    /** 
     * Mutator for setting the name of a customer. Name cannot be null or empty.
     * 
     * @param name              Name for Customer
     */
    public void setName(String name){
        if (name.isEmpty() || name == null){
            throw new IllegalArgumentException("Name can't be empty or null");
        }
        this.name = name;
    }

    /**
     * Accessor for getting the name of a customer
     * 
     * @return name             Name for Customer
     */
    public String getName(){
        return name;
    }

    /**
     * Precondition test to determine if phone number is valid
     * Uses regular expressions to ensure phone number matches a specific pattern: 10 digits in length
     * 
     * @param phoneNumber       phoneNumber for Customer
     * @return phoneNumber      phoneNumber for Customer
     */
    public boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.matches("[0-9]{10}");
    }

    /**
     * Mutator method that sets the Phone Number 
     * Throws if the phone number is not valid 10 digit continuous sequence
     * 
     * @param phoneNumber       phone number for Customer
     */
    public void setPhoneNumber(String phoneNumber){
        if (!isValidPhoneNumber(phoneNumber)){
            throw new IllegalArgumentException("Phone number is not valid.");
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Accessor that gets the phoneNumber
     * 
     * @return phoneNumber       phone number for Customer
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Mutator method that sets the account balance for Customer object
     * 
     * @param accountBalance     account balance for Customer
     */
    private void setBalance(double accountBalance){
        this.accountBalance = accountBalance;
    }

    /**
     * Accessor method that gets the account balance
     * 
     * @return accountBalance    account balance for Customer
     */
    public double getBalance(){
        return accountBalance;
    }

    /**
     * Method for paying the balance for a Customer. Accepts a payment amount as a parameter and subtracts that amount
     * from the Customer's balance. Then the new balance is set. Throws if the payment amount is negative or zero.
     * 
     * @param payment            payment amount
     */
    public void payBalance(double payment){
        if (payment <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        double balance = getBalance()- payment; 
        setBalance(balance);
    }

    /**
     * Method for adding charges to a Customer balance. Accpets a charge amount as a parameter and adds that amount
     * to the Customer's balance. Then the new balance is set. Throws if the charge amount is negative or zero.
     * 
     * @param charges            charged amount
     */
    public void addCharges(double charges){
        if (charges <= 0){
            throw new IllegalArgumentException("Charged amount must be greater than zero");
        }
        double balance = getBalance() + charges;
        setBalance(balance);
    }

    /**
     * String representatoin of Customer object
     * 
     * @return String
     */
    public String toString() {
        String description = "";
        description += "Customer Name: "   +   getName()        + "\n";
        description += "Phone Number: "    +   getPhoneNumber() + "\n";
        description += "Account Balance: " +   getBalance()     + "\n";
        description += "\n";
        return description;
    }
}