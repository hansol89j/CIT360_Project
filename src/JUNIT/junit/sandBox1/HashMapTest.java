package JUNIT.junit.sandBox1;



import org.junit.*;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by hansoljeong on 2015. 11. 5..
 */
public class HashMapTest {
    Residents testResidents;
    ResidentsBean hansol, jade, noBody, noFirstName, noLastName;

    //Several tests need similar objects created before they can run.
    // Annotating a public void method with @Before causes that method to be run before each Test method.
    @Before
    public void setUp() throws Exception{
        testResidents = new Residents();

        hansol = new ResidentsBean("Jeong", "Hansol", 26, 1);
        jade = new ResidentsBean("Jade", "Lee", 26, 2);
        noBody = new ResidentsBean(null, null, 25, 3);
        noFirstName = new ResidentsBean(null, "Berry", 23, 4);
        noLastName = new ResidentsBean("Grady", null, 25, 5);

    }

    //If you allocate external resources in a Before method you need to release them after the test runs.
    // Annotating a public void method with @After causes that method to be run after the Test method.
    @After
    public void addResidents(){

    }

    //The Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
    @Test
    public void TestAddResidents(){
        testResidents.addResidents(hansol);
        int numResidents = testResidents.residents.size();
        assertEquals(1, numResidents);
    }
}
