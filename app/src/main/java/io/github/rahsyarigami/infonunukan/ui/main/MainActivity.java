package io.github.rahsyarigami.infonunukan.ui.main;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;


import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;


import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.databinding.ActivityMainBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutGridviewBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutRecylerviewBinding;
import io.github.rahsyarigami.infonunukan.util.decoration.AutoFitGridLayoutManager;

import io.github.rahsyarigami.infonunukan.data.model.ItemData;
import io.github.rahsyarigami.infonunukan.ui.base.BaseActivity;
import io.github.rahsyarigami.infonunukan.ui.detail.InfoWisata;
import io.github.rahsyarigami.infonunukan.ui.detail.KontakPenting;
import io.github.rahsyarigami.infonunukan.ui.detail.KulinerDO;
import io.github.rahsyarigami.infonunukan.ui.detail.TentangNunukan;
import io.github.rahsyarigami.infonunukan.ui.main.adapter.MainAdapter;


public class MainActivity extends BaseActivity implements MainAdapter.ListItemClickListener {

    List<ItemData> itemList;

    int[] sampleImages = {R.drawable.wisata_islamic, R.drawable.wisata_alun_alun, R.drawable.wisata_binusan, R.drawable.wisata_pantai_ecing, R.drawable.wisata_sunset};

    LayoutInflater inflater;
    AlertDialog.Builder builder;
    View dialogView;

    private int closeApp = 2;

    private ActivityMainBinding mainBinding;
    private LayoutGridviewBinding gridViewBinding;
    private LayoutRecylerviewBinding recyclerViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        gridViewBinding = mainBinding.menuGridview;

        recyclerViewBinding = gridViewBinding.menuRecyclerview;

        View view = mainBinding.getRoot();

        setContentView(view);

        orientationPotrait();

        setToolbar();

        setCarouselView();

        addData();

        setRecyclerView();

    }

    private void setRecyclerView() {

        MainAdapter adapter = new MainAdapter(itemList, this);

        recyclerViewBinding.recyclerview.setAdapter(adapter);
        recyclerViewBinding.recyclerview.setHasFixedSize(true);
        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerViewBinding.recyclerview.setLayoutManager(layoutManager);
    }

    private void setCarouselView() {
        gridViewBinding.carouselView.setImageListener(imageListener);

        gridViewBinding.carouselView.setPageCount(sampleImages.length);


    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.id.carouselView, 100, 100));
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void setToolbar() {
        setSupportActionBar(mainBinding.toolbar);
    }

    private void addData() {
        itemList = new ArrayList<>();
        itemList.add(new ItemData("Info Wisata", R.drawable.ic_tour));
        itemList.add(new ItemData("Kontak Penting", R.drawable.ic_mobile_phone));
        itemList.add(new ItemData("Kuliner DO", R.drawable.ic_kuliner));
        itemList.add(new ItemData("Tentang Nunukan", R.drawable.ic_maps));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                intentShare();
                break;
            case R.id.action_about:
                dialogAbout();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void intentShare() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=io.github.rahsyarigami.infonunukan");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.txt_send_to)));
    }

    @SuppressLint("InflateParams")
    private void dialogAbout() {
        builder = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_app_about, null);
        builder.setView(dialogView);
        builder.setCancelable(true);
        builder.show();
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent;
        switch (clickedItemIndex) {
            case 0:
                intent = new Intent(this, InfoWisata.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, KontakPenting.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, KulinerDO.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, TentangNunukan.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        closeApp -= 1;
        switch (closeApp) {
            case 1:
                Toast.makeText(getApplicationContext(), "Tekan kembali lagi untuk keluar", Toast.LENGTH_LONG).show();
                break;
            case 0:
                moveTaskToBack(true);
                finish();
                break;
        }

    }


}
