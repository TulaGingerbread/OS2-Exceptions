package ru.tgb;

import java.io.File;
import java.nio.file.FileSystemException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecursiveDirectory {
    private final Iterator<File> iterator;
    private final int size;

    public RecursiveDirectory(String fileName) {
        List<File> allFiles = new LinkedList<File>();
        File root = new File(fileName);
        try {
            addFiles(allFiles, root);
        }
        catch (FileSystemException e) {
            System.out.println("File system error on file " + e.getMessage());
        }
        iterator = allFiles.iterator();
        size = allFiles.size();
    }

    public int getSize() {
        return size;
    }

    private void addFiles(List<File> allFiles, File root) throws FileSystemException {
        if (!root.exists()) {
            System.out.println("No such file exists: " + root.getName());
            return;
        }
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            for (File f : files) {
                try {
                    addFiles(allFiles, f);
                }
                catch (FileSystemException e) {
                    System.out.println("File system error on file " + e.getMessage());
                }
            }
        }
        else {
            if (Math.random() > 0.85) throw new FileSystemException(root.getName());
            allFiles.add(root);
        }
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public File nextFile() {
        return iterator.next();
    }
}
