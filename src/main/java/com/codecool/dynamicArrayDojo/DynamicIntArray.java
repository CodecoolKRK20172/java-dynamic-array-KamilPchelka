package com.codecool.dynamicArrayDojo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DynamicIntArray {


    private int[] array;

    public DynamicIntArray(int size) {

        this.array = new int[size];
    }

    public DynamicIntArray() {
        this.array = new int[0];
    }

    public void add(int number) {
        int[] newArray = new int[array.length + 1];

        System.arraycopy(array, 0, newArray, 0, array.length);

        newArray[newArray.length - 1] = number;

        array = newArray;

    }

    public void remove(int number) {
        int actualSize = array.length;

        this.array = Arrays.stream(array).filter(value -> value != number).toArray();

        if (actualSize == array.length) throw new ArrayIndexOutOfBoundsException();

    }

    public void insert(int index, int number) {

        if (index > array.length - 1) {
            add(number);
        } else {

            int[] newArray = new int[array.length + 1];
            newArray[index] = number;

            System.arraycopy(array, 0, newArray, 0, index);

            System.arraycopy(array, index, newArray, index + 1, array.length - index);

            array = newArray;
        }

    }

    @Override
    public String toString() {
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
