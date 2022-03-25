package com.udemy.reactive.section03;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Mono;

public class Lesson15 {
    public static void main(String[] args) {
        //pub
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
