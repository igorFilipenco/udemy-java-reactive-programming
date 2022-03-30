package com.udemy.reactive.section04;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lesson34 {
    public static void main(String[] args) {
//        List<String> letters = Arrays.asList("a", "b", "c");
        Integer[] arr = {1,2,3,4,5 };
        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}
