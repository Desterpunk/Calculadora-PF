package main;

import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculadora {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> add = (a,b) -> a + b;
        BiFunction<Integer,Integer,Integer> substraction = (a,b) -> a - b;
        BiFunction<Integer,Integer,Integer> multiplication = (a,b) -> IntStream.range(0, b+1)
                        .reduce((accumulator, number) -> add.apply(accumulator + a , 0)).getAsInt();
        BiFunction<Integer,Integer,Integer> division = (a,b) -> IntStream.range(0, a+1)
                        .reduce((accumulator,number) -> multiplication.apply(number,b) <= a ? add.apply(accumulator,1) : accumulator).getAsInt();

        System.out.println("Calculator functional");
        System.out.println("Summa: " + add.apply(5,5));
        System.out.println("Subtraction: " + substraction.apply(10,3));
        System.out.println("Multiplication: " + multiplication.apply(10,3));
        System.out.println("Division: " + division.apply(100,5));
    }
}
