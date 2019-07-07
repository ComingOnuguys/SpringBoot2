package com.example.springbootdemo;

import org.junit.Test;

public class TestCopy {

    @Test
    public void test1() {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            e2 = e1.clone();

            int[] int1 = e1.get();
            int[] int2 = e2.get();
            System.out.println("int1 = " + int1);
            System.out.println("int2 = " + int2);

            System.out.println("int2 == int1 = " + (int2 == int1));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 222
    }

    @Test
    public void test2() {
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = null;
        try {
            e2 = e1.clone();
            System.out.println("e2 = " + e2);
            System.out.println("e1 = " + e1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 2
    }


    @Test
    public void testStatic(){
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = new DeepCloneExample();
    }
}
