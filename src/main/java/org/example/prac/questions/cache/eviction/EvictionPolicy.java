package org.example.prac.questions.cache.eviction;

public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evict();
}
