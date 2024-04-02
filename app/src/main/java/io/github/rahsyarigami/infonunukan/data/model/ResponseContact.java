package io.github.rahsyarigami.infonunukan.data.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class ResponseContact {
    @Json(name = "data")
    private List<ItemContact> data = new ArrayList<>();

    public List<ItemContact> getData() {
        return data;
    }

    public void setData(List<ItemContact> data) {
        this.data = data;
    }
}
