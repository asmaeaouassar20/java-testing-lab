package org.algostyle.items;

public class Item implements Comparable<Item> {
    private int size;
    private String description;

    public Item(int size, String description){
        this.size=size;
        this.description=description;
    }

    @Override
    public int compareTo(Item o) {
        return description.compareTo(o.description);
    }
}
