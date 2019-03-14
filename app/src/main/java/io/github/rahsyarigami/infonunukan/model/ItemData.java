package io.github.rahsyarigami.infonunukan.model;

public class ItemData {
    private String itemListName;
    private int itemListIcon;


    public ItemData(String itemName, int itemIcon) {
        this.itemListName = itemName;
        this.itemListIcon = itemIcon;

    }

    public String getItemName() {
        return itemListName;
    }

    public int getItemIcon() {
        return itemListIcon;
    }


}
