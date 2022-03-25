package com.udemy.reactive.section03;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Mono;

public class Lesson20 {
    public static void main(String[] args) {
        getName();
        getName().subscribe(
                Util.onNext()
        );
        getName();
    }

    private static Mono<String> getName() {
        System.out.println("Executing getName method");

        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
