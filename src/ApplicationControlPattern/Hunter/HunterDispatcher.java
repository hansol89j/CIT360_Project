package ApplicationControlPattern.Hunter;

import java.util.HashMap;

/**
 * Created by hansoljeong on 2015. 12. 4..
 */
public class HunterDispatcher {
    private HashMap<String, HunterHandler> hunterHash = new HashMap<>();

    public HunterDispatcher(){
        Practice practice = new Practice();
        Chase chase = new Chase();
        Shoot shoot = new Shoot();
        Shoot1 shoot1 = new Shoot1();
        Die die = new Die();

        hunterHash.put("Practice", practice);
        hunterHash.put("Chase", chase);
        hunterHash.put("Shoot", shoot);
        hunterHash.put("Shoot1", shoot1);
        hunterHash.put("Die", die);
    }

    public void executeCommand(Integer aKey, Hunter hunter, HashMap<Integer, String> commandKey){

        try {
            String execution = (String) commandKey.get(aKey);

            HunterHandler hunterCommand = hunterHash.get(execution);

            hunterCommand.handleIt(hunter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
