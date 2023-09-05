
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  Ajar Duishembieva
 */
public class CustomerTest
{
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
    public void testFullConstructor(){
        Customer JTK = new Customer("James Tiberius Kirk", "0009370176" , 2228.00);
        assertEquals("James Tiberius Kirk" , JTK.getName());
        assertEquals("0009370176"          , JTK.getPhoneNumber());
        assertEquals(2228.00               , JTK.getBalance(),             0.0001);
    }

    @Test
    public void testPartialConstructor(){
        Customer alien = new Customer("Ellen Ripley", "1234567890");
        assertEquals("Ellen Ripley" , alien.getName());
        assertEquals("1234567890"   , alien.getPhoneNumber());
        assertEquals(0.0            , alien.getBalance(),                   0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionsConstructor(){
        Customer testIllegalPhoneNumber  = new Customer ("Lee Apollo Adama", "AaAaAaAaAa" , 100.00);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionsConstructor2(){
        Customer testIllegalPhoneNumber2 = new Customer ("Kara Thrace", "00158965GP" , 100.00);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionsConstructor3(){
        Customer testPhoneNumberLength   = new Customer ("Gaius Baltar","18001234567" , 100.00);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditionsConstructor4(){
        Customer testEmptyName = new Customer ("" ,"1234567890", 100.00 );                    
    }

    @Test (expected = NullPointerException.class)
    public void testPreconditionsConstructor5(){
        Customer testNullName = new Customer(null, "1234567890", 100.00);
    }

    @Test
    public void testMutatorSetName(){
        Customer test = new Customer("Anakin Skywalker" , "3374745702" , 100.00);
        test.setName("Darth Vader");
        assertEquals("Darth Vader" , test.getName());
    }

    @Test
    public void testPayBalance(){
        Customer buck = new Customer ("Buck Rogers" , "1231231234" , 100.00);
        buck.payBalance(20.00);
        assertEquals(80.00 , buck.getBalance(), 0.0001);
        buck.payBalance(100.00);
        assertEquals(-20.00 , buck.getBalance(), 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalPayment(){
        Customer hal = new Customer ("HAL 9000" , "0000002001" , 9000.00);
        hal.payBalance(0.00);
        hal.payBalance(-0.01);
    }

    @Test
    public void testAddCharges(){
        Customer flash = new Customer ("Flash Gordon" , "0001071934" , 100.00);
        flash.addCharges(900.00);
        assertEquals(1000.00 , flash.getBalance(), 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalChrages(){
        Customer cap = new Customer ("Captain Malcolm Reynolds" , "1234567890", 100.00);
        cap.addCharges(0.00);
        cap.addCharges(-0.01);
    }
}
