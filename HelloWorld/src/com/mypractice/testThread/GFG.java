package com.mypractice.testThread;

import java.util.concurrent.CompletableFuture;

public class GFG {
    public static void main(String[] args) throws Exception
    {
        CompletableFuture<String> greetingFuture
                = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<String> helloFuture
                = CompletableFuture.supplyAsync(() -> "Hello");


        CompletableFuture<String> combinedFuture
                = helloFuture.thenCombine(
                greetingFuture, (m1, m2) -> m1 + " " + m2);

        System.out.println(combinedFuture.get());
    }
}

