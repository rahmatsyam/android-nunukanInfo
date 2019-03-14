package io.github.rahsyarigami.infonunukan.model;

public class ItemKuliner {

    private int itemListIconKuliner;
    private String itemListProfilKuliner;
    private String itemListContactKuliner;
    private int itemListDescriptionKuliner;


    public ItemKuliner(int itemIconKuliner, String itemProfilKuliner, String itemContactKuliner, int itemDescriptionKuliner ){

        this.itemListIconKuliner = itemIconKuliner;
        this.itemListProfilKuliner = itemProfilKuliner;
        this.itemListContactKuliner = itemContactKuliner;
        this.itemListDescriptionKuliner = itemDescriptionKuliner;
    }

    public int getItemIconKuliner(){
        return itemListIconKuliner;
    }

    public String getItemProfilKuliner(){
        return itemListProfilKuliner;
    }

    public String getItemContactKuliner(){
        return itemListContactKuliner;
    }

    public int getItemDescriptionKuliner(){
        return itemListDescriptionKuliner;
    }
}
