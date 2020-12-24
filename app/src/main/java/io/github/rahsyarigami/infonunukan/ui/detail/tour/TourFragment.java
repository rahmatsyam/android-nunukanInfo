package io.github.rahsyarigami.infonunukan.ui.detail.tour;

import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.View;

import com.bumptech.glide.Glide;

import io.github.rahsyarigami.infonunukan.data.local.RepoLocal;
import io.github.rahsyarigami.infonunukan.databinding.FragmentTourBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutRecylerviewBinding;
import io.github.rahsyarigami.infonunukan.ui.adapter.InfoWisataAdapter;
import io.github.rahsyarigami.infonunukan.ui.base.BaseFragment;

public class TourFragment extends BaseFragment {


    private FragmentTourBinding binding;
    private LayoutRecylerviewBinding recyclerViewBinding;

    public static final String SECOND_FRAGMENT = "second_fragment";

    public TourFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TourFragment newInstance(String param1, String param2) {
        TourFragment fragment = new TourFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initEvents() {

        recyclerViewBinding = binding.rvTour;

        setRecyclerTour();

        fadeCardView();

    }

    private void setRecyclerTour() {

        InfoWisataAdapter adapter = new InfoWisataAdapter(RepoLocal.getTourData(), Glide.with(this));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBinding.recyclerview.setLayoutManager(linearLayoutManager);
        recyclerViewBinding.recyclerview.setHasFixedSize(true);
        recyclerViewBinding.recyclerview.setAdapter(adapter);

    }

    private void fadeCardView() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0f);
        valueAnimator.setDuration(4000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                binding.cardTip.setAlpha(alpha);
            }
        });
        valueAnimator.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.cardTip.setVisibility(View.GONE);
            }
        }, 4100);

    }

}