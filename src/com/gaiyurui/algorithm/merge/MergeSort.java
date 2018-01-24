package com.gaiyurui.algorithm.merge;

import com.gaiyurui.algorithm.insertion.InsertionSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static <T extends Comparable<T>> void merge(T[] array,int left,int right){
        if(right - left <= 7){
            InsertionSort.insertSort(array,left,right);
            return;
        }
        int middle =  (right - left ) / 2 + left;
        merge(array,left,middle);
        merge(array,middle + 1,right);

        mergeSort(array,left,middle,right);
    }

    private static  <T extends Comparable<T>>  void mergeSort(T[] array,int left, int middle, int right) {
        if(array[middle].compareTo(array[middle + 1]) <=0){
            return;
        }
        List<T> list = new ArrayList<>(right - left);
        int start1 = left;
        int start2 = middle + 1;
        while(start1 <= middle || start2 <= right){
            if( array[start1].compareTo(array[start2]) <=0){
                list.add(array[start1]);
                start1++;
            }else{
                list.add(array[start2]);
                start2++;
            }
        }

        if(start1 <= middle){
            for(int i = start1;i<middle;i++){
                list.add(array[start1++]);
            }
        }

        if(start2 <= right){
            for(int i = start2;i<right;i++){
                list.add(array[start2++]);
            }
        }

        for(int i=left;i<right;i++){
            array[i] = list.get(i-left);
        }

    }
}
