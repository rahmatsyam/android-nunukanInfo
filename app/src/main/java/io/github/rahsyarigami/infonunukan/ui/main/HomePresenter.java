package io.github.rahsyarigami.infonunukan.ui.main;

import io.github.rahsyarigami.infonunukan.data.local.RepoLocal;

public class HomePresenter {
    private iMainView mainView;

    public HomePresenter() {
    }

    public HomePresenter(HomeFragment view) {
        this.mainView = view;
    }

    public void onCreateView() {
        mainView.setUpView();
    }

    public void loadData() {
        mainView.displayData(RepoLocal.getAboutData());
    }

}
