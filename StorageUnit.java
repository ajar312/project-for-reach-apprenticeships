import java.time.LocalDate;
/**
 * Storage Unit Object
 * 
 * @author Ajar Duishembieva
 */
public class StorageUnit{
   /** Enumerated Unit Types for a storage unit  */
    public static enum UnitType{STANDARD, HUMID_CTRL, TEMP_CTRL}

    /** The storage unit's width                 */
    private int width;
    /** The storage unit's length                */
    private int length;
    /** The storage unit's height                */
    private int height;
    /** The storage unit's type                  */
    private UnitType type;
    /** A Customer object associated with the StorageUnit (renting the Storage Unit) */
    private Customer customer;
    /** The storage unit's standard price        */
    private double price = 100.00;
    /** The date a storage unit was rented out   */   
    private LocalDate date;

    /**
     * Constructor for StorageUnit
     * 
     * @param width                 Width of a Storage  Unit;  must be factor of four
     * @param length                Length of a Storage Unit; must be a factor of four
     * @param height                Height of a Storage Unit; must be a factor of two
     * @param type                  Type of Storage Unit
     * @param theCustomer           Customer renting a Storage Unit
     * @param price                 Price of a Storage Unit; must be a positive value
     * @param date             Start Date of Storage Unit
     */
    public StorageUnit(int length, int width, int height, UnitType type, Customer theCustomer, double price, LocalDate date){
        this.width  = isValidLW(width);
        this.length = isValidLW(length);
        this.height = isValidHeight(height);
        this.type   = type;
        this.customer = theCustomer;
        this.price = isNotNegative(price);
        this.date = date;
    }

    /**
     * Constructor for unrented Storage Unit. Customer and date will be set to null.
     * 
     * @param width                 Width of a Storage  Unit;  must be factor of four
     * @param length                Length of a Storage Unit; must be a factor of four
     * @param height                Height of a Storage Unit; must be a factor of two
     * @param type                  Type of Storage Unit
     * @param price                 Price of a Storage Unit; must be a positive value
     */
    public StorageUnit(int length, int width, int height, UnitType type, double price){
        this(length, width, height, type, null, price, null);
    }
    
    /**
     * Accessor method that gets the width of a Storage Unit
     * 
     * @return width                width of storage unit
     */
    public int getWidth(){
        return width;
    }

    /**
     * Accessor method that gets the length of a Storage Unit
     * 
     * @return length               length of storage unit
     */
    public int getLength(){
        return length;
    }

    /**
     * Accessor method that gets the height of a Storage Unit
     * 
     * @return height               height of storage unit
     */
    public int getHeight(){
        return height;
    }

    /**
     * Accessor method that gets the type of a Storage Unit
     * 
     * @return type                 type of storage unit
     */
    public UnitType getType(){
        return type;
    }

    /**
     * Accessor method that gets the customer of a Storage Unit
     * 
     * @return customer             customer of storage unit
     */
    public Customer getCustomer(){
        return customer;
    }

    /**
     * Accessor method that gets the price of a Storage Unit
     * 
     * @return price                price of storage unit
     */
    public double getPrice(){
        return price;
    }

    /**
     * Mutator method that sets the price of a Storage Unit
     * 
     * @param price                  price of a storage unit
     */
    public void setPrice(double price){
        this.price = isNotNegative(price);
    }

    /**
     * Accessor method that gets the date a Storage Unit was rented out
     * 
     * @return date                date storage unit was rented out
     */
    public LocalDate getDate(){
        return date;
    }

    /**
     * Helper function which acts as a precondition check; throws if the value is less than zero or
     * if the value is not a factor of four
     * 
     * @param value         The length or width value
     * @return value        The length of width value
     */
    public int isValidLW(int value){
        if (value % 4 != 0 || value <= 0){
            throw new IllegalArgumentException("Your measurement must be a multiple of four");
        }
        return value;
    }

    /**
     * Method which assigns a customer and date to a Storage Unit. (represents a storage unit being rented by a customer)
     * 
     * @param customer    The customer assigned to Storage Unit         
     * @param date        The date assigned to Storage Unit
     */
    public void rentStorageUnit(Customer customer, LocalDate date){
        this.customer = isNotNullCustomer(customer);
        this.date = isNotNullDate(date);
    }
    
    /**
     * Method which checks if a Storage Unit is rented (Unit is considered rented if a customer has been assigned)
     * 
     * @return true if a customer has been assigned to the storage unit
     */
    public boolean isRented() {
        return (this.customer != null);
    }
    
    /**
     * Method which assigns a null value to customer and date for a Storage Unit. (represents a storage unit being released/unrented)
     */
    public void releaseStorageUnit(){
        this.customer = null;
        this.date     = null;
    }

    /**
     * Helper function which acts as a precondition check; throws if the height is less than zero or
     * if the height is not a factor of two
     * 
     * @param height        The height value
     * @return height       The height value
     */
    public int isValidHeight(int height){
        if (height % 2 != 0 || height <= 0){
            throw new IllegalArgumentException("Your height measurement must be a multiple of two");
        }
        return height;
    }

    /**
     * Helper function which acts as a precondition check; throws if the value is negative
     * 
     * @param value          An integer value
     * @return value         An integer value
     */
    public double isNotNegative(double value){
        if (value < 0){
            throw new IllegalArgumentException("Your value cannot be negative");
        }
        return value;
    }

    /**
     * Helper function which acts as a precondition check; throws if UnitType is null
     * 
     * @param  type         A Storage Unit Type
     * @return type         A Storage Unit Type
     */
    public UnitType isNotNullType(UnitType type){
        if (type == null) {
            throw new IllegalArgumentException("Unit Type cannot be null");
        }
        return type;
    }

    /**
     * Helper function which acts as a precondition check; throws if Customer is null
     * 
     * @param customer      A Customer
     * @return Customer     A Customer
     */
    public Customer isNotNullCustomer(Customer customer){
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        return customer;
    }

    /**
     * Helper function which acts as a precondition check; throws if date is null
     * 
     * @param date      A date
     * @return date     A date
     */
    public LocalDate isNotNullDate(LocalDate date){
        if (type == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date;
    }
    
    public String toString(){
        String description = "";
        description += "Type of Storage Unit: " + getType() + "\n";
        description += "Dimensions of Storage Unit (WxLxH): " + getWidth() + " x " + getLength() + " x " + getHeight() + "\n";
        if (customer != null){
            description += "Storage Unit Rented by: " + getCustomer().getName() + "\n";
            description += "Starting Rental Date: " + getDate() + "\n";
        }
        else {
            description += "Storage Unit is Unrented" + "\n";
        }
        return description;        
    } 
}