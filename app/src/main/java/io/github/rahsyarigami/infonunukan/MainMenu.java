package io.github.rahsyarigami.infonunukan;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;


import io.github.rahsyarigami.infonunukan.decoration.AutoFitGridLayoutManager;

import io.github.rahsyarigami.infonunukan.model.ItemData;
import io.github.rahsyarigami.infonunukan.util.BaseActivity;
import io.github.rahsyarigami.infonunukan.view.activity.InfoWisata;
import io.github.rahsyarigami.infonunukan.view.activity.KontakPenting;
import io.github.rahsyarigami.infonunukan.view.activity.KulinerDO;
import io.github.rahsyarigami.infonunukan.view.activity.TentangNunukan;
import io.github.rahsyarigami.infonunukan.view.adapter.MainAdapter;


public class MainMenu extends BaseActivity implements MainAdapter.ListItemClickListener{


    Toolbar toolbar;

    CarouselView carouselView;
    List<ItemData> itemList;

    int[] sampleImages = {R.drawable.wisata_islamic, R.drawable.wisata_alun_alun, R.drawable.wisata_binusan, R.drawable.wisata_pantai_ecing, R.drawable.wisata_sunset};
    RecyclerView recyclerView;

    LayoutInflater inflater;
    AlertDialog.Builder builder;
    View dialogView;

    private int closeApp = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crashlyticsView();
        setContentView(R.layout.activity_main);

        orientationPotrait();

        setToolbar();

        setCarouselView();

        addData();

        setRecyclerView();

    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        MainAdapter adapter = new MainAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        /*GridLayoutManager manager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);*/
        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setCarouselView() {
        carouselView = findViewById(R.id.caouselView);
        carouselView.setImageListener(imageListener);

        carouselView.setPageCount(sampleImages.length);


    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.id.caouselView, 100, 100));
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
