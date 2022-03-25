package com.udemy.reactive.section03;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lesson25 {
    public static void main(String[] args) {
        Mono.fromFuture(getName())
        .subscribe(Util.onNext());

        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return  CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
