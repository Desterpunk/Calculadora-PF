package main;

import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculadora {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> add = (a,b) -> a + b;
        BiFunction<Integer,Integer,Integer> substraction = (a,b) -> a - b;
        BiFunction<Integer,Integer,Integer> multiplication = (a,b) -> IntStream.range(0, Math.abs(b)+1)
                        .reduce((accumulator, number) -> b<=0 ? add.apply(accumulator-a,0) : add.apply(accumulator + a, 0)).getAsInt();

        BiFunction<Integer,Integer,Integer> division = (a,b) -> IntStream.range(0, Math.abs(a)+1)
                        .reduce((accumulator,number) ->
                                multiplication.apply(a,b) == 0 ? accumulator = 0:
                                multiplication.apply(a,b) < 0 ? multiplication.apply(number,Math.abs(b)) <= Math.abs(a) ? add.apply(accumulator,-1) : accumulator :
                                multiplication.apply(number,Math.abs(b)) <= Math.abs(a) ? add.apply(accumulator,1) : accumulator).getAsInt();


        System.out.println("Calculator functional");
        System.out.println("Summa: " + add.apply(5,5));
        System.out.println("Subtraction: " + substraction.apply(10,3));
        System.out.println("Multiplication: " + multiplication.apply(10,-10));
        System.out.println("Division: " + division.apply(-10,5));
    }
}
