package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(arrayToMerge));
        list.addAll(Arrays.asList(array));
        return Collections.frequency(list,valueToEvaluate);

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        List<T> list = new ArrayList<>();
        int currentCounter = 0;
        int compareCounter = 0;
        T currentObject = null;

        list.addAll(Arrays.asList(arrayToMerge));
        list.addAll(Arrays.asList(array));
        for(int i = 0; i < list.size(); i++){
            compareCounter = Collections.frequency(list,list.get(i));
            if(compareCounter > currentCounter){
                currentCounter = compareCounter;
                currentObject = list.get(i);
            }
        }
        return currentObject;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T object : array) {
            if (object.equals(valueToEvaluate)) {
                count++;
            }
        }

        return count;
    }

    public T[] removeValue(T valueToRemove) {
        Integer count = (Integer) getNumberOfOccurrences(valueToRemove);
        T[] buffer = Arrays.copyOf(array,array.length - count);
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if(!array[i].equals(valueToRemove)){
                buffer[j] = array[i];
                j++;
            }

        }
        return buffer;

    }
}
