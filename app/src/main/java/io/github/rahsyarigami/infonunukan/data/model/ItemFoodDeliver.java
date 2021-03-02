package io.github.rahsyarigami.infonunukan.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class ItemFoodDeliver implements Parcelable {

    @Json(name = "nama_pemilik")
    private String namaPemilik;
    @Json(name = "telpon")
    private String telpon;
    @Json(name = "desk_kuliner")
    private String deskKuliner;
    @Json(name = "url_photo")
    private String urlPhoto;

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getDeskKuliner() {
        return deskKuliner;
    }

    public void setDeskKuliner(String deskKuliner) {
        this.deskKuliner = deskKuliner;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaPemilik);
        dest.writeString(this.telpon);
        dest.writeString(this.deskKuliner);
        dest.writeString(this.urlPhoto);
    }

    private ItemFoodDeliver(Parcel in){
        this.namaPemilik = in.readString();
        this.telpon = in.readString();
        this.deskKuliner = in.readString();
        this.urlPhoto = in.readString();
    }

    public static Parcelable.Creator<ItemFoodDeliver> CREATOR = new Parcelable.Creator<ItemFoodDeliver>() {
        @Override
        public ItemFoodDeliver createFromParcel(Parcel source) {
            return new ItemFoodDeliver(source);
        }

        @Override
        public ItemFoodDeliver[] newArray(int size) {
            return new ItemFoodDeliver[size];
        }
    };


}

