package com.gaiyurui.algorithm.unionfind;

public class QuickFindTree {

   private int[] array;

   private int[] treeHeight;

   public QuickFindTree(int size){
       array = new int[size];
       treeHeight = new int[size];
       for(int i=0;i<size;i++){
           array[i] = i;
       }
       for(int i=0;i<size;i++){
           treeHeight[i] = 1;
       }
   }

    public int find(int index){
        int j = 0;
        while(( j = array[index]) != index){
            array[index] = array[j];
            index = array[index];
        }
        return array[index];
    }

    public int findRec(int index){
        if(array[index] == index){
            return array[index];
        }
        int p = findRec(array[index]);
        array[index] = p;
        return p;
    }

   public boolean hasUnion(int first,int second){
       return find(first) == find(second);
   }

   public void unionElement(int i,int j){
       int p = find(i);
       int q = find(j);
       if(p != q){
           if(treeHeight[p] > treeHeight[q]) {
               array[q] = p;
           }else if(treeHeight[p] < treeHeight[q]) {
               array[p] = q;
           }else if(treeHeight[p] == treeHeight[q]) {
               array[p] = q;
               int h = treeHeight[q] + 1;
               treeHeight[q] = h;
           }
       }

   }

}
