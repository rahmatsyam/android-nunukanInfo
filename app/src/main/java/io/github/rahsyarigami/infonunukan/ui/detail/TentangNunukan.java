package io.github.rahsyarigami.infonunukan.ui.detail;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemTentang;
import io.github.rahsyarigami.infonunukan.ui.base.BaseActivity;
import io.github.rahsyarigami.infonunukan.ui.adapter.TentangNunukanAdapter;

public class TentangNunukan extends BaseActivity {

    RecyclerView recyclerViewTentang;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    List<ItemTentang> itemList;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        crashlyticsView();
        setContentView(R.layout.activity_tentang_nunukan);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
        orientationPotrait();

        addDataTentang();

        setRecyclerViewTentang();


    }

    private void setRecyclerViewTentang() {
        recyclerViewTentang = findViewById(R.id.recyclerview);
        recyclerViewTentang.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerViewTentang.setLayoutManager(recyclerViewLayoutManager);
        TentangNunukanAdapter adapter = new TentangNunukanAdapter(itemList, this);
        recyclerViewTentang.setAdapter(adapter);
    }

    private void addDataTentang() {
        itemList = new ArrayList<>();
        itemList.add(new ItemTentang(R.string.txt_sejarah_nunukan, R.string.txt_desc_suku, R.string.txt_desc_hasil_budidaya, R.string.txt_desc_geografi));

    }
}
