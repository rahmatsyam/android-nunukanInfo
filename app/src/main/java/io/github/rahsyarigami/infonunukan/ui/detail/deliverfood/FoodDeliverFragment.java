package io.github.rahsyarigami.infonunukan.ui.detail.deliverfood;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.View;

import com.bumptech.glide.Glide;

import io.github.rahsyarigami.infonunukan.data.local.RepoLocal;
import io.github.rahsyarigami.infonunukan.databinding.FragmentFoodDeliverBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutRecylerviewBinding;
import io.github.rahsyarigami.infonunukan.ui.adapter.KulinerAdapter;
import io.github.rahsyarigami.infonunukan.ui.base.BaseFragment;
import io.github.rahsyarigami.infonunukan.util.decoration.CustomDividerItemDecoration;


public class FoodDeliverFragment extends BaseFragment {

    private FragmentFoodDeliverBinding binding;
    private LayoutRecylerviewBinding rvBinding;

    public static final String FOURTH_FRAGMENT = "fourth_fragment";

    public FoodDeliverFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initEvents() {
        rvBinding = binding.rvFoodDeliver;

        setRVFoodDeliver();
        stopLoadShimmer();

    }

    private void setRVFoodDeliver() {
        KulinerAdapter adapter = new KulinerAdapter(RepoLocal.getFoodData(), Glide.with(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvBinding.recyclerview.setLayoutManager(layoutManager);
        rvBinding.recyclerview.addItemDecoration(new CustomDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL, 0));
        rvBinding.recyclerview.setHasFixedSize(true);
        rvBinding.recyclerview.setAdapter(adapter);
    }

    private void stopLoadShimmer() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.shimmerKuliner.stopShimmer();
                binding.shimmerKuliner.setVisibility(View.GONE);
            }
        }, 1000);
    }

}