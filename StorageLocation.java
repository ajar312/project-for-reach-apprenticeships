import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * StorageLocation Object
 * 
 * @author Ajar Duishembieva
 */
public class StorageLocation {

    /** The Storage Location's ID                  */
    private String locationID;
    /** The Storage Location's Storage Unit layout */
    private StorageUnit[][] layout;
    /** The Storage Location's list of Customers   */
    private Customer[] myCustomers;

    /**
     * Constructor for StorageLocation Object
     * 
     * @param locationID           A Storage Location's ID; Must be a specific pattern
     */
    public StorageLocation(String locationID ){
        setLocationID(locationID);
        myCustomers = new Customer[100];
        this.layout = new StorageUnit[12][20];

        StorageUnit standard = new StorageUnit(4,8,12,StorageUnit.UnitType.STANDARD,100.00);

        for(int row = 0; row < 12; row++){
            for(int col = 0; col < layout[0].length; col++){
                layout[row][col] = standard; 
            }
        }
    }

    /**
     * Precondition test to determine if locationID is valid
     * Uses regular expressions to ensure location ID matches a specific pattern
     * 
     * @param  locationID            A Storage Location's ID
     * @return locationID            A Storage Location's ID
     */
    public boolean isValidID(String locationID) {
        return locationID.matches("[A-Z]{2}[0-9]{2}[A-Z]{1}[A-Z a-z]{1,}");
    }

    /**
     * Mutator method that sets the location ID
     * Throws if the locationID does not satisfy the precondition 
     * 
     * @param locationID            A Storage Location's ID
     */
    public void setLocationID(String locationID){
        if (!isValidID(locationID)){
            throw new IllegalArgumentException("Location ID is not valid");
        }
        this.locationID = locationID;
    }

    /**
     * Accessor method that gets the location ID
     * 
     * @return locationID       The Location ID
     */
    public String getLocationID(){
        return locationID;
    }

    /** 
     * Gets the storage unit at the provided indexes
     * 
     * @param row                Index for row
     * @param col                Index for col
     * @return StorageUnit       The StorageUnit at the privded indexes
     */
    public StorageUnit getUnitbyIndex(int row, int col){
        return layout[row][col];
    }
    //Customer[] customers
    /**
     * Method that adds a customer to the CustomerList for a location. For every 100 customers
     * we will make a new larger array that can contain an additional 100 customers.
     * 
     * @param customer               customer objects
     */
    public void addCustomer(Customer customer){
        // if (getCustomerCount() % 100 == 0) {
            // Customer[] myCustomers2 = new Customer[getCustomerCount()+100];
            // System.arraycopy(myCustomers,0,myCustomers2,0, myCustomers.length);
        // }
        
        myCustomers[getCustomerCount()] = customer;
        // myCustomers[0] = customer;

        // int cus = 0;
        // while(customers[cus] != null  &&  cus < customers.length){
        // cus++;
        // }

        // customers[cus] = customer;
    }

    /**
     * Gets a Customer at the provided index
     * 
     * @param pos           The index position
     * @return Customer     The Customer at the index position
     */
    public Customer getCustomerByIndex(int pos){
        return myCustomers[pos];
    }

    /**
     * Gets a Customer count for a Location; if a customer references null then it will not be counted
     * 
     * @return count        The amount of customers found
     */
    public int getCustomerCount(){
        int count = 0;
        while(myCustomers[count] != null && count < myCustomers.length){
            count++;
        }
        return count;
    }

    /**
     * Gets all the customers that the Storage Location has. 
     * 
     * @return      customers at this location
     */
    public Customer[] getMyCustomers(){
        return myCustomers;
    }

    /**
     * Gets all the StorageUnits the Storage Location has.
     * 
     * @return      storage units at this location
     */
    public StorageUnit[][] getLayout(){
        return layout;
    }

    /**
     * Method that gets all the units for specified customers or types.
     * If null is entered for customer then retrieves all empty units
     * If null is entered for Unit Type then retrieves all unit types
     * 
     * @param customer                              customer associated with unit
     * @param type                                  type of storage unit specified
     * @return an array of StorageUnits             array of specified StorageUnits
     */
    public StorageUnit[] getUnitsFor(Customer customer, StorageUnit.UnitType type){
        if (customer != null) {

            int count = 0;
            for(int row = 0; row < layout.length; row++){
                for(int col = 0; col < layout[0].length; col++){
                    if(layout[row][col].getCustomer() == customer){
                        count++;
                    }
                }
            }

            StorageUnit[] unitsForCustomer = new StorageUnit[count];
            int i = 0;

            for(int row = 0; row < layout.length; row++){
                for(int col = 0; col < layout[0].length; col++){
                    if(layout[row][col].getCustomer() == customer){
                        unitsForCustomer[i]= layout[row][col];
                        i++;
                    }
                }
            }
            return unitsForCustomer;
        }

        else if (customer == null && type == null) {
            int count = 0;
            for(int row = 0; row < layout.length; row++){
                for(int col = 0; col < layout[0].length; col++){
                    if(layout[row][col].getCustomer() == customer){
                        count++;
                    }
                }
            }

            StorageUnit[] emptyUnits = new StorageUnit[count];
            int i = 0;

            for(int row = 0; row < layout.length; row++){
                for(int col = 0; col < layout[0].length; col++){
                    if(layout[row][col].getCustomer() == customer){
                        emptyUnits[i]= layout[row][col];
                        i++;
                    }
                }
            }
            return emptyUnits;
        }
        // else if (customer == null && type != null){
        else{
            int count = 0;
            for(int row = 0; row < layout.length; row++){
                for(int col = 0; col < layout[0].length; col++){
                    if(layout[row][col].getCustomer() == customer && layout[row][col].getType() == type){
                        count++;
                    }
                }
            }

            StorageUnit[] emptyUnitsByType = new StorageUnit[count];
            int i = 0;

            for(int row = 0; row < layout.length; row++){
                for(int col = 0; col < layout[0].length; col++){
                    if(layout[row][col].getCustomer() == customer && layout[row][col].getType() == type){
                        emptyUnitsByType[i]= layout[row][col];
                        i++;
                    }
                }
            }
            return emptyUnitsByType;
        }
    }

    /**
     * Method that retrieves an array of empty storage units
     * 
     * @return storageUnit[]            an array of empty storage units
     */
    public StorageUnit[] findEmptyStorageUnits(){
        return getUnitsFor(null,null);
    }

    /**
     * Method that retrieves an array of empty storage units by type
     * 
     * @param type                      a specified unit type
     * @return storageUnit[]            an array of specified empty storage units
     */
    StorageUnit[] findEmptyStorageUnitsByType(StorageUnit.UnitType type){
        return getUnitsFor(null, type);
    }
    
    /**
     * Method that uses a loop and utilizes addCharges() method to charge all customers at a location
     */
    public void chargeMonthlyRent(){
        for(int row = 0; row < layout.length; row++){
            for(int col = 0; col < layout[0].length; col++){
                if(layout[row][col].getCustomer() != null){
                    layout[row][col].getCustomer().addCharges(getUnitbyIndex(row,col).getPrice());
                }
            }
        }
    }

    /**
     * Method that retrieves the number of units for a specified customer; including nulls
     * 
     * @param customer              customer associated with unit
     * @return count                the number of units for a specified customer
     */
    public int getNumberOfUnitsFor(Customer customer){            
        int count = 0;
        for(int row = 0; row < layout.length; row++){
            for(int col = 0; col < layout[0].length; col++){
                if(layout[row][col].getCustomer() == customer){
                    count++;
                }
            }
        }
        return count;
    }

    /** 
     * Method that return total Units at a location
     * 
     * @return total units          total units at a location
     */
    public int getTotalUnits(){
        return layout.length * layout[0].length;
    }

    /**
     * String representation of Storage Location
     * 
     * @return String               String Representation
     */
    public String toString() {
        String description = "";
        description += "Location ID: "                                      + getLocationID() + "\n";
        description += "Total Units: "                                      + getTotalUnits() + "\n";
        description += "Number of Units Availble: "                         + getNumberOfUnitsFor(null) + "\n";        
        description += "Number of Standard Units Available: "               + (getUnitsFor(null, StorageUnit.UnitType.STANDARD)).length + "\n";
        description += "Number of Humidity Controlled Units Available: "    + (getUnitsFor(null, StorageUnit.UnitType.HUMID_CTRL)).length + "\n";
        description += "Number of Temperature Controlled Units Available: " + (getUnitsFor(null, StorageUnit.UnitType.TEMP_CTRL)).length + "\n";
        return description;
    }
}

