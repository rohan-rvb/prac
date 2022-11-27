package org.example.prac.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@RunWith(SpringRunner.class)
public class MoreLambda {
    @Test
    public void testSort() throws JsonProcessingException {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);arr.add(2);arr.add(10);
        Collections.sort(arr);
        System.out.println("sorted is " + arr);

        //sorting by custom comparator, using lambda
        List<Person> persons = new ArrayList<>();
        persons.add(Person.builder().age(5).build());
        persons.add(Person.builder().age(2).build());
        Collections.sort(persons, (p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("sorted by age" + new ObjectMapper().writeValueAsString(persons));


    }

    @Builder
    @Getter
    @Setter
    public static class Person {
        private Integer age;
        private String name;
    }
}
