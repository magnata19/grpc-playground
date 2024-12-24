package com.github.magnata19.sec03;

import com.davidson.models.sec03.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Lec03PerformanceTest {

  public static final Logger log = LoggerFactory.getLogger(Lec03PerformanceTest.class);
  public static final ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) {

    var protoPerson = com.davidson.models.sec03.Person.newBuilder()
            .setLastName("Walter")
            .setAge(23)
            .setEmail("davidson@gmail.com")
            .setEmployed(true)
            .setSalary(123123.949)
            .setBankAccountNumber(123455L)
            .setBalance(-10000)
            .build();

    var jsonPerson = new JsonPerson(
            "Walter",
            23,
            "davidson@gmail.com",
            true,
            123123.949,
            123455L,
            -10000
            );

    for (int i = 0; i < 5; i++) {
      runTest("json", () -> json(jsonPerson));
      runTest("proto", () -> proto(protoPerson));
    }
  }

  public static void proto(Person person) {
    try {
      var bytes = person.toByteArray();
      Person.parseFrom(bytes);
    } catch (InvalidProtocolBufferException e) {
      throw new RuntimeException(e);
    }
  }

  public static void json(JsonPerson person) {
    try {
      var bytes = mapper.writeValueAsBytes(person);
      mapper.readValue(bytes, JsonPerson.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void runTest(String testName, Runnable runnable) {
    var start = System.currentTimeMillis();
    for(int i = 0; i < 1_000_000; i++) {
      runnable.run();
    }
    var end = System.currentTimeMillis();
    log.info("time taken for {} - {} ms", testName, (end - start));
  }

}
