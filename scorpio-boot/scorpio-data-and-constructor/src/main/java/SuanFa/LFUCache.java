package SuanFa;

import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache {


    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers.iterator().next());
    }

    //keyToValue
    private HashMap<Integer, Integer> keyToValue;
    //当前key的频次
    private HashMap<Integer, Integer> keyTofreq;
    //当前频次的所有key,还要保证顺序，能找到最旧的那一个
    private HashMap<Integer, LinkedList<Integer>> freqToKeys;
    private Integer capacity;
    private Integer minReq;


    public LFUCache(int capacity) {
        this.keyToValue = new HashMap<>();
        this.keyTofreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minReq = minReq;
    }

    public int get(int key) {
        Integer integer = keyToValue.get(key);
        if(integer == null||capacity<=0){
            return -1;
        }
        Integer freq = keyTofreq.get(key);
        keyTofreq.put(key, freq+1);
        LinkedList<Integer> integers = freqToKeys.get(freq + 1);
        integers.add(key);
        return integer;
    }

    public void put(int key, int value) {
        Integer integer = keyToValue.get(key);
        if(integer == -1){
            increase(key, value);
        }else {
            keyToValue.put(key,value);
        }
    }

    public void increase(Integer key, Integer value){
        int size = keyToValue.size();
        if(size == capacity){
            //清除最旧的那一个
            LinkedList<Integer> integers = freqToKeys.get(minReq);
            integers.remove(integers.iterator().next());
            //清除之后为空
            if(integers.isEmpty()){
                freqToKeys.remove(minReq);
                minReq++;
            }
            keyToValue.remove(key);
            capacity--;
        }else {
            keyToValue.put(key, value);
            LinkedList<Integer> integers = freqToKeys.get(0);
            if(integers == null){
                integers = new LinkedList<>();
                freqToKeys.put(0, integers);
            }
            integers.add(key);
            capacity++;
        }
    }
}
