package com.udemy.reactive.section04;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Lesson32 {
    public static void main(String[] args) {
        Flux<Object> fl = Flux.just(1, 2, 3, 4, 5, "a", Util.faker().name().fullName());

        fl.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
