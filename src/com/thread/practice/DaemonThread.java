package com.thread.practice;

/**
 * Created by hansoljeong on 2015. 10. 22..
 */
public class DaemonThread implements Runnable{
    public static void main(String args[]){
        DaemonThread dm = new DaemonThread();
        Thread t = new Thread(dm);
        t.setDaemon(true);
        t.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is terminated...    ");
    }

    public void run(){
        while(true){
            System.out.println("is running....");

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
