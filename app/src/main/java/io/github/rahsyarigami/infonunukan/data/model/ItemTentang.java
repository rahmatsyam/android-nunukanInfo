package io.github.rahsyarigami.infonunukan.data.model;

public class ItemTentang {

    private int itemListHistory;
    private int itemListEthnic;
    private int itemListCultivation;
    private int itemListGeography;


    public ItemTentang(int itemHistory, int itemEthnic, int itemCultivation, int itemGeography) {

        this.itemListHistory = itemHistory;
        this.itemListEthnic = itemEthnic;
        this.itemListCultivation = itemCultivation;
        this.itemListGeography = itemGeography;
    }


    public int getItemHistory() {
        return itemListHistory;
    }

    public int getItemEthnic() {
        return itemListEthnic;
    }

    public int getItemCultivation() {
        return itemListCultivation;
    }

    public int getItemGeography() {
        return itemListGeography;
    }
}
