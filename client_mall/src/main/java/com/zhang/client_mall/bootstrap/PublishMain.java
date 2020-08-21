package com.zhang.client_mall.bootstrap;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class PublishMain {
    public static void main(String[] args) {
        Flux.just("A","B").map(item -> item+"i am run !").subscribe(new Subscriber<String>() {
            private Subscription sub;
            private int count = 0;
            @Override
            public void onSubscribe(Subscription subscription) {
                sub = subscription;
                sub.request(1);
            }

            @Override
            public void onNext(String s) {
                if (count==0){
                    throw new RuntimeException("i am zero");
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("i am error");
            }

            @Override
            public void onComplete() {
                System.out.println("i am complete");
            }
        });
    }
}
