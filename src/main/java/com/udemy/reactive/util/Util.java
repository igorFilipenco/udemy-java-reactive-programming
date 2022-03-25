package com.udemy.reactive.util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {
    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return System.out::println;
    }

    public static Consumer<Throwable> onError() {
        return err -> System.out.println("ERROR: " + err.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("COMPLETED");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
