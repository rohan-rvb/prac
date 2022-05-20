package org.example.prac.questions.cache.storage;

import org.example.prac.questions.cache.exceptions.NotFoundException;
import org.example.prac.questions.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {
    Map<Key, Value> hashMap;
    private final int capacity;

    public HashMapStorage(final int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()) {
            throw new StorageFullException("Storage is full");
        }
        hashMap.put(key, value);
    }

    @Override
    public Value getKey(Key key) throws NotFoundException {
        if (hashMap.containsKey(key))return hashMap.get(key);
        throw new NotFoundException("Key Not found");
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!hashMap.containsKey(key)) throw new NotFoundException("Key Not found");
        hashMap.remove(key);
    }

    private boolean isStorageFull() {
        return hashMap.size() == this.capacity;
    }
}
