package io.github.rahsyarigami.infonunukan.ui.detail.contact;

import android.util.Log;

import androidx.annotation.NonNull;

import io.github.rahsyarigami.infonunukan.data.model.APIError;
import io.github.rahsyarigami.infonunukan.data.model.ResponseContact;
import io.github.rahsyarigami.infonunukan.data.remote.APIClient;

import io.github.rahsyarigami.infonunukan.util.ErrorUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactPresenter {

    private iContactView contactView;

    public ContactPresenter() {

    }

    public ContactPresenter(ImportantContactFragment view) {
        this.contactView = view;
    }

    public void onCreateView() {
        contactView.setUpView();
    }

    public void loadData() {
        contactView.showShimmer(true);
        APIClient.getResponseContact(new Callback<ResponseContact>() {
            @Override
            public void onResponse(@NonNull Call<ResponseContact> call, @NonNull Response<ResponseContact> response) {

                if (response.isSuccessful() && response.body() != null) {
                    contactView.showShimmer(false);
                    ResponseContact responseContact = response.body();
                    contactView.displayData(responseContact.getData());

                } else {
                    APIError error = ErrorUtils.parseError(response);
                    Log.d("error message ", error.message());
                }

            }

            @Override
            public void onFailure(@NonNull Call<ResponseContact> call, @NonNull Throwable t) {
                    contactView.showShimmer(false);
            }
        });
    }
}
