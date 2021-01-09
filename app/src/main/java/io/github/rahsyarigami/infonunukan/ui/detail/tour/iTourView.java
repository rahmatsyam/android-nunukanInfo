package io.github.rahsyarigami.infonunukan.ui.detail.tour;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemTour;

public interface iTourView {
    void displayData(List<ItemTour> tourList);
    void setUpView();

}
