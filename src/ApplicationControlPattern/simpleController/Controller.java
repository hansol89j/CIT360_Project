package ApplicationControlPattern.simpleController;

/**
 * Created by hansoljeong on 2015. 12. 4..
 */
public class Controller {
    private Dispatcher dispatcher;

    public Controller(){
        dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser(){
        System.out.println("User is authenticated successfully.");
        return true;
    }

    private void trackRequest(String request){
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request){
        trackRequest(request);

        if(isAuthenticUser()){
            dispatcher.dispatch(request);
        }
    }
}
