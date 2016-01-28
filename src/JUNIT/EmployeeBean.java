package JUNIT;


/**
 * Created by hansoljeong on 2015. 10. 31..
 * This class is inherited from PersonBean, because some arguments were already called by PersonBean,
 * so it is unnecessary to call them again.
 */
public class EmployeeBean extends PersonBean{

    private String phoneNumber;
    private String idNumber;

    public EmployeeBean(String firstName, String lastName, int age, String phoneNumber, String idNumber){


     /* this. is not working on the child class. In order to call the parent constructors from the parent class, use super().
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
     */
        super(firstName, lastName, age);

        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getIdNumber(){
        return this.idNumber;
    }


    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }



//Do I have to generate another equal() and hashCode() here? Even if I inherited this class from PersonBean??
/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EmployeeBean that = (EmployeeBean) o;

        if (age != that.age) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        return !(idNumber != null ? !idNumber.equals(that.idNumber) : that.idNumber != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        return result;
*/
}
