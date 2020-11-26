package io.github.rahsyarigami.infonunukan.ui.detail;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.rahsyarigami.infonunukan.R;

import io.github.rahsyarigami.infonunukan.data.model.ItemTour;
import io.github.rahsyarigami.infonunukan.ui.base.BaseActivity;
import io.github.rahsyarigami.infonunukan.ui.adapter.InfoWisataAdapter;


public class InfoWisata extends BaseActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    List<ItemTour> itemList;
    MaterialCardView cardView;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_wisata);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

        orientationPotrait();


        addData();

        setRecyclerView();

        fadeCardview();


    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);

        recyclerViewlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //InfoWisataAdapter adapter = new InfoWisataAdapter((ItemTourListPresenter) itemList);
        InfoWisataAdapter adapter = new InfoWisataAdapter(itemList, Glide.with(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
    }

    private void addData() {

        itemList = new ArrayList<>();
        itemList.add(new ItemTour("Islamic Center Nunukan", R.string.txt_islamic_center, R.drawable.wisata_islamic));
        itemList.add(new ItemTour("Alun-Alun", R.string.txt_alun_alun, R.drawable.wisata_alun_alun));
        itemList.add(new ItemTour("Binusan", R.string.txt_binusan, R.drawable.wisata_binusan));
        itemList.add(new ItemTour("Pantai Ecing", R.string.txt_pantai_ecing, R.drawable.wisata_pantai_ecing));

    }


    private void fadeCardview() {
        cardView = findViewById(R.id.cardView);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0f);
        valueAnimator.setDuration(4000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                cardView.setAlpha(alpha);
            }
        });
        valueAnimator.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cardView.setVisibility(View.GONE);
            }
        }, 4100);

    }

    @Override
    public void onBackPressed() {
        Glide.get(this).clearMemory();
        finish();
    }


 /*   private void animCardview(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        animation.reset();
        cardView = findViewById(R.id.cardView);
        cardView.clearAnimation();
        cardView.startAnimation(animation);
    }*/

}
