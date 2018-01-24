package com.gaiyurui.algorithm.test;


import com.gaiyurui.algorithm.unionfind.QuickFindTree;

public class UnionFindTest {

    public static void main(String[] args){
        QuickFindTree quickFind = new QuickFindTree(10);
        System.out.println(quickFind.hasUnion(1,2));
        quickFind.unionElement(1,2);
        quickFind.unionElement(2,3);
        quickFind.unionElement(4,8);
        quickFind.unionElement(1,8);
        System.out.println(quickFind.hasUnion(2,4));
    }
}
