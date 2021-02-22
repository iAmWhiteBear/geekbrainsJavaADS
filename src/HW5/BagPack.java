package HW5;

import java.util.ArrayList;
import java.util.Random;

public class BagPack {
    private static final Double LIMITWEIGHT = 15.0;
    private static Item[] items;
    private static String[] itemNames = {"спички", "паспорт", "стакан", "ложка и вилка", "мобильный", "нож", "носки", "доширак", "трусы", "утюг"};


    public static void main(String[] args) {
        items = generateItems();
        for (Item i: items) i.displayFull();

        System.out.println(solution(items.length));

    }

    //TODO
    public static ItemSet solution(int nItems) {
        if (nItems == 0) return new ItemSet();

        ItemSet include = solution(nItems - 1);
        include.add(items[nItems-1]);
        ItemSet exclude = solution(nItems-1);

        if (include.getWeight() < LIMITWEIGHT) {
            if (include.getValue() > exclude.getValue()) return include;
        }

        return exclude;
    }

    public static Item[] generateItems() {
        String name = itemNames[new Random().nextInt(itemNames.length)];
        Item[] items = new Item[itemNames.length];
        for (int i = 0; i < itemNames.length; i++) {
            items[i] = new Item(itemNames[i], Math.random() * 5, Math.random() * 20);
        }
        return items;
    }

    private static class Item {
        public final String name;
        public final Double weight;
        public final Double value;

        public Item(String name, Double weight, Double value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return name;
        }

        public void displayFull() {
            System.out.format("%s, value=%.2f, weight=%.2f %n", name, value, weight);
        }
    }

    private static class ItemSet {
        private final ArrayList<Item> set;
        private Double weight;
        private Double value;

        private ItemSet() {
            this.set = new ArrayList<>();
            this.weight = 0.0;
            this.value = 0.0;
        }

        public void add(Item item) {
            set.add(item);
            this.weight += item.weight;
            this.value += item.value;
        }

        public Double getWeight() {
            return weight;
        }

        public Double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "ItemSet{" +
                    set +
                    String.format("} value=%.2f, weight=%.2f", value, weight);
        }
    }


}
