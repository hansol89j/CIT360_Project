package JUNIT.junit.sandBox;


/**
 * Created by hansoljeong on 2015. 11. 1..
 */
public class ManagerBean extends PersonBean{

    private String idNumber;
    private String duty;

    public ManagerBean(String firstName, String lastName, int age, String idNumber, String duty){
        super(firstName, lastName, age);
        this.idNumber = idNumber;
        this.duty = duty;
    }

    public String getIdNumber(){
        return idNumber;
    }

    public String getDuty(){
        return duty;
    }

    public void setIdNumber(String phoneNumber){
        this.idNumber = idNumber;
    }

    public void setDuty(String duty){
        this.duty = duty;
    }
}
