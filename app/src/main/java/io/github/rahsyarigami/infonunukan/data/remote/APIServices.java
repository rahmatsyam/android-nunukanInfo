package io.github.rahsyarigami.infonunukan.data.remote;

import io.github.rahsyarigami.infonunukan.data.model.ResponseContact;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIServices {

    @Retry
    @GET("contact/data_contact.json")
    @Headers({"Content-Type: application/json"})
    Call<ResponseContact> getResponseContact();

}
