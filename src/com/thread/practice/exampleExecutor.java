package com.thread.practice;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hansoljeong on 2015. 11. 3..
 */

public class exampleExecutor {
    public static void main(String args[]) {
        //returns unlimited threadpool. Able to reuse threads over and over.
        ExecutorService anExecutor = Executors.newCachedThreadPool();

        //Put fixed size of the thread-pools.
//        try{
//            anExecutor = Executors.newFixedThreadPool(3);
//        }catch(Exception e){
//            System.out.println("There are only 3 threadpool!");
//        }
//
//        try{
//            anExecutor = Executors.newScheduledThreadPool(2);
//        }catch (Exception e){
//            System.out.println("");
//        }
//
//        try{
//            anExecutor = Executors.newSingleThreadExecutor();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        try{
//            anExecutor = Executors.newCachedThreadPool();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        for (int i = 0; i < 5; i++) {
            exampleApp example = new exampleApp();
            anExecutor.execute(example);
            //Insert null value instead of example will result NullPointerException
//            try{
//                anExecutor.execute(null);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        }
        anExecutor.shutdown();
        while(!anExecutor.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
