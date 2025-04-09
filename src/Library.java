import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public Iterable<Book> bookShelf(int minYear) {
        return new BookShelf(minYear);
    }

    private class BookShelf implements Iterable<Book> {
        private int minYear;

        public BookShelf(int minYear) {
            this.minYear = minYear;
        }

        @Override
        public Iterator<Book> iterator() {
            return books.stream()
                    .filter(book -> book.getYear() >= minYear)
                    .iterator();
        }
    }
}

class Book {
    private String name;
    private int year;

    public Book(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + ": " + year;
    }
}