package ru.tgb;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        RecursiveDirectory rd = new RecursiveDirectory("dir");
        IntegerSorter sorter = new IntegerSorter(rd.getSize());
        while (rd.hasNext()) {
            try {
                File file = rd.nextFile();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    i++;
                    try {
                        int k = Integer.parseInt(line);
                        sorter.addNumber(k);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Not an integer in file " + file.getName() + ", line " + i);
                    }
                    catch (OutOfMemoryError e) {
                        System.out.println("Memory ends sometime when you try to add more numbers...");
                        System.exit(1);
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Missing file " + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("IO exception: " + e.getMessage());
            }
        }
        try {
            sorter.printSortedNumbers();
        }
        catch (OutOfMemoryError e) {
            System.out.println("Can't sort: too much memory needed!");
        }
    }
}
