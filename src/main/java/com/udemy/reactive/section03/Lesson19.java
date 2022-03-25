package com.udemy.reactive.section03;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Mono;

public class Lesson19 {

    public static void main(String[] args) {
        userRepository(2)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else return Mono.error(new RuntimeException("Not in the allowed range"));
    }
}
