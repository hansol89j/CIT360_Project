package ApplicationControlPattern.DogApplicationControllPattern.DogHandlers;

import ApplicationControlPattern.DogApplicationControllPattern.Dog.Dog;

/**
 * Created by rome on 12/1/2015.
 */
public class AttackHandler implements DogHandler {
    @Override
    public void handleCommand(Dog aDog) {
        // Execute respective Functions
        aDog.bark();
        aDog.kill();
    }
}
