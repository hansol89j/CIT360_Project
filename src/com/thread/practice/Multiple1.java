package com.thread.practice;

/**
 * Created by hansoljeong on 2015. 10. 20..
 */
public class Multiple1 implements Runnable {

    public synchronized void run(){
        for (int i = 0; i < 6; i++) {
            System.out.println("<<<Working");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}