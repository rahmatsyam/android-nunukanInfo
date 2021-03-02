package io.github.rahsyarigami.infonunukan.ui.detail.deliverfood;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;

import com.bumptech.glide.Glide;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemFoodDeliver;
import io.github.rahsyarigami.infonunukan.databinding.FragmentFoodDeliverBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutRecylerviewBinding;
import io.github.rahsyarigami.infonunukan.ui.detail.deliverfood.adapter.KulinerAdapter;
import io.github.rahsyarigami.infonunukan.ui.base.BaseFragment;

public class FoodDeliverFragment extends BaseFragment implements iFoodView {

    private FragmentFoodDeliverBinding binding;
    private LayoutRecylerviewBinding rvBinding;

    public static final String FOURTH_FRAGMENT = "fourth_fragment";

    private KulinerAdapter adapter;
    private FoodDeliverPresenter presenter;

    int REQUEST_CODE_DIALOG_FRAGMENT = 30;

    public FoodDeliverFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initEvents() {
        rvBinding = binding.rvFoodDeliver;

        presenter = new FoodDeliverPresenter(this);
        presenter.onCreateView();
        presenter.loadData();

    }

    private void stopLoadShimmer() {
        binding.shimmerKuliner.stopShimmer();
        binding.shimmerKuliner.setVisibility(View.GONE);

    }


    @Override
    public void displayData(List<ItemFoodDeliver> listFood) {
        adapter = new KulinerAdapter();
        adapter.setData(listFood, Glide.with(this));
        adapter.notifyDataSetChanged();
        rvBinding.recyclerview.setAdapter(adapter);
        adapter.setClickItem(itemFoodDeliver -> {
            FoodDetailDialogFragment dialogFragment = FoodDetailDialogFragment.newInstance(itemFoodDeliver);
            dialogFragment.setTargetFragment(FoodDeliverFragment.this, REQUEST_CODE_DIALOG_FRAGMENT);
            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            dialogFragment.show(ft,FoodDetailDialogFragment.TAG_FOOD_DETAIL);
        });
    }

    @Override
    public void setUpView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvBinding.recyclerview.setLayoutManager(layoutManager);
//        rvBinding.recyclerview.addItemDecoration(new CustomDividerItemDecoration(requireActivity(), LinearLayoutManager.VERTICAL, 0));
        rvBinding.recyclerview.setHasFixedSize(true);
    }

    @Override
    public void showShimmer(boolean showShimmer) {
        if (!showShimmer) {
            stopLoadShimmer();
        }
    }
}