package JUNIT.junit.sandBox1;

import JUNIT.PersonBean;
import JUNIT.junit.sandBox.ManagerBean;

/**
 * Created by hansoljeong on 2015. 11. 5..
 */
public class ManagersBean extends PersonBean {
    private String phoneNumber;
    private String duty;

    public ManagersBean(String firstName, String lastName, int age, String phoneNumber, String duty){
            super(firstName, lastName, age);
        this.phoneNumber = phoneNumber;
        this.duty = duty;
        }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getDuty(){
        return duty;
    }

    public void setDuty(String duty){
        this.duty = duty;
    }
}
