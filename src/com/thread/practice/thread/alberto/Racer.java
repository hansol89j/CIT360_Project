package com.thread.practice.thread.alberto;

/**
 * Created by rome on 11/3/2015.
 */
public class Racer implements Runnable{

    public static String winner;
    public void race(){

        for(int distance=1;distance<=50;distance++){
            System.out.println("Distance covered by "+Thread.currentThread().getName()+" is "+distance+" meters ");
            //check if race is complete nd if there is a winner already
            boolean isRaceWon = this.isRaceWon(distance);
            if(isRaceWon){
                break;
            }
        }

    }

    private boolean isRaceWon(int totalDistanceCovered){
        boolean isRaceWon = false;
        if((Racer.winner==null)&&(totalDistanceCovered==50)){
            String winnerName=Thread.currentThread().getName();
            Racer.winner=winnerName; //setting the winner name)
            System.out.println("Winner is "+Racer.winner);
            isRaceWon=true;
        }
        else if(Racer.winner==null){
            isRaceWon=false;
        }
        else if(Racer.winner==null){
            isRaceWon=true;
        }
        return isRaceWon;
    }
    @Override
    public void run(){
        this.race();
    }
}
