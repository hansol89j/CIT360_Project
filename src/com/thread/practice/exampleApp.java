package com.thread.practice;

/**
 * Created by hansoljeong on 2015. 10. 28..
 * 두 가지의 방법이 있는데, extends Thread를 쓰거나 implements Runnable을 쓸 수 있다. runnable을 쓰는 것을 더 선호하는데
 * 그 이유는 이 인터페이스를 썼을 때 다속성에서 thread보다 더 효율적이고 장점이 강하는데 이유 때문이다. 한 마디로 말하자면, 재사용이나 확장을 해야할때 더
 * 효율적이라는 것이다.
 */
public class exampleApp implements Runnable{

    public static void main(String args[]){
        exampleApp example = new exampleApp();

        //Happy-path
        Thread t = new Thread(example, "Hansol");
        Thread t1 = new Thread(example, "Albert");
        Thread t2 = new Thread(example, "Lloyd");
        Thread t3 = new Thread(example, "Evan");

            /*Nasty-path: cannot put null as name
             * Thread t = new Thread(example, null);
             * Thread t1 = new Thread(example, null);
             * Thread t2 = new Thread(example, null);
             * Thread t3 = new Thread(example, null);
             */

        //run() is not recommended to use because, it will keep run the run method without main thread.`
        //start running run method.
        t.start();
        t1.start();
        t2.start();
        t3.start();

        //join과 sleep의 차이점은 무엇일까?? 둘 다 똑같이 한 thread가 실행 중 일때 나머지 thread들이 기다리게 해준다.
        try {
            t.join();
            t1.join();
            t2.join();
            t3.join();
            System.out.println("The main thread is terminated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Synchronize the method if the result doesn't display in order.
    public void run(){
        vendingMachine();
        drinking();
    }

    //using synchronization displays the results in order.
    public synchronized void vendingMachine(){
        for(int i = 1; i < 2; i++){
            System.out.println(Thread.currentThread().getName() + " inserts coin");
            try{
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void drinking(){
        for(int i = 1; i < 2; i++){
            System.out.println(Thread.currentThread().getName() + " take out drink from vending machine!\n");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
