package io.github.rahsyarigami.infonunukan.data.remote;

import android.util.Log;

import com.squareup.moshi.Moshi;

import java.util.concurrent.TimeUnit;

import io.github.rahsyarigami.infonunukan.data.model.ResponseContact;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://rahmatsyam.github.io/nunukan-info/";
    private static final APIServices api = APIClient.getClient().create(APIServices.class);

    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.e("Check API ", message));

            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            Moshi moshi = new Moshi.Builder().build();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RetryCallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build();
        }

        return retrofit;
    }

    public static void getResponseContact(Callback<ResponseContact> callback) {
        Call<ResponseContact> call = api.getResponseContact();
        call.enqueue(callback);
    }
}
