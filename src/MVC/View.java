package MVC;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hansoljeong on 2015. 11. 24..
 * Outputs the data.
 */
public class View {

    private JFrame frame;
    private JLabel label;
    private JButton button;

    public View(String text){
        frame = new JFrame("View");
        frame.getContentPane().setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);

        label = new JLabel(text);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        button = new JButton("Button");
        frame.getContentPane().add(button, BorderLayout.SOUTH);
    }

    public JButton getButton(){
        return button;
    }

    public void setText(String text){
        label.setText(text);
    }

    public static void main(String args[]){
        //Swing is not thread-safe.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                View view = new View("Hello!");
                Controller controller = new Controller(model,view);
                controller.control();
            }
        });
    }
}
