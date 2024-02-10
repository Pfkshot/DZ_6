import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Laptop {
    private String name;
    private int ozu;
    private int hardDisk;
    private String os;
    private String color;

    public Laptop(String name, int ozu, int hardDisk, String os, String color) {
        this.name = name;
        this.ozu = ozu;
        this.hardDisk = hardDisk;
        this.os = os;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getOZU() {
        return ozu;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public String getOS() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        HashSet<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("model 1",8,512,"Windows","blue"));
        laptops.add(new Laptop("model 2",4,1000,"Linux","black"));
        laptops.add(new Laptop("model 3",16,2000,"MacOS","white"));
        laptops.add(new Laptop("model 4",32,1000,"Windows","grey"));

        Map<String, String> criteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер критерия фильтрации: 1 - ОЗУ, 2 - Объем ЖД, 3 - Операционная система, 4 - Цвет");
        String key = scanner.nextLine();

        System.out.println("Введите значение:");
        String value = scanner.nextLine();

        criteria.put(key, value);

        result(laptops, criteria);
    }

    public static void result(Set<Laptop> laptops, Map<String, String> criteria) {
        for (Laptop laptop : laptops) {
            boolean filter = true;

            for (Map.Entry<String, String> entry : criteria.entrySet()) {
                String criterionNumber = entry.getKey();
                String criterionValue = entry.getValue();

                switch (criterionNumber) {
                    case "1": // ОЗУ
                        if (laptop.getOZU() == Integer.parseInt(criterionValue)) {
                            filter = false;
                        }
                        break;
                    case "2": // Объем ЖД
                        if (laptop.getHardDisk() == Integer.parseInt(criterionValue)) {
                            filter = false;
                        }
                        break;
                    case "3": // Операционная система
                        if (!laptop.getOS().equals(criterionValue)) {
                            filter = false;
                        }
                        break;
                    case "4": // Цвет
                        if (!laptop.getColor().equals(criterionValue)) {
                            filter = false;
                        }
                        break;
                }
            }

            if (filter) {
                System.out.println(laptop.getName());
            }
        }
    }
}
