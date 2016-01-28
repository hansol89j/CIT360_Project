package ApplicationControlPattern.simpleController;

/**
 * Created by hansoljeong on 2015. 12. 4..
 */
public class DispatcherDemo {
    public static void main(String args[]){
        Controller controller = new Controller();
        controller.dispatchRequest("Mine");
        controller.dispatchRequest("Wife's");
    }
}
