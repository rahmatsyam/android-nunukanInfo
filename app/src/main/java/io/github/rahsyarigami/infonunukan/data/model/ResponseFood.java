package io.github.rahsyarigami.infonunukan.data.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class ResponseFood {

    @Json(name = "data")
    private List<ItemFoodDeliver> data = new ArrayList<>();

    public List<ItemFoodDeliver> getData() {
        return data;
    }

    public void setData(List<ItemFoodDeliver> data) {
        this.data = data;
    }

}
