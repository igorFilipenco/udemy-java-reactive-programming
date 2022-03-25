package com.udemy.reactive.section03;

import com.udemy.reactive.util.Util;

public class Lesson30 {
    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("file03.txt", "This is file3!")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.delete("file03.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
