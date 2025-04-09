import java.util.*;
import java.util.stream.*;

public class ProductAnalyzer {

    public static Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
                .filter(p -> p.getPrice() > 1000)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void main(String[] args) {
        List<Product> list = Arrays.asList(
                new Product("Гутал", 1500, "Хувцас"),
                new Product("Цамц", 1200, "Хувцас"),
                new Product("Бүтээлэг", 800, "Тавилга")
        );

        Map<String, List<Product>> result = analyze(list);
        result.forEach((category, items) -> {
            System.out.println(category + ": " + items);
        });
    }
}

class Product {
    private String name;
    private int price;
    private String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}