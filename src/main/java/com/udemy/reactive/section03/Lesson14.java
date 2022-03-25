package com.udemy.reactive.section03;

import reactor.core.publisher.Mono;

public class Lesson14 {
    public static void main(String[] args) {
        //publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        mono.subscribe(i-> System.out.println("Received : " + i));
    }
}
