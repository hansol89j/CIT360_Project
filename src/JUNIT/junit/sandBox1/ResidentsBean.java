package JUNIT.junit.sandBox1;

import JUNIT.PersonBean;

/**
 * Created by hansoljeong on 2015. 11. 5..
 */
public class ResidentsBean extends PersonBean {
    private int roomNumber;

    public ResidentsBean(String firstName, String lastName, int age, int roomNumber){
        super(firstName, lastName, age);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
}
