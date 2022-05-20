package org.example.prac.questions.cache.storage;

import org.example.prac.questions.cache.exceptions.NotFoundException;
import org.example.prac.questions.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    void add(Key key, Value value) throws StorageFullException;
    Value getKey(Key key) throws NotFoundException;
    void remove(Key key) throws NotFoundException;
}
