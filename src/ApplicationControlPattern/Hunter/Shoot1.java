package ApplicationControlPattern.Hunter;

/**
 * Created by hansoljeong on 2015. 12. 4..
 */
public class Shoot1 implements HunterHandler {
    @Override
    public void handleIt(Hunter hunter) {
        hunter.shoot1();
    }
}
