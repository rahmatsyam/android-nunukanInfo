package io.github.rahsyarigami.infonunukan.util;

import java.io.IOException;
import java.lang.annotation.Annotation;

import io.github.rahsyarigami.infonunukan.data.model.APIError;
import io.github.rahsyarigami.infonunukan.data.remote.APIClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter = APIClient.getClient()
                .responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            assert response.errorBody() != null;
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }
}
