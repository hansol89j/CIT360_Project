package com.thread.practice;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by hansoljeong on 2015. 10. 26..
 */
public class SimpleThread {
        public static void main(String args[]) {
            Executor executor = (Executor) Executors.newCachedThreadPool();//Creating thread pool that is creating thread whenever it needed.
            for (int count = 1; count < 4; count++) {
                SimpleRunnable silly = new SimpleRunnable();
                executor.execute(silly);
            }
            try {
                Thread.sleep(1000);
                for (int i = 1; i < 4; i++) {
                    SimpleRunnable silly1 = new SimpleRunnable();
                    executor.execute(silly1);
                }
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
}

class SimpleRunnable implements Runnable{

    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println("Thread id: " + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
