package io.github.rahsyarigami.infonunukan.data.model;

public class ItemTour {

    private String itemListTitle;
    private int itemListDescription;
    private int itemListIconTour;


    public ItemTour(String itemTitle, int itemDescription, int itemIconTour) {

        this.itemListTitle = itemTitle;
        this.itemListDescription = itemDescription;
        this.itemListIconTour = itemIconTour;
    }


    public String getItemTitle() {
        return itemListTitle;
    }

    public int getItemDescription() {
        return itemListDescription;
    }

    public int getItemIconTour() {
        return itemListIconTour;
    }
}

