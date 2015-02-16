package com.beepbeat.AE2XTender.utility;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Zacharias on 05.02.2015.
 */
public class ArrayUtil {
    public static int findPos(String[] array, String str){
        for (int i = 0; i < array.length;i++){
            if (array[i].equals(str)){return i;}
        }
        return -1;
    }

    public static int findPos(List<String> array, String str){
        for (int i = 0; i < array.size();i++){
            if (array.get(i).equals(str)){return i;}
        }
        return -1;
    }

}
