package com.gaiyurui.algorithm.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 索引堆
 */
public class IndexMinHeap<T extends Comparable<T>> {

    private List<T> list = new ArrayList<T>();

    private List<Integer> indexList = new ArrayList<>();

    private List<Integer> reverseList = new ArrayList<>();

    public IndexMinHeap(){
    }

    public void addElement(T t){
        int index = indexList.size();
        list.add(index,t);
        indexList.add(index,index);
        reverseList.add(index,index);// indexList.get(reverseList.get(i)) = i ;
        shiftUp(index);
    }

    public boolean hasNext(){
        return indexList.size() > 0;
    }

    public int extractMinIndex(){
        Collections.swap(indexList,0,indexList.size() - 1);
        int t = indexList.get(indexList.size() - 1);
        indexList.remove(indexList.size() - 1);
        shiftDown(0);
        return t;
    }

    public boolean isEmpty(){

        return indexList.size() > 0;
    }

    public void setElement(T t,int index){
        int i = reverseList.get(index);
        list.set(index,t);
        shiftDown(i);
        shiftUp(i);
    }

    public int size(){
        return indexList.size();
    }

    public void shiftDown(int index){
        if(index < indexList.size()){
            int indexLocation = index;
            int leftChild = 2 * index  + 1;
            if(leftChild < indexList.size()){
                int childIndex = leftChild;
                if(leftChild + 1 < indexList.size() && list.get(indexList.get(leftChild + 1)).compareTo( list.get(indexList.get(leftChild))) < 0){
                    childIndex = leftChild + 1;
                }
                if(list.get(indexList.get(childIndex)).compareTo(list.get(indexList.get(indexLocation))) < 0){
                    Collections.swap(indexList,childIndex,indexLocation);
                    reverseList.set(indexList.get(childIndex),childIndex);
                    reverseList.set(indexList.get(indexLocation),indexLocation);
                    shiftDown(childIndex);
                }
            }
        }
    }

    private void shiftUp(int index){
        if(index > 0){
            int parentIndex = (index - 1) / 2;
            if(list.get(indexList.get(parentIndex)).compareTo(list.get(indexList.get((index)))) > 0){
                Collections.swap(indexList,parentIndex,index);
                reverseList.set(indexList.get(parentIndex),parentIndex);
                reverseList.set(indexList.get(index),index);
                shiftUp(parentIndex);
            }
        }
    }

}
