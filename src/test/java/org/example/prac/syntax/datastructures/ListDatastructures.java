package org.example.prac.syntax.datastructures;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
public class ListDatastructures {
    @Test
    public void testList() {
        int arr[] = new int[5];
        log.info("size {}", arr.length);
        Arrays.fill(arr, -1);
        log.info("array is {}", arr);

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(2);

        for (Integer val: list) {
            log.error("value is {}", val);
        }

        Collections.sort(list);
        log.info("after sort {}", list);
        Collections.sort(list, Collections.reverseOrder());
        log.info("after rever sort {}", list);
        // sort as of even number should come first
        Collections.sort(list, (a,b)-> {
            if(a%2==0) {
                return -1;
            } else {
                return 1;
            }
        });
        log.info("after custom sort : {}", list);

        List<Integer> elements = new ArrayList<>(Collections.nCopies(5, -1));
        log.info("eeeee {}", elements);

        SortedSet<Integer> s = new TreeSet<Integer>();
        s.add(8);
        s.add(2);
        s.add(2);

        for (Integer element : s) {
            log.info("set element {}", element);
        }

        PriorityQueue<Integer>pq = new PriorityQueue<Integer>((a, b)->{
            return b.compareTo(a);
        } );
        pq.add(5);
        pq.add(4);
        log.info("top ele {}", pq.peek());
        pq.poll();
        log.info("next element {}", pq.peek());

    }
}
