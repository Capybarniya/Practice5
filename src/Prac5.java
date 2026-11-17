import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Instrument implements Comparable<Instrument> {
    private String name;
    private String type;
    private int volume;

    public Instrument(String name, String type, int volume) {
        this.name = name;
        this.type = type;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println(name + " (" + type + "), громкость: " + volume);
    }

    public abstract void play();

    @Override
    public int compareTo(Instrument other) {
        return this.volume - other.volume;
    }
}

class Guitar extends Instrument {
    private int strings;
    private boolean electric;

    public Guitar(String name, int volume, int strings, boolean electric) {
        super(name, "Струнный", volume);
        this.strings = strings;
        this.electric = electric;
    }

    public void play() {
        if (electric) {
            System.out.println(getName() + " играет электро-рифф");
        } else {
            System.out.println(getName() + " играет акустический аккорд");
        }
    }
}

class Piano extends Instrument {
    private int keys;
    private String brand;

    public Piano(String name, int volume, int keys, String brand) {
        super(name, "Клавишный", volume);
        this.keys = keys;
        this.brand = brand;
    }

    public void play() {
        System.out.println(brand + " " + getName() + " играет мелодию");
    }
}

public class Prac5 {
    static void main(String[] args) {
        List<Instrument> instruments = new ArrayList<>();

        instruments.add(new Guitar("Fender", 7, 6, true));
        instruments.add(new Piano("Grand", 5, 88, "Yamaha"));
        instruments.add(new Guitar("Taylor", 4, 6, false));
        instruments.add(new Piano("Baby Grand", 8, 88, "Steinway"));

        System.out.println("До сортировки:");
        for (Instrument inst : instruments) {
            inst.showInfo();
            inst.play();
        }

        Collections.sort(instruments);

        System.out.println("\nПосле сортировки по громкости:");
        for (Instrument inst : instruments) {
            inst.showInfo();
            inst.play();
        }
    }
}