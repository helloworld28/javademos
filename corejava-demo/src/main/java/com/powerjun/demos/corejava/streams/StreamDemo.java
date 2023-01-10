package com.powerjun.demos.corejava.streams;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) throws InterruptedException {
        Stream<String> foo = Stream.of("foo", "bar");
        Stream<String> split = Stream.of("Foo bar".split(" "));
        IntStream stream = Arrays.stream(new int[]{1, 2, 3}, 0, 1);

        Stream<String> empty = Stream.empty();

        //enerate infinite stream
//        Stream<String> generate = Stream.generate(() -> "echo");
//        generate.forEach(System.out::println);
        Stream<Double> generate1 = Stream.generate(Math::random);


        List<String> words = Arrays.asList("Hello", "world");

        words.stream().flatMapToInt((word) -> word.codePoints());

//        Stream<Integer> concat = Stream.concat("Hello".codePoints(), "world".codePoints());


        Stream<String> distinct = Stream.of("Hello", "Hello").distinct();



        Stream<String> sorted = words.stream().sorted();

        System.out.println("test peek");
        Object[] objects = Stream.iterate(1.0, p -> p * 2)
                .peek(System.out::println)
                .limit(20)
                .toArray();

        List<AtomicInteger> integerStream = Arrays.asList(new AtomicInteger(0), new AtomicInteger(10));
        List<AtomicInteger> collect = integerStream.stream().peek(item -> item.incrementAndGet()).collect(Collectors.toList());
        System.out.println(collect);
        integerStream.forEach(System.out::println);

        BitSet bitSet = new BitSet(1024);
        Boolean[] booleanArray = new Boolean[1024];

        Thread.currentThread().sleep(1000000);

    }
}
