import java.util.List;

public class Zoo<T extends Animal> {

    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
        source.clear();
    }
}

class Animal {
    @Override
    public String toString() {
        return "Animal";
    }
}

class Lion extends Animal {
    @Override
    public String toString() {
        return "Арслан";
    }
}

class Crane extends Animal {
    @Override
    public String toString() {
        return "Тогоруу";
    }
}