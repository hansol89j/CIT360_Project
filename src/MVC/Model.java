package MVC;

/**
 * Created by hansoljeong on 2015. 11. 24..
 * Model is where creates the data.
 */
public class Model {

    private int x;
    private int y;
    private int num;

    public Model(){
        x = 15;
        y = 16;
        num = 0;
    }

    public Model(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    public void sumX(){
        num = x / y;
    }

    public void incNum(){
        num++;
    }

    public int getX(){
        return num;
    }

    public void setX(int num){
       try {
           this.num = num;
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
