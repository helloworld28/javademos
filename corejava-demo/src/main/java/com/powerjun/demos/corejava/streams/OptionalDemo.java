package com.powerjun.demos.corejava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> hello = Optional.of("Hello");
        //default value
        String hi = hello.orElse("hi");

        String hi1 = hello.orElseGet(() -> System.getenv("hi"));

        String s = hello.orElseThrow(IllegalArgumentException::new);

        List<String> results = new ArrayList<>();
        hello.ifPresent(v -> System.out.println(v));

        hello.ifPresent(results::add);

        //keep optional intact, think optional as stream with zero or one size

        Optional<String> toUppper = hello.map(v -> v.toUpperCase(Locale.ROOT));
        hello.filter(v -> v.length() > 0)
                .map(v -> v.toUpperCase(Locale.ROOT));

        //
//        Optional<U> u = foo().flatMap(Foo::bar);




    }

    public static Optional<Foo> foo(){
        return Optional.of(new Foo());
    }

    static class Foo{
        static Optional<String> bar(String str){
            return Optional.ofNullable(str);
        }
    }
}
