package io.github.rahsyarigami.infonunukan.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetryCallAdapterFactory extends CallAdapter.Factory {

    private static final String TAG = "RetryCallAdapterFactory";

    public static RetryCallAdapterFactory create() {
        return new RetryCallAdapterFactory();
    }

    @Nullable
    @Override
    public CallAdapter<?, ?> get(@NonNull Type returnType, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        int shouldRetry = 0;
        final Retry retry = getRetry(annotations);
        if (retry != null) {
            shouldRetry = retry.max();
        }
        Log.d(TAG, "Starting a CallAdapter with {} retries. " + shouldRetry);
        return new RetryCallAdapter<>(
                retrofit.nextCallAdapter(this, returnType, annotations),
                shouldRetry
        );
    }

    private Retry getRetry(@NonNull Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof Retry) {
                return (Retry) annotation;
            }
        }

        return null;
    }

    static final class RetryCallAdapter<R, T> implements CallAdapter<R, T> {

        private final CallAdapter<R, T> delegated;
        private final int maxRetries;

        public RetryCallAdapter(CallAdapter<R, T> delegated, int maxRetries) {
            this.delegated = delegated;
            this.maxRetries = maxRetries;
        }

        @NonNull
        @Override
        public Type responseType() {
            return delegated.responseType();
        }

        @NonNull
        @Override
        public T adapt(@NonNull Call<R> call) {
            return delegated.adapt(maxRetries > 0 ? new RetryingCall<>(call, maxRetries) : call);
        }
    }

    static final class RetryingCall<R> implements Call<R> {

        private final Call<R> delegated;
        private final int maxRetries;

        public RetryingCall(Call<R> delegated, int maxRetries) {
            this.delegated = delegated;
            this.maxRetries = maxRetries;
        }

        @NonNull
        @Override
        public Response<R> execute() throws IOException {
            return delegated.execute();
        }

        @Override
        public void enqueue(@NonNull Callback<R> callback) {
            delegated.enqueue(new RetryCallback<>(delegated, callback, maxRetries));
        }

        @Override
        public boolean isExecuted() {
            return delegated.isExecuted();
        }

        @Override
        public void cancel() {
            delegated.cancel();
        }

        @Override
        public boolean isCanceled() {
            return delegated.isCanceled();
        }

        @NonNull
        @Override
        public Call<R> clone() {
            return new RetryingCall<>(delegated.clone(), maxRetries);
        }

        @NonNull
        @Override
        public Request request() {
            return delegated.request();
        }

        @NonNull
        @Override
        public Timeout timeout() {
            return delegated.timeout();
        }
    }

    static final class RetryCallback<T> implements Callback<T> {

        private final Call<T> call;
        private final Callback<T> callback;
        private final int maxRetries;

        public RetryCallback(Call<T> call, Callback<T> callback, int maxRetries) {
            this.call = call;
            this.callback = callback;
            this.maxRetries = maxRetries;
        }

        private final AtomicInteger retryCount = new AtomicInteger(0);

        @Override
        public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
            if (!response.isSuccessful() && retryCount.incrementAndGet() <= maxRetries) {
                Log.d(TAG, "Call with no success result code: {} " + response.code());
                retryCall();
            } else {
                callback.onResponse(call, response);
            }
        }

        @Override
        public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
            Log.d(TAG, "Call failed with message :  " + t.getMessage(), t);
            if (retryCount.incrementAndGet() <= maxRetries) {
                retryCall();
            } else if (maxRetries > 0) {
                Log.d(TAG, "No retries left sending timeout up. ");
                callback.onFailure(call,
                        new TimeoutException(String.format("No retries left after %s attempt. ", maxRetries)));
            } else {
                callback.onFailure(call, t);
            }
        }

        private void retryCall() {
            Log.w(TAG, "" + retryCount.get() + "/" + maxRetries + " " + " Retrying...");
            call.clone().enqueue(this);
        }


    }

}
