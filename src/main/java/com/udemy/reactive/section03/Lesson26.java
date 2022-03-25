package com.udemy.reactive.section03;

import com.udemy.reactive.util.Util;
import reactor.core.publisher.Mono;


public class Lesson26 {
    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Is done. Sending notifications...");
                        }
                );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println();
            System.out.println("Step completed");
        };
    }
}
