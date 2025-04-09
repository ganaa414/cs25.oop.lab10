import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StringProcessor {

    public static void processStrings(List<String> list,
                                      Predicate<String> filter,
                                      Function<String, String> mapper,
                                      Consumer<String> action) {
        list.stream()
            .filter(filter)
            .map(mapper)
            .forEach(action);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Гарчиг", "Програмчлал", "Java");

        Predicate<String> longerThanFive = s -> s.length() > 5;
        Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();
        Consumer<String> print = s -> System.out.println("ГАРШИЛ: " + s.toUpperCase());

        processStrings(input, longerThanFive, reverse, print);
    }
}