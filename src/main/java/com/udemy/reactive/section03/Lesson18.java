package com.udemy.reactive.section03;

import com.github.javafaker.Faker;

public class Lesson18 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Faker.instance().name().fullName());

        }
    }
}
