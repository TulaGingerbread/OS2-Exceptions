package ru.tgb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSorter {
    private final int memoryLimit;
    private List<Integer> numbers;

    public IntegerSorter(int size) {
        memoryLimit = size + (int)Math.floor(72.5 - Math.random() * 100);
        numbers = new ArrayList<Integer>();
    }

    public void addNumber(int k) throws OutOfMemoryError {
        numbers.add(k);
        if (numbers.size() > memoryLimit) throw new OutOfMemoryError();
    }

    public void printSortedNumbers() throws OutOfMemoryError {
        if (Math.random() > 0.8) throw new OutOfMemoryError();
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
