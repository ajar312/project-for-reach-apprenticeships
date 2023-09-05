import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StorageLocationTest.
 *
 * @author  Ajar Duishembieva
 */
public class StorageLocationTest
{
    /**
     * Default constructor for test class StorageLocationTest
     */
    public StorageLocationTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testConstructor(){
        StorageLocation testLocation  =  new StorageLocation("WA18Seattle");
        StorageLocation testLocation2 =  new StorageLocation("UT88SaltLakeCity");
        StorageLocation testLocation3 =  new StorageLocation("SC15FOLLYBEACH");
        assertEquals("WA18Seattle"     , testLocation.getLocationID());
        assertEquals("UT88SaltLakeCity", testLocation2.getLocationID());
        assertEquals("SC15FOLLYBEACH"  , testLocation3.getLocationID());
    }

    @Test
    public void testMutator(){
        StorageLocation testLocation = new StorageLocation ("FL00Miami");
        testLocation.setLocationID("DC44Washington");
        assertEquals("DC44Washington", testLocation.getLocationID());        
    }

    @Test
    public void testAddCustomerToList() {
        StorageLocation test = new StorageLocation("FL00Miami");
        Customer billy = new Customer("Billy Shaddock", "2255552222", 10.00);

        test.addCustomer(billy);
        assertEquals(1, test.getCustomerCount());
    }

    @Test
    public void rentUnitToCustomer() {
        StorageLocation test = new StorageLocation("FL00Miami");
        Customer billy = new Customer("Billy Shaddock", "2255552222", 10.00);
        test.addCustomer(billy);
       
        test.getUnitbyIndex(0,0).rentStorageUnit(billy, LocalDate.now());
        assertTrue(test.getUnitbyIndex(0,0).isRented());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorPreconditionState(){
        StorageLocation testLowercaseState   =  new StorageLocation ("la13NewOrleans");
    }

    @Test (expected = IllegalArgumentException.class)
    public void tessConstructorPreconditionID(){
        StorageLocation testDigit            =  new StorageLocation ("TXa6Houston");
    }

    @Test (expected = IllegalArgumentException.class)
    public void tessConstructorPreconditionCity(){
        StorageLocation testLowercaseCity    =  new StorageLocation ("SC71charleston");
    }

    // @Test 
    // public void testAddCustomer(){
    // StorageLocation testLowercaseCity =  new StorageLocation ("SC71Charleston");

    // }

}
