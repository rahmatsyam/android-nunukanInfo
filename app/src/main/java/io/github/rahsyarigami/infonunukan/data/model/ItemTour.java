package io.github.rahsyarigami.infonunukan.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemTour implements Parcelable {

    private final String itemListTitle;
    private final int itemListDescription;
    private final int itemListIconTour;

    public ItemTour(String itemTitle, int itemDescription, int itemIconTour) {
        this.itemListTitle = itemTitle;
        this.itemListDescription = itemDescription;
        this.itemListIconTour = itemIconTour;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemListTitle);
        dest.writeInt(this.itemListDescription);
        dest.writeInt(this.itemListIconTour);
    }

    private ItemTour(Parcel in) {
        this.itemListTitle = in.readString();
        this.itemListDescription = in.readInt();
        this.itemListIconTour = in.readInt();

    }

    public static Parcelable.Creator<ItemTour> CREATOR = new Parcelable.Creator<ItemTour>() {
        @Override
        public ItemTour createFromParcel(Parcel source) {
            return new ItemTour(source);
        }

        @Override
        public ItemTour[] newArray(int size) {
            return new ItemTour[size];
        }
    };


    public String getItemTitle() {
        return itemListTitle;
    }

    public int getItemDescription() {
        return itemListDescription;
    }

    public int getItemIconTour() {
        return itemListIconTour;
    }


}

