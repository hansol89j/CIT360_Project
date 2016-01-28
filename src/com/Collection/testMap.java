package com.Collection;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by hansoljeong on 2015. 11. 11..
 * Use to implement the Map interface. Allows execution time of basic operations, such as get() and put(), to remain
 * constant even for large tests. Result values in the hahsMap doesn't pull out in order. It prints out whatever the app
 * wants to send out.
 */
public class testMap {
    public static void main(String args[]){
        Map map = new HashMap();

        //unsorted keys will be print out.
        //put elements to the map
        map.put("Alberto", new Integer(90));
        map.put("Evan", new Integer(70));
        map.put("Lloyd", new Integer(80));
        map.put("Chloe", new Integer(100));
        map.put("이주연", new Integer(160));

        //containsKey method finds the specific key in the map.
        if(map.containsKey("이주연")){
            System.out.println("이주연 너무 예쁘다.");
        }

        Set<Entry<String, Integer>> set = map.entrySet();
        Iterator<Entry<String, Integer>> it = set.iterator();

        while(it.hasNext()){
            Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)it.next();
            System.out.println("Name: " + e.getKey() + ", Score: " + e.getValue());
        }

        Set<String> set2 = map.keySet();
        System.out.println("List: " + set2);

        Iterator<Integer> it2;
        Collection<Integer> values = map.values();
        it2 = values.iterator();

        int total = 0;

        while(it2.hasNext()){
            Integer i = (Integer)it2.next();
            total += i.intValue();
        }

        System.out.println("Total: " + total);
        System.out.println("Average: " + (float)total / set.size());
        System.out.println("Max score: " + Collections.max(values));
        System.out.println("Min score: " + Collections.min(values));
    }

}
