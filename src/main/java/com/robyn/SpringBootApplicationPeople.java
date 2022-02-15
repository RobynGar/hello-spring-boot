package com.robyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class SpringBootApplicationPeople {

    static List<Person> getPeople = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationPeople.class, args);
        Person suad = new Person(5, "Suad", 23);
        Person robyn = new Person(1, "Robyn", 23);
        Person alimaa = new Person(2, "Alimaa", 22);
        Person connie = new Person(3, "Connie", 22);
        Person suraya = new Person(4, "Suraya", 25);
        Person sarina = new Person(6, "Sarina", 22);

        getPeople.add(suad);
        getPeople.add(robyn);
        getPeople.add(alimaa);
        getPeople.add(connie);
        getPeople.add(suraya);
        getPeople.add(sarina);


    }

    // All your code should be inside this one class
    // add @RestController to your expose methods as REST services to clients
    // create a static List of type person with few people inside
    // create a class called Person with following properties: id, name, age


//    static List<Person> getPerson() {
//        return Arrays.asList(
//                new Person(1, "Robyn", 23),
//                new Person(2, "Alimaa", 22),
//                new Person(3, "Connie", 22),
//                new Person(4, "Suraya", 25)
//
//        );
//    }


    static class Person {
        private int id;
        private String name;
        private int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Person() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, age);
        }
    }

    // implement getPersonById

//    @GetMapping(path = "people/{id}")
//    public Person person/{id}


    @GetMapping(path = "people/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        // use integer rather than int as int does not accept null whereas integer does, null for int is 0 and 0 is a number
        // this method accepts the argument of the id people put in to the path after the / and this will be an integer
        // filter list and return person that matches id otherwise return null
        for (Person p : getPeople) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }


    @GetMapping(path = "allPeople")
    public List<Person> getEveryone() {
        return getPeople;
    }
        // test your api using chrome

}
