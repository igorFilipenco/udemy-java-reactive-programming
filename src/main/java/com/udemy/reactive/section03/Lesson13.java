package com.udemy.reactive.section03;

import java.util.stream.Stream;

public class Lesson13 {
    public static void main(String[] args) {
        Stream<Integer> st = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return i * 2;
                });

        st.forEach(System.out::println);
    }
}
