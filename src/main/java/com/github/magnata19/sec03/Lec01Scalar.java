package com.github.magnata19.sec03;

import com.davidson.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {

    public static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {
        var person = Person.newBuilder()
                .setLastName("Walter")
                .setAge(23)
                .setEmail("davidson@gmail.com")
                .setEmployed(true)
                .setSalary(123123.949)
                .setBankAccountNumber(123455L)
                .setBalance(-10000)
                .build();

        log.info("person {}", person);
    }
}
