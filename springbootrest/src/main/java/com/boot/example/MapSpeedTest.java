package com.boot.example;


import java.util.*;
public class MapSpeedTest
{
    public static void main(String[] args)
    {
        int size = Integer.parseInt(args[0]);
        Random r = new Random();        
        Object[] o = new Object[size];
        for (int i=0; i<size; ++i)
            o[i] = String.valueOf(r.nextInt());
        int capacity = 3 * size / 2; // to avoid rehash()
        Hashtable ht = new Hashtable(capacity);
        HashMap hm = new HashMap(capacity);
        Map map;
        if (args[1].equals("ht")) {
            map = ht;
        } else if (args[1].equals("hm")) {
            map = hm;
        } else {
            map = Collections.synchronizedMap(hm);
        }
        long time = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            map.put(o[i], o[i]);
        }
        for (int i = size - 1; i > -1; i--) {
            map.remove(o[i]);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("time taken :::: " + time + " mili second");
    }
}

