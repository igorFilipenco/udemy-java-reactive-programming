package com.udemy.reactive.section04;


import com.udemy.reactive.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


public class StockPriceObserver {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        emitStockPrice()
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Start observing");
                        this.subscription = subscription;
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer stockPrice) {
                        System.out.println("Current stock price is - " + stockPrice);
                        if (stockPrice < 90 || stockPrice > 110) {
                            System.out.println("Subscription cancelled due to raising stock price");
                            subscription.cancel();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                        latch.countDown();
                    }
                });

        latch.await();
    }

    private static Flux<Integer> emitStockPrice() {
        AtomicInteger subscriptionAtomic = new AtomicInteger(100);

        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> subscriptionAtomic.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        Integer::sum
                ));
    }
}
