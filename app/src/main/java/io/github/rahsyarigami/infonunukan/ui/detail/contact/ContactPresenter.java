package io.github.rahsyarigami.infonunukan.ui.detail.contact;

import io.github.rahsyarigami.infonunukan.data.local.RepoLocal;

public class ContactPresenter {

    private iContactView contactView;

    public ContactPresenter(){

    }

    public ContactPresenter(ImportantContactFragment view){
        this.contactView = view;
    }

    public void onCreateView(){
        contactView.setUpView();
    }

    public void loadData(){
        contactView.displayData(RepoLocal.getContactData());
    }
}
