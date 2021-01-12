package io.github.rahsyarigami.infonunukan.ui.detail.contact;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemKontak;

public interface iContactView {
    void displayData(List<ItemKontak> contactList);
    void setUpView();
}
