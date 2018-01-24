package com.gaiyurui.algorithm.heap;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {

    private List<T> list = new ArrayList<T>();

    public MinHeap(){
    }

    public void addElement(T t){
        int index = list.size();
        list.add(index,t);
        shiftUp(index);
    }

    public boolean hasNext(){
        return list.size() > 0;
    }
    public T extractMin(){
        Collections.swap(list,0,list.size() - 1);
        T t = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        shiftDown(0);
       return t;
    }

    public void setElement(T t,int index){
        list.set(index,t);
        shiftDown(index);
        shiftUp(index);
    }

    public int size(){
        return list.size();
    }

    public void shiftDown(int index){
        if(index < list.size()){
            int indexLocation = index;
            int leftChild = 2 * index  + 1;
            if(leftChild < list.size()){
                int childIndex = leftChild;
                if(leftChild + 1 < list.size() && list.get(leftChild + 1).compareTo( list.get(leftChild)) < 0){
                    childIndex = leftChild + 1;
                }
                if(list.get(childIndex).compareTo(list.get(indexLocation)) < 0){
                    Collections.swap(list,childIndex,indexLocation);
                    shiftDown(childIndex);
                }
            }
        }
    }

    private void shiftUp(int index){
        if(index > 0){
            int parentIndex = (index - 1) / 2;
            if(list.get(parentIndex).compareTo(list.get(index)) > 0){
                Collections.swap(list,parentIndex,index);
                shiftUp(parentIndex);
            }
        }
    }

}
