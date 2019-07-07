package com.example.springbootdemo;

public class DeepCloneExample implements Cloneable {

    private int[] arr;

    static {
        System.out.println("hello = " );
    }

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }
    public int[] get(){
        return arr;
    }
    @Override
    protected DeepCloneExample clone() throws
            CloneNotSupportedException {
        DeepCloneExample deepCloneExample = (DeepCloneExample) super.clone();
        return deepCloneExample;
    }
}
