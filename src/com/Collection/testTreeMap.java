package com.Collection;

import java.util.*;

/**
 * Created by hansoljeong on 2015. 11. 12..
 * Unlike HashMap, TreeMap prints out the result in order. This doesn't mean that it will pull out result as the user inserts
 * the value, but it will print out, for instance, in alphabetically or in number.
 */
public class testTreeMap {
    public static void main(String args[]){
        Map map = new TreeMap();

        map.put("Alberto", new Integer(90));
        map.put("Evan", new Integer(70));
        map.put("Lloyd", new Integer(100));
        map.put("Chloe", new Integer(100));
        map.put("이주연", new Integer(160));

        try {
            map.remove("이주연");
            map.remove("ddd"); // Cannot remove the not exist element.
            map.remove(null); //null will result NullPointerException
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            if (map.containsKey("이주연"))
                System.out.println("이주연 너무 예쁘다.");
            else if (map.containsValue("Lloyd"))
                System.out.println("Element you are looking for is not value");
            else
                System.out.println("containsValue only checks values!");
        }catch(Exception e){
            e.printStackTrace();
        }

        //entrySet(): returns and stores key/value in the Map to the form of the Set.
        //Map.Entry<>: enable to work with a map entry. Describes the elements in a map.
        //used to get a Set view of the mappings contained in this map.
        //Using Set in front of map.entry<> means gets the output of the keys of the Map by repeating the Set after converting
        // the values of the Map to the values of the Set collection.
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        //Iterator enables to cycle through a collection, obtaining or removing elements.
        // By iterator, you can access each element in the collection, one element at a time.
        //The difference between of Iterator and For loop is that I can add or remove elements in Iterator and cannot
        // do that with the For loop.
        Iterator<Map.Entry<String, Integer>> it = set.iterator();

        //returns true if there is next element. Reads through each element.
        while(it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();//NoSuchElementException is thrown if there is not a next element.
            System.out.println("Name: " + e.getKey() + ", Score: " + e.getValue());
        }


        //keySet(): Only the Key objects in the Map accepts in the form of the Set objects.
        Set<String> set2 = map.keySet();
        System.out.println("List of keys: " + set2);

        Iterator<Integer> it2;
        //Used to return a Collection view of the values contained in this map.
        //The method call returns a collection view of the values contained in this map
        //Collection values(): returns all the keys and values stored in the HashMap as form of Collection
        Collection<Integer> values = map.values();
        System.out.println("List of Values: " + values);
        it2 = values.iterator();

        int total = 0;

        while(it2.hasNext()){
            Integer i = (Integer)it2.next();
            total += i.intValue();//returns the value of Integer as an int.
        }

        for(int i = 0; i < map.size(); i++) {
            Object o = map.get(i);
        }

        System.out.println("Total: " + total);
        System.out.println("Average: " + (float)total / set.size());//returns the elements of the Set.
        System.out.println("Max score: " + Collections.max(values));
        System.out.println("Min score: " + Collections.min(values));
    }
}
