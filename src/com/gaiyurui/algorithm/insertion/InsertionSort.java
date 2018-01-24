package com.gaiyurui.algorithm.insertion;

public class InsertionSort{

    public static <T extends Comparable<T>> void insertSort(T[] array,int left,int right){
        if(array != null) {
            for (int i = left + 1; i < right; i++) {
                T temp = array[i];
                int location = i;
                for(int j=i-1;j>=left;j--){
                    if(temp.compareTo(array[j]) >= 0){
                        break;
                    }
                    location = j;
                    array[j+1] = array[j];
                }
                System.out.println(location);
                array[location] = temp;
            }
        }
    }

    public static void main(String[] args){
        Integer[] array = {3,5,7,1,4,9,3,4,7,2,33,45,6};
        InsertionSort.insertSort(array,2,array.length);
        for(Integer temp:array){
            System.out.print(temp + " ");
        }
    }
}
