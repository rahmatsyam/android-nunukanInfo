package io.github.rahsyarigami.infonunukan.data.model;

import com.squareup.moshi.Json;

public class ItemContact {

    @Json(name = "nama")
    private String nama;
    @Json(name = "telpon")
    private String telpon;
    @Json(name = "alamat")
    private String alamat;

    private int color;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
