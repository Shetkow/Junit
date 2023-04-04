import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 3);
        int b = calc.minus.apply(4, 2);
        int c = calc.devide.apply(a, b);// Происходит ошибка деления на 0
        calc.println.accept(c);
    }
}

class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> y == 0 ? 0 : y;

    ;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Consumer<Integer> println = System.out::println;
}