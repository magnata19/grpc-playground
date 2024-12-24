package com.github.magnata19.sec03;

public record JsonPerson(
        String lastName,
        int age,
        String email,
        boolean employed,
        double salary,
        long accountNumber,
        int balance
) {
}
