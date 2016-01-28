package ApplicationControlPattern.simpleController;

/**
 * Created by hansoljeong on 2015. 12. 4..
 */
public class Dispatcher {
    private myView myView;
    private wifeView wifeView;

    public Dispatcher(){
        myView = new myView();
        wifeView = new wifeView();
    }

    public void dispatch(String request){
        if(request.equalsIgnoreCase("Mine")){
            myView.show();
        }
        else{
            wifeView.show();
        }
    }
}
