package JUNIT.junit.sandBox;



/**
 * Created by hansoljeong on 2015. 11. 1..
 */
public class ResidentsBean extends PersonBean{

    private String phoneNumber;
    private int roomNumber;

    public ResidentsBean(String firstName, String lastName, int age, String phoneNumber, int roomNumber){
        super(firstName, lastName, age);
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

}
