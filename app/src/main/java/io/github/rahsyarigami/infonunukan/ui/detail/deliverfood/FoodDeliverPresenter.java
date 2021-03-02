package io.github.rahsyarigami.infonunukan.ui.detail.deliverfood;

import android.util.Log;

import androidx.annotation.NonNull;

import io.github.rahsyarigami.infonunukan.data.model.APIError;
import io.github.rahsyarigami.infonunukan.data.model.ResponseFood;
import io.github.rahsyarigami.infonunukan.data.remote.APIClient;
import io.github.rahsyarigami.infonunukan.util.ErrorUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodDeliverPresenter {

    private iFoodView foodView;

    public FoodDeliverPresenter() {

    }

    public FoodDeliverPresenter(FoodDeliverFragment view) {
        this.foodView = view;
    }

    public void onCreateView() {
        foodView.setUpView();
    }

    public void loadData() {
        foodView.showShimmer(true);
        APIClient.getResponseFood(new Callback<ResponseFood>() {
            @Override
            public void onResponse(@NonNull Call<ResponseFood> call, @NonNull Response<ResponseFood> response) {
                if (response.isSuccessful() && response.body() != null){
                    ResponseFood responseFood = response.body();
                    foodView.displayData(responseFood.getData());
                    foodView.showShimmer(false);
                } else {
                    APIError error = ErrorUtils.parseError(response);
                    Log.d("error message ", error.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseFood> call, @NonNull Throwable t) {
                foodView.showShimmer(false);
            }
        });

    }
}
