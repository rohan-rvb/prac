package org.example.prac.designpatterns.composite;

/*
This is a leaf node in our hierarchy.
 */

public class BinaryFile extends File{
    private long size;

    public BinaryFile(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public void ls() {
        System.out.println("File is : " + getName() + '\t' + size);
    }

    @Override
    public void addFile(File file) {
        throw new UnsupportedOperationException("leaf does not support add file");
    }

    @Override
    public File[] getFiles() {
        throw new UnsupportedOperationException("leaf does not support get files");
    }

    @Override
    public boolean removeFile(File file) {
        throw new UnsupportedOperationException("leaf does not support remove file");
    }
}
