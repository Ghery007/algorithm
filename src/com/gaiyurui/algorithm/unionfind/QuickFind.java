package com.gaiyurui.algorithm.unionfind;

public class QuickFind {

   private int[] array;

   public QuickFind(int size){
       array = new int[size];
       for(int i=0;i<size;i++){
           array[i] = i;
       }
   }

    public int find(int index){
        return array[index];
    }

   public boolean hasUnion(int first,int second){
       return array[first] == array[second];
   }

   public void unionElement(int i,int j){
       int p = array[i];
       int q = array[j];
       for(int k=0;k<array.length;k++){
           if(array[k] == q){
               array[k] = p;
           }
       }
   }

}
