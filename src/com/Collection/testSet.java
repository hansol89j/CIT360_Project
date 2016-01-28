package com.Collection;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by hansoljeong on 2015. 11. 19..
 * Set cannot contain duplicated elements. Only contains methods inherited from Collection and adds the restriction that
 * duplicates elements are prohibited. A collection where an object can be added only once and the objects are presorted.
 */
public class testSet {
    public static void main(String args[]) {

        SortedSet set = new TreeSet();

        set.add("Hansol");
        set.add("Juyoun");
        set.add("Yuun");
        set.add("Kwangsoon");

        //iterator():Returns an Iterator object for the collection which may be used to retrieve an object
        Iterator it = set.iterator();
        while(it.hasNext()){
            Object element = it.next();
            System.out.println(element.toString());
        }
    }
}
