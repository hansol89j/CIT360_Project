package com.thread.practice;

/**
 * Created by hansoljeong on 2015. 10. 18..
 */
/* Runnable interface is more advantageous in polymorphism than Thread. In other words, it is good for reuse and expansion.
 * run() method is same as normal method that the next line will be executed after the run method is terminated.
 */
public class threadPractice implements Runnable{
    public void run(){
        int i;
        for(i = 1; i < 10; i++){
            System.out.println(i);
            try{ /*This try and catch clauses must be inside of loop otherwise only the methods will work.*/
                Thread.sleep(1000);/*Wait for 1 seconds until the next value displays*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        threadPractice tp = new threadPractice();
        tp.run();
        System.out.print("MainThread Terminated...\n");/*MainThread has terminated. Print out result doesn't display because run method must terminated first.*/
    }
}
