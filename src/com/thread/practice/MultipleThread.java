package com.thread.practice;

/**
 * Created by hansoljeong on 2015. 10. 19..
 */
public class MultipleThread {
    public static void main(String args[]) {



        Multiple1 m1 = new Multiple1();
        Thread t1 = new Thread(m1);

        Multiple2 m2 = new Multiple2();
        Thread t2 = new Thread(m2);

        /*When both run(), main will be printed out at very last, one start() and one run() will have same result, but units are blended. Both start() main will print out first.*/
        t1.start();
        t2.start();
        System.out.println("MainThread terminated");
    }
}
