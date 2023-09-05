
import java.time.LocalDate;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;


public class Bonus1{
    public static void main (String[] args) throws FileNotFoundException{
        
        // Scanner inScan = new Scanner(MUSC);
        StorageLocation charleston = new StorageLocation("SC71Charleston");
        Customer customer = new Customer("Ajar","2004002323", 500);
        System.out.println(customer.toString());
        Customer henlin = new Customer("henlin","3375401818",100.00);
        //System.out.println(charleston.getUnitbyIndex(0,0));
        System.out.println(charleston.getUnitbyIndex(1, 1));
        
        charleston.getUnitbyIndex(0,0).rentStorageUnit(henlin, LocalDate.now());
        //System.out.println(charleston.getUnitbyIndex(0,0));
        System.out.println(charleston.getUnitbyIndex(1,1));
       
    }

  

}