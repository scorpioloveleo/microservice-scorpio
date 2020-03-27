package com.scorpio.utils;

import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CopyUtils {
    public static <T> List<T> copyList(List <? extends Object> sourceObjects, Class<T> descClass){
        List<T> descList = new LinkedList<T>();
        sourceObjects.forEach(sourceObject->{
            try {
                T descObject = descClass.newInstance();
                BeanUtils.copyProperties(sourceObject, descObject);
                descList.add(descObject);
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("对象集合Copy异常，" + e);
            }
        });
        return descList;
    }

    public static void main(String[] args) {


       Map<String , List<Integer>> map = new HashMap<>();
        List<Integer> sss = map.get("123");
        System.out.println(sss == null);
        System.out.println(sss.size());


    }

    static boolean validStrWithNum(String str, int x){
        boolean b = str.startsWith("") || str.endsWith("");
        if(b){
            return false;
        }
        if(str.length() >=x){
            return false;
        }
        return true;
    }
}
