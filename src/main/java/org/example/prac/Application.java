package org.example.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@SpringBootApplication(scanBasePackages = {"org.example.prac"}, exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
       // SpringApplication.run(Application.class, args);


        Scanner sc = new Scanner(System.in);
        /*
        String line = sc.nextLine();
        System.out.println("line is " + line);
        int inp = sc.nextInt();
        System.out.println("integer input is " + inp);

         */

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<5;i++) {
            list.add(i,sc.nextInt());
        }

        System.out.println("list is " + list);

    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "Hello";
    }


}