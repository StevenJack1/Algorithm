package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class Mian {
    public static void main(String[] args) {
        LinkedList<String> staff = new LinkedList<>();
        staff.add("asdsa");
        staff.add("qwe");
        staff.add("xxxx");

        ListIterator<String> stringListIterator = staff.listIterator();
        ListIterator<String> stringListIterator1 = staff.listIterator();

        stringListIterator.next();
        stringListIterator.remove();
        stringListIterator1.next();

        for (String c: staff){
            System.out.println(c);
        }
    }
}
