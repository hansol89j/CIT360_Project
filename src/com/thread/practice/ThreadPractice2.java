package com.thread.practice;

/**
 * Created by hansoljeong on 2015. 10. 18..
 */
/* Runnable interface is more advantageous in polymorphism than Thread. In other words, it is good for reuse and expansion.
 * start() method is simply generate a new execution flow, but it does not get any result even if it executed
 * because the Thread object that is created does not operate.
 */
public class ThreadPractice2 implements Runnable{
    public void run(){
        int i;
        for(i = 1; i < 10; i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        ThreadPractice2 tp2 = new ThreadPractice2();
        Thread t = new Thread(tp2);
        t.start();/*When I call the start() method, new execution flow is creating that each of main() and ThreadPractice2 has execution flow.*/
        System.out.print("MainThread Terminated...\n");
    }
}