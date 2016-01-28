package com.thread.practice;

/**
 * Created by hansoljeong on 2015. 10. 22..
 */
public class ThreadPractice3 implements Runnable{
    public static void main(String args[]){
        ThreadPractice3 t3 = new ThreadPractice3();
        Thread t = new Thread(t3);

        t.setPriority(3);
        t.start();

        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t.setPriority(10);

    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Priority: " + Thread.currentThread().getPriority());
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
