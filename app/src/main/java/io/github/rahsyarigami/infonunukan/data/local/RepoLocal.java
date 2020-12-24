package io.github.rahsyarigami.infonunukan.data.local;

import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemKontak;
import io.github.rahsyarigami.infonunukan.data.model.ItemKuliner;
import io.github.rahsyarigami.infonunukan.data.model.ItemTentang;
import io.github.rahsyarigami.infonunukan.data.model.ItemTour;

public class RepoLocal {

    public static List<ItemTour> getTourData() {

        List<ItemTour> itemList = new ArrayList<>();

        itemList.clear();
        itemList.add(new ItemTour("Islamic Center Nunukan", R.string.txt_islamic_center, R.drawable.wisata_islamic));
        itemList.add(new ItemTour("Alun-Alun", R.string.txt_alun_alun, R.drawable.wisata_alun_alun));
        itemList.add(new ItemTour("Binusan", R.string.txt_binusan, R.drawable.wisata_binusan));
        itemList.add(new ItemTour("Pantai Ecing", R.string.txt_pantai_ecing, R.drawable.wisata_pantai_ecing));

        return itemList;
    }

    public static List<ItemKontak> getContactData() {

        List<ItemKontak> itemList = new ArrayList<>();

        itemList.clear();
        itemList.add(new ItemKontak("RSUD Nunukan", R.string.txt_almt_rs_nunukan, "0556-21118"));
        itemList.add(new ItemKontak("Damkar Nunukan", R.string.txt_almt_damkar_nunukan, "0556-22800"));
        itemList.add(new ItemKontak("PLN Nunukan", R.string.txt_almt_pln_nunukan, "0556-2025411"));
        itemList.add(new ItemKontak("PDAM Nunukan", R.string.txt_almt_pdam_nunukan, "0556-21035"));
        itemList.add(new ItemKontak("Polres Nunukan", R.string.txt_almt_polres_nunukan, "0556-2027898"));

        return itemList;

    }

    public static List<ItemKuliner> getFoodData() {

        List<ItemKuliner> itemList = new ArrayList<>();

        itemList.clear();
        itemList.add(new ItemKuliner(R.drawable.img_brownis, "Novitasari Jumriani", "082251347220", R.string.txt_desc_kuliner_novitasari));
        itemList.add(new ItemKuliner(R.drawable.img_keripik, "Riska Tursina", "081256198205", R.string.txt_desc_kuliner_riska));
        itemList.add(new ItemKuliner(R.drawable.img_ayam_geprek, "Yeni Oktafia", "081254860593", R.string.txt_desc_kuliner_yeni));

        return itemList;
    }

    public static List<ItemTentang> getAboutData() {

        List<ItemTentang> itemList = new ArrayList<>();

        itemList.clear();
        itemList.add(new ItemTentang(R.string.txt_sejarah_nunukan, R.string.txt_desc_suku, R.string.txt_desc_hasil_budidaya, R.string.txt_desc_geografi));

        return itemList;
    }

    public static List<SlideModel> getSlideModel(){
        List<SlideModel> itemList = new ArrayList<>();
        itemList.clear();
        itemList.add(new SlideModel(R.drawable.wisata_islamic,"", null));
        itemList.add(new SlideModel(R.drawable.wisata_alun_alun,"", null));
        itemList.add(new SlideModel(R.drawable.wisata_binusan,"", null));
        itemList.add(new SlideModel(R.drawable.wisata_pantai_ecing,"", null));

        return itemList;

    }


}
