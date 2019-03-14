package io.github.rahsyarigami.infonunukan.view.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.decoration.CustomDividerItemDecoration;
import io.github.rahsyarigami.infonunukan.model.ItemKuliner;
import io.github.rahsyarigami.infonunukan.util.BaseActivity;
import io.github.rahsyarigami.infonunukan.view.adapter.KulinerAdapter;

public class KulinerDO extends BaseActivity {

    RecyclerView recyclerViewKuliner;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    List<ItemKuliner> itemList;
    ShimmerFrameLayout shimmerKuliner;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crashlyticsView();
        setContentView(R.layout.activity_kuliner_do);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
        orientationPotrait();
        recyclerViewKuliner = findViewById(R.id.recyclerview);
        shimmerKuliner = findViewById(R.id.shimmer_kuliner);
        shimmerKuliner.startShimmer();
        addDataKuliner();

        recyclerViewKuliner.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerViewKuliner.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewKuliner.addItemDecoration(new CustomDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 0));
        KulinerAdapter adapter = new KulinerAdapter(itemList, Glide.with(this));
        recyclerViewKuliner.setAdapter(adapter);

        stopLoadShimmer();
    }

    private void addDataKuliner() {
        itemList = new ArrayList<>();
        itemList.add(new ItemKuliner(R.drawable.img_brownis, "Novitasari Jumriani", "082251347220", R.string.txt_desc_kuliner_novitasari));
        itemList.add(new ItemKuliner(R.drawable.img_keripik, "Riska Tursina", "081256198205", R.string.txt_desc_kuliner_riska));
        itemList.add(new ItemKuliner(R.drawable.img_ayam_geprek, "Yeni Oktafia", "081254860593", R.string.txt_desc_kuliner_yeni));


    }

    private void stopLoadShimmer() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmerKuliner.stopShimmer();
                shimmerKuliner.setVisibility(View.GONE);
            }
        }, 1000);
    }


    @Override
    public void onBackPressed() {
        Glide.get(this).clearMemory();
        finish();
    }


}
