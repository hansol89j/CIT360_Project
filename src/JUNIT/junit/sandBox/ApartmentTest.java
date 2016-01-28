package JUNIT.junit.sandBox;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;


/**
 * Created by hansoljeong on 2015. 11. 1..
 */

public class ApartmentTest {
        Apartment testApartment;
        ResidentsBean hansol, wontak, jayeoun, yuun, thomas;
        ManagerBean jade, sarah, hanah;

        @Before
        public void setUp() throws Exception {
            testApartment = new Apartment();
            //each resident has a first name, last name, age, phonenumber, and room number
            hansol = new ResidentsBean("Hansol", "Jeong", 26, "(208)555-1818", 2301);
            wontak = new ResidentsBean("Wontak", "Kim", 27, "(801)123-4567", 2302);
            jayeoun = new ResidentsBean("Jayeoun", "Lee", 28, "(385)234-7890", 2303);
            yuun = new ResidentsBean("Yuun", "Kim", 3, "(801)345-6789", 2304);
            thomas = new ResidentsBean("Thomas", null   , 30, "(801)456-1234", 2304);



            jade = new ManagerBean("Juyoun", "Lee", 26, "5551818", "Account");
            sarah = new ManagerBean("Sarah", "Jones", 27, "2345678", "Management");
            hanah = new ManagerBean("Hanah", "Jeong", 28, "9046017", "Cleaning");

        }

   @Test
    public void TestAddResidents(){
       testApartment.addResidents(hansol);
       testApartment.addResidents(wontak);
       int numResidents = testApartment.residents.size();
       assertEquals(2, numResidents);

       testApartment.addResidents(jayeoun);
       testApartment.addResidents(yuun);
       numResidents = testApartment.residents.size();
       assertEquals(4, numResidents);

       //Null value should not be in here.
       testApartment.addResidents(null);
       numResidents = testApartment.residents.size();
       assertEquals(4, numResidents);

       //key with null value should not be here either
       testApartment.addResidents(thomas);
       numResidents = testApartment.residents.size();
       assertEquals(4, numResidents);

       //put null on the size of residents values
       //testApartment.addResidents(null);
       //numResidents = testApartment.residents.size();
       //assertEquals(null, numResidents);


   }

    @Test
    public void testGetResidents(){
        testApartment.residents.put("Jeong, Hansol", hansol);
        testApartment.residents.put("Kim, Wontak", wontak);
        testApartment.residents.put("Lee, Jayeoun", jayeoun);
        testApartment.residents.put("Kim, Yuun", yuun);
        try {
            ResidentsBean hansolFromMap = testApartment.getResidents("Jeong, Hansol");
            assertEquals(hansol, hansolFromMap);
            //assertNull(hansol);
            //assertEquals(hansol, hansolFromMap);
            ResidentsBean wontakFromMap = testApartment.getResidents("Kim, Wontak");
            assertEquals(wontak, wontakFromMap);
            //assertFalse(wontak == hansol);
            ResidentsBean jayeounFromMap = testApartment.getResidents("Lee, Jayeoun");
            assertEquals(jayeoun, jayeounFromMap);
            ResidentsBean yuunFromMap = testApartment.getResidents("Kim, Yuun");
            assertEquals(yuun, yuunFromMap);
            ResidentsBean notEmployee = testApartment.getResidents("Body, No");
            assertNull(notEmployee);
        }catch (Exception e){
            System.out.println("AssertEqual is using to check if the name of person is same as from the Bean");
        }

        testApartment.residents.clear();
    }
}
