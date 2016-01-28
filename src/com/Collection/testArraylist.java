package com.Collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hansoljeong on 2015. 11. 12..
 */
public class testArraylist {
    public static void main(String args[]){
        ArrayList<String> array = new ArrayList<>();

        array.add("United States Army");
        array.add("United States Air Force");
        array.add("United States Navy");
        array.add("United States Marine Corps");
        array.add("United States Coast Guard");

        System.out.println("The first ones added on the list: \n" + array);



        //If I add another element on the specific index, the elements in the index will be pushed off.
        array.add(1, "Utah National Guards");
        //Even though I put the element on the same index as I did before, the element won't be replaced to the new one, but it will push off.
        array.add(1, "Nevada National Guards");
        array.add(5, "Idaho National Guards");

        System.out.println("The second ones after adding new elements on the list: \n" + array);


        array.remove("United States Air Force");
        array.remove(5);

        System.out.println("After deleting two of them...\n" + array + "\n");

        System.out.println("Size of the arrayList \n");
        System.out.println(array.size());

        //Nasty-paths: Adding more elements on the index of 20 while there is only 6
        try{
            array.add(20, "Sergeant");
        }catch(Exception e){
            System.out.println("Your index is out of boundary.");
        }

        //Nasty-path: adding value on the negative index
        try{
            array.add(-1, "Senator");
        }catch(Exception e){
            System.out.println("Index should only be positives!");
        }


        //Nasty-path: unable to remove negatives.
        try{
            array.remove(-10);
        }catch(Exception e) {
            System.out.println("Index should only be positives!");
        }
    }
}
