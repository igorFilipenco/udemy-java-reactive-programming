package com.udemy.reactive.section04;

import com.udemy.reactive.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lesson38 {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received subscription: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext" + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        System.out.println("cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(4);

    }
}
