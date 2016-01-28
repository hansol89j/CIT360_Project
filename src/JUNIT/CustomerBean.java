package JUNIT;

/**
 * Created by hansoljeong on 2015. 10. 31..
 */
public class CustomerBean extends PersonBean {

    private String phoneNumber;

    public CustomerBean(String firstName, String lastName, int age, String phoneNumber){
        super(firstName, lastName, age);

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
