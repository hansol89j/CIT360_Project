package ApplicationControlPattern.Hunter;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hansoljeong on 2015. 12. 4..
 */
public class HunterController {
    public static void main(String args[]){
        HunterController shooter = new HunterController();
        shooter.go();
    }

    public void go(){

        Hunter lewis = new Hunter("Lewis", "K-2", 35, 196, 191);

        HashMap<Integer, String> commandKey = new HashMap<>();
        commandKey.put(1, "Practice");
        commandKey.put(2, "Chase");
        commandKey.put(3, "Shoot");
        commandKey.put(4, "Shoot1");
        commandKey.put(5, "Die");

        generateHunter(lewis);

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        instruction(lewis);

        while(true){
            Scanner commandInput = new Scanner(System.in);

            System.out.println("Input command Key you want: ");
            int command = commandInput.nextInt();

            if (command < 1 || command > 5){
                System.out.println("Invalid command input...");

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                instruction(lewis);
            }
            else{
                executeCommand(command, lewis, commandKey);

                if(askUserToQuit() == false){
                    System.out.println("See You Guys!! Have a Great Hunting");
                    break;
                }
                else{
                    instruction(lewis);
                }
            }
        }

    }


    public boolean askUserToQuit(){
        Scanner askToQuit = new Scanner(System.in);
        System.out.println("Do you want to quit or continue?(q/c)");
        String answer = askToQuit.nextLine();

        String lowercase = answer.toString();
        String firstLetter = String.valueOf(lowercase.charAt(0));

        boolean finalAnswer = !firstLetter.equals("c") ? false:true;
        return finalAnswer;
    }

    public void generateHunter(Hunter lewis){
        System.out.println("Assigning a hunter...");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This is your Hunter");
        System.out.println("\tName: " + lewis.getName());
        System.out.println("\tGun: " + lewis.getGun());
        System.out.println("\tAge: " + lewis.getAge());
        System.out.println("\tHeight: " + lewis.getHeight());
        System.out.println("\tWeight: " + lewis.getWeight());
    }


    public void instruction(Hunter lewis){

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("What command key do you want to put to " + lewis.getName());
        System.out.println("\tPress 1 for Practice");
        System.out.println("\tPress 2 for Chase");
        System.out.println("\tPress 3 for Shoot Animal");
        System.out.println("\tPress 4 for Shooting Animal");
        System.out.println("\tPress 5 for Dying.....Amen");
    }

    public void executeCommand(int commandNumber, Hunter lewis, HashMap<Integer, String> commandKey){
        HunterDispatcher hunterAct = new HunterDispatcher();

        hunterAct.executeCommand(commandNumber, lewis, commandKey);
    }
}
