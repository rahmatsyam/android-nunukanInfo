package io.github.rahsyarigami.infonunukan.ui.detail.deliverfood;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemFoodDeliver;
import io.github.rahsyarigami.infonunukan.databinding.FragmentFoodDetailDialogBinding;
import io.github.rahsyarigami.infonunukan.ui.base.BaseDialogFragment;
import io.github.rahsyarigami.infonunukan.util.GlideHelper;

public class FoodDetailDialogFragment extends BaseDialogFragment {

    private static final String ARG_PARAM1 = "param1";

    private FragmentFoodDetailDialogBinding binding;

    public static final String TAG_FOOD_DETAIL = "tag_food_detail";

    public FoodDetailDialogFragment() {
        // Required empty public constructor
    }

    public static FoodDetailDialogFragment newInstance(ItemFoodDeliver itemFoodDeliver) {
        FoodDetailDialogFragment fragment = new FoodDetailDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, itemFoodDeliver);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initEvents() {
        receivedData();
    }

    @Override
    protected void initStyle() {
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    private void receivedData(){
        Bundle bundle = getArguments();
        if (bundle != null){
            ItemFoodDeliver itemFoodDeliver = bundle.getParcelable(ARG_PARAM1);
            binding.tvDescFood.setText(itemFoodDeliver.getDeskKuliner());
            GlideHelper.setImageFromUrl(binding.ivFoodDetail, itemFoodDeliver.getUrlPhoto());
        }
    }
}