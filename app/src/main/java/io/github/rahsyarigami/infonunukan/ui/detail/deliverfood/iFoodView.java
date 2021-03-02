package io.github.rahsyarigami.infonunukan.ui.detail.deliverfood;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemFoodDeliver;
import io.github.rahsyarigami.infonunukan.data.model.ItemKuliner;

public interface iFoodView {

    void displayData(List<ItemFoodDeliver> listFood);

    void setUpView();

    void showShimmer(boolean showShimmer);
}
