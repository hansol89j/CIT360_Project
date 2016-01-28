package JUNIT.junit.sandBox;

import JUNIT.junit.sandBox1.ManagersBean;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by hansoljeong on 2015. 11. 1..
 */

public class Apartment {

    //Cannot use private because private can be only use to methods in the same class. But protected or public
    // could use to the methods in the subclasses or different class.
    protected HashMap<String, ResidentsBean> residents;
    protected TreeMap<String, String> managersDuty;

    public Apartment(){
        residents = new HashMap<String, ResidentsBean>();
        managersDuty = new TreeMap<String, String>();
    }

    public void addResidents(ResidentsBean aResident){
        if(aResident != null && aResident.getLastName() != null &&
                aResident.getFirstName() != null){
            String key = aResident.getLastName() +
                    ", " + aResident.getFirstName();
            residents.put(key, aResident);
        }
    }

    public void addManagers(ManagersBean aManager, int age){
        try {
            TreeMap<ManagersBean, Integer> map = new TreeMap<>();
            map.put(aManager, age);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ResidentsBean getResidents(String lastAndFirstName){
        return residents.get(lastAndFirstName);
    }
}
