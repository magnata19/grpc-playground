package com.github.magnata19.sec02;

import com.davidson.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {

    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {

        var person1 = createPerson();
        var person2 = createPerson();

        log.info("equals {}", person1.equals(person2));
        log.info("== {}", person1 == person2);

        var person3 = person1.toBuilder().setName("Pacifico").build();
        log.info("equals {}", person1.equals(person3));
        log.info("== {}", person1 == person3);

        var person4 = person1.toBuilder().clearName().build();
        log.info("person4 {}", person4);

    }

    public static Person createPerson() {
        return Person.newBuilder()
                .setName("Davidson")
                .setAge(25)
                .build();
    }
}
