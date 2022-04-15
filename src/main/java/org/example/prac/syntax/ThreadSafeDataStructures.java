package org.example.prac.syntax;

import java.util.*;

public class ThreadSafeDataStructures {
    Map<String, String> mapp = Collections.synchronizedMap(new HashMap<>());

    List<Integer> list = Collections.synchronizedList(new ArrayList<>());


}
