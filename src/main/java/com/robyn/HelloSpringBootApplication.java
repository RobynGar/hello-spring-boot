package com.robyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
// in order for you to webserver to start you need the above
@RestController
// any methods we have we can tell it to run any HTTP verbs
public class HelloSpringBootApplication {
    // need above to run the program
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

    // this is the main access point of your application that the JVM runs
    // tomcat is a webserver
    // port 8080 is the main port the user uses to talk to the application

    //localhost:8080 (this is what you type in the web browser)
    //this is the route path
    @GetMapping
    String greet() {
        return "Hello Robyn";
    }

    //localhost:8080/ping (this is what you type in the web browser)
    //specified the path
    //cannot duplicate paths, so cannot have another ping path
    @GetMapping(path = "ping")
    String ping() {
        return "pong";
    }

    // localhost:8080/?name=foo (name could = anything)
    @GetMapping(params = "name")
    // above means it is an optional parameter, that is why in browser you have ?
    String greetName(@RequestParam("name") String name) {
        return "Hello " + name + " how are you today?";
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    // localhost:8080/people
    // returns a collection of key value pairs on the browser name = key alex = value
    @GetMapping(path = "people")
    List<Person> getPerson() {
        return List.of(
                new Person("Alex", 24),
                new Person("Wendy", 22)
        );
    }

        @PostMapping(path = "people")
        void addPerson(@RequestBody Person person){
            System.out.println(person);
        }


    }


