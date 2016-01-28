package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hansoljeong on 2015. 11. 24..
 * Mediator that enables the View and Model get connected.
 */
public class Controller {

    //both model and view should be called on here, because the controller's job is making those two classes work
    //together.
    private Model myModel;
    private View view;
    private ActionListener actionListener; //responsible of handling event.

    public Controller(Model model, View view){
        this.myModel = model;
        this.view = view;
    }

    public void control(){
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number();
            }
        };
        view.getButton().addActionListener(actionListener);
    }

    public void number(){
        myModel.sumX();
        myModel.incNum();
        try {
            view.setText(Integer.toString(myModel.getX()));
        }catch(Exception e){
            System.out.println("You couldn't call the right value in!");
        }
    }

}
