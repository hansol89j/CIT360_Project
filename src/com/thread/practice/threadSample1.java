package com.thread.practice;

import java.util.ArrayList;

/**
 * Created by hansoljeong on 2015. 10. 25..
 */
public class threadSample1 implements Runnable {
    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String args[]){
        threadSample1 s1 = new threadSample1();

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        Thread t3 = new Thread(s1);

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run(){
        long stime = System.currentTimeMillis();

        for(int i = 0; i < 10000; i++){
            addList();
        }

        long etime = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName() + " : " + (etime - stime) + "ms");
    }

    private synchronized void addList(){
        int val = (int)(Math.random() * 10);

        if(!list.contains(val)){
            synchronized (this){
                if(!list.contains(val)){
                    list.add(val);
                }
            }
        }
        /*
        if(!list.contains(val)){
            list.add(val);
        }
        */
    }
}
