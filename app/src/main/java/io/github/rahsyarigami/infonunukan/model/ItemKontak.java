package io.github.rahsyarigami.infonunukan.model;

public class ItemKontak {
    private String itemListContact;
    private int itemListAddress;
    private String itemListPhone;


    public ItemKontak(String itemContact, int itemAddress, String itemPhone) {

        this.itemListContact = itemContact;
        this.itemListAddress = itemAddress;
        this.itemListPhone = itemPhone;
    }


    public String getItemContact() {
        return itemListContact;
    }

    public int getItemAddress() {
        return itemListAddress;
    }

    public String getItemPhone() {
        return itemListPhone;
    }
}
