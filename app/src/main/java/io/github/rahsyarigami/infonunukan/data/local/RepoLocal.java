package io.github.rahsyarigami.infonunukan.data.local;

import java.util.ArrayList;
import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemData;

public class RepoLocal {

    public static List<ItemData> getListItem() {

        List<ItemData> itemList = new ArrayList<>();

        itemList.clear();
        itemList.add(new ItemData("Info Wisata", R.drawable.ic_tour));
        itemList.add(new ItemData("Kontak Penting", R.drawable.ic_mobile_phone));
        itemList.add(new ItemData("Kuliner DO", R.drawable.ic_kuliner));
        itemList.add(new ItemData("Tentang Nunukan", R.drawable.ic_maps));

        return itemList;
    }


}
