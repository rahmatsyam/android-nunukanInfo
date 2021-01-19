package io.github.rahsyarigami.infonunukan.ui.detail;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemKontak;
import io.github.rahsyarigami.infonunukan.ui.base.BaseActivity;
import io.github.rahsyarigami.infonunukan.ui.detail.contact.adapter.KontakPentingAdapter;

public class KontakPenting extends BaseActivity implements SearchView.OnQueryTextListener {

    ShimmerFrameLayout shimmerFrameLayout;
    RecyclerView recyclerViewContact;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    List<ItemKontak> itemList;
    RelativeLayout layoutSearching;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_kontak_penting);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

        orientationPotrait();

        shimmerFrameLayout = findViewById(R.id.shimmer_view);

        layoutSearching = findViewById(R.id.layout_searching);

        shimmerFrameLayout.startShimmer();

        addData();

        setRecyclerViewContact();

        stopLoadShimmer();


    }

    private void setRecyclerViewContact() {
        recyclerViewContact = findViewById(R.id.recyclerview);
        recyclerViewContact.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        //recyclerViewContact.setItemAnimator(new DefaultItemAnimator());
        recyclerViewContact.setLayoutManager(recyclerViewLayoutManager);
        KontakPentingAdapter adapter = new KontakPentingAdapter();
        recyclerViewContact.setAdapter(adapter);
    }

    private void addData() {
        itemList = new ArrayList<>();
        itemList.add(new ItemKontak("RSUD Nunukan", R.string.txt_almt_rs_nunukan, "0556-21118"));
        itemList.add(new ItemKontak("Damkar Nunukan", R.string.txt_almt_damkar_nunukan, "0556-22800"));
        itemList.add(new ItemKontak("PLN Nunukan", R.string.txt_almt_pln_nunukan, "0556-2025411"));
        itemList.add(new ItemKontak("PDAM Nunukan", R.string.txt_almt_pdam_nunukan, "0556-21035"));
        itemList.add(new ItemKontak("Polres Nunukan", R.string.txt_almt_polres_nunukan, "0556-2027898"));


    }


    private void stopLoadShimmer() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }
        }, 1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Cari kontak");
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<ItemKontak> filterModelList = filter(itemList, newText);
        if (filterModelList.size() > 0) {
//            recyclerViewadapter = new KontakPentingAdapter(filterModelList, this);
            recyclerViewContact.setAdapter(recyclerViewadapter);
            return true;
        } else {
            layoutSearching.setVisibility(View.VISIBLE);

        }
        return false;
    }

    private List<ItemKontak> filter(List<ItemKontak> models, String query) {
        query = query.toLowerCase();
        final List<ItemKontak> filterModelList = new ArrayList<>();
        for (ItemKontak model : models) {
            final String text = model.getItemContact().toLowerCase();
            if (text.contains(query)) {
                filterModelList.add(model);
                layoutSearching.setVisibility(View.GONE);
            }
        }

//        recyclerViewadapter = new KontakPentingAdapter(filterModelList, this);
        recyclerViewContact.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewContact.setAdapter(recyclerViewadapter);
        recyclerViewadapter.notifyDataSetChanged();
        return filterModelList;
    }

   /* @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }*/

    @Override
    public void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmer();
    }

    @Override
    public void onStop() {
        super.onStop();
        shimmerFrameLayout.stopShimmer();
    }


}
