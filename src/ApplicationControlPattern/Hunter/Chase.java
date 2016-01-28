package ApplicationControlPattern.Hunter;

/**
 * Created by hansoljeong on 2015. 12. 4..
 */
public class Chase implements HunterHandler {

    @Override
    public void handleIt(Hunter hunter) {
        hunter.chase();
    }
}
