package com.udemy.reactive.section04;

import reactor.core.publisher.Flux;

public class Lesson33 {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        Flux<Integer> eveFlux = flux.filter(i -> i % 2 == 0);

        flux.subscribe(i -> System.out.println("s1: " + i));
        eveFlux.subscribe(i -> System.out.println("s2: " + i));
    }
}
