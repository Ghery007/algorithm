package com.gaiyurui.algorithm.test;

import com.gaiyurui.algorithm.heap.IndexMinHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapTest {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();

        IndexMinHeap<Integer> minHeap = new IndexMinHeap<>();
        for(int i= 1;i <= 10;i++){
            int value = (int)(Math.random() * 100);
            minHeap.addElement(value);
            list.add(value);
        }
        long startTime = System.currentTimeMillis();
        Collections.sort(list);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime)  + " ms");
        System.out.println();
        startTime = System.currentTimeMillis();
        minHeap.setElement(4,0);
        for(;minHeap.hasNext();){
         // System.out.println(minHeap.extractMin());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("耗时：" + (endTime - startTime)  + " ms");
    }
}
