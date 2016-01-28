package JUNIT.junit.Calculator;

/**
 * Created by hansoljeong on 2015. 11. 21..
 */
public class Calculator {

    private String uniqueId = "123456";

    public double sum(double a, double b){
        return a + b;

    }

    public double subtract(double a, double b){
        if(a < 0 || b < 0 || a < b){
            throw new ArithmeticException();
        }
        return a - b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double division(double a, double b){
        if (a == 0 || b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    public String getUniqueId(){
        return uniqueId;
    }

    public void setUniqueId(String uniqueId){
        this.uniqueId = uniqueId;
    }
}
