package io.github.rahsyarigami.infonunukan.ui.detail.tour;

import io.github.rahsyarigami.infonunukan.data.local.RepoLocal;


public class TourPresenter {

    private iTourView tourView;

    public TourPresenter() {
    }

    public TourPresenter(TourFragment view) {
       this.tourView = view;
    }

    public void onCreateView() {
        tourView.setUpView();

    }

    public void loadData() {
        tourView.displayData(RepoLocal.getTourData());
    }
}
