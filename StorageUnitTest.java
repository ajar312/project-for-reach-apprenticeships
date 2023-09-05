import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StorageUnitTest.
 *
 * @author  Ajar Duishembieva
 * @version (a version number or a date)
 */
public class StorageUnitTest
{
    /**
     * Default constructor for test class StorageUnitTest
     */
    public StorageUnitTest()
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
    public void testConstructorNullCustomer(){
        StorageUnit test = new StorageUnit(4,8,12,StorageUnit.UnitType.STANDARD,100.00);
        assertEquals(4, test.getLength());
        assertEquals(8, test.getWidth());
        assertEquals(12,test.getHeight());
        assertEquals(StorageUnit.UnitType.STANDARD, test.getType());
        assertEquals(null, test.getCustomer());
    }

    @Test
    public void testConstructorWithCustomer(){
        Customer gort = new Customer("Gort", "1234567890", 100.00);
        StorageUnit test = new StorageUnit(4,8,12,StorageUnit.UnitType.HUMID_CTRL,gort,100,LocalDate.now());
        assertEquals(4, test.getLength());
        assertEquals(8, test.getWidth());
        assertEquals(12,test.getHeight());
        assertEquals(StorageUnit.UnitType.HUMID_CTRL, test.getType());
        assertEquals(gort, test.getCustomer());
        assertEquals(100.00, test.getPrice(), 0.000001);
    }

    @Test 
    public void testreleaseCustomer(){
        Customer mario = new Customer("Mario","9876543210",100.00);
        StorageUnit test = new StorageUnit(4,8,12,StorageUnit.UnitType.STANDARD, mario,100.00,LocalDate.now());
        test.releaseStorageUnit();
        assertEquals(null, test.getCustomer());
    }

    @Test
    public void testRentToCustomer(){
        Customer mario = new Customer("Mario","9876543210",100.00);
        Customer luigi = new Customer("Luigi","1234567890",100.00);
        StorageUnit test = new StorageUnit(4,8,12,StorageUnit.UnitType.STANDARD, mario,100.00,LocalDate.now());
        test.releaseStorageUnit();
        test.rentStorageUnit(luigi,LocalDate.now());
        assertEquals(luigi, test.getCustomer());
    }

    @Test
    public void testEmptyUnit(){
        StorageUnit test = new StorageUnit(4,8,12,StorageUnit.UnitType.STANDARD,100.00);
        assertFalse(test.isRented());
    }

    @Test
    public void testRentedUnit(){
        Customer bowser = new Customer ("Bowser" , "1234565432", 100.00);
        StorageUnit test = new StorageUnit(4,8,12,StorageUnit.UnitType.STANDARD,bowser, 100.00, LocalDate.now());
        assertTrue(test.isRented());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionIllegalLengthZero(){
        StorageUnit test = new StorageUnit(0,8,12,StorageUnit.UnitType.STANDARD,100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionIllegalLengthOdd(){
        StorageUnit test = new StorageUnit(1,8,12,StorageUnit.UnitType.STANDARD,100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionIllegalWidthOdd(){
        StorageUnit test = new StorageUnit(4,9,12,StorageUnit.UnitType.STANDARD,100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionIllegalWidthZero(){
        StorageUnit test = new StorageUnit(4,0,12,StorageUnit.UnitType.STANDARD,100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionIllegalHeightZero(){
        StorageUnit test = new StorageUnit(4,8,0,StorageUnit.UnitType.STANDARD,100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionIllegalHeight2Odd(){
        StorageUnit test = new StorageUnit(4,8,1,StorageUnit.UnitType.STANDARD,100);
    }
}
