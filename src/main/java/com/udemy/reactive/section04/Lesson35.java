package com.udemy.reactive.section04;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lesson35 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5);
        Stream<Integer> streamNums = nums.stream();

//        streamNums.forEach(System.out::println);
//        streamNums.forEach(System.out::println);

        Flux<Integer> integerFlux = Flux.fromStream(streamNums);
        integerFlux
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
//        integerFlux
//                .subscribe(
//                        Util.onNext(),
//                        Util.onError(),
//                        Util.onComplete()
//                );
    }
}
