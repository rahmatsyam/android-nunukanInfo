package io.github.rahsyarigami.infonunukan.ui.detail.contact;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemContact;

public interface iContactView {
    void displayData(List<ItemContact> contactList);

    void setUpView();

    void showShimmer(boolean showShimmer);
}
