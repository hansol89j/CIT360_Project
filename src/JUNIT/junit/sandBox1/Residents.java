package JUNIT.junit.sandBox1;


import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by hansoljeong on 2015. 11. 5..
 */
public class Residents {
    protected HashMap<String, ResidentsBean> residents;

    public Residents() {
        residents = new HashMap<String, ResidentsBean>();
    }

    public void addResidents(ResidentsBean aResident) {
        if (aResident != null && aResident.getLastName() != null &&
                aResident.getFirstName() != null) {
            String key = aResident.getLastName() +
                    ", " + aResident.getFirstName();
            residents.put(key, aResident);
        }
    }
}