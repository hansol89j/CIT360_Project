package ApplicationControlPattern.Hunter;

/*
Created by hansoljeong on 2015. 12. 4..
*/
public class Hunter {
    private String name;
    private String gun;
    private int age;
    private float weight;
    private float height;

    public Hunter(String name, String gun, int age, float weight, float height){
        this.name = name;
        this.gun = gun;
        this.age = age;
        this.weight = weight;
        this.height= height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    //actions of hunter going to have: animals chasing -> hide, animals spotted -> Shoot, shoot2 -> misfire -> run,
    // animal spotted you -> chasing -> you Die,

    public void practice(){
        try{
            System.out.println("BANG! BANG! BANG!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("Ready to Shoot some animal\n");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chase(){
        try{
            Thread.currentThread().sleep(2000);
            System.out.println("The animal spotted you!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("The animal is running into you!!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("You are hiding from the crazy animal\n");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shoot(){
        try{
            Thread.currentThread().sleep(2000);
            System.out.println("You spotted the animal!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("AIM! FIRE!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("BANG!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("You got it!\n");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shoot1(){
        try{
            Thread.currentThread().sleep(2000);
            System.out.println("You spotted the animal!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("AIM! FIRE!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("BANG!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("You missed it!! Try again\n");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void die(){
        try{
            Thread.currentThread().sleep(2000);
            System.out.println("You spotted the animal!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("AIM! FIRE!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("BANG!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("......??????What happened?! You are dead?!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("Oh...Lloyd fired you because of bad aim.\n");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
