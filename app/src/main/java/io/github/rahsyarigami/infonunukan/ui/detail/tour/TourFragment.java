package io.github.rahsyarigami.infonunukan.ui.detail.tour;

import android.animation.ValueAnimator;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Handler;
import android.view.View;

import com.bumptech.glide.Glide;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemTour;
import io.github.rahsyarigami.infonunukan.databinding.FragmentTourBinding;


import io.github.rahsyarigami.infonunukan.ui.base.BaseFragment;
import io.github.rahsyarigami.infonunukan.ui.detail.tour.adapter.InfoWisataAdapter;
import io.github.rahsyarigami.infonunukan.ui.detail.tour.adapter.OnItemTourClickListener;
import io.github.rahsyarigami.infonunukan.util.StarSnapHelper;

public class TourFragment extends BaseFragment implements iTourView {


    private FragmentTourBinding binding;
//    private LayoutRecylerviewBinding recyclerViewBinding;

    public static final String SECOND_FRAGMENT = "second_fragment";

    private TourPresenter presenter;
    private InfoWisataAdapter adapter;

    int REQUEST_CODE_DIALOG_FRAGMENT = 30;

    public TourFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initEvents() {

//        recyclerViewBinding = binding.rvTour;

        presenter = new TourPresenter(this);
        presenter.onCreateView();
        presenter.loadData();

    }

    @Override
    public void displayData(List<ItemTour> tourList) {
        adapter = new InfoWisataAdapter();
        adapter.setData(tourList, Glide.with(this));
        binding.rvTour.setAdapter(adapter);
        adapter.setItemClick(new OnItemTourClickListener() {
            @Override
            public void onItemClick(ItemTour itemTour) {

                DetailTourDialogFragment dialogFragment = DetailTourDialogFragment.newInstance(itemTour);
                dialogFragment.setTargetFragment(TourFragment.this, REQUEST_CODE_DIALOG_FRAGMENT);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                dialogFragment.show(ft, DetailTourDialogFragment.TAG_FULLSCREEN);

            }
        });
    }

    @Override
    public void setUpView() {
        SnapHelper snapHelper = new StarSnapHelper();
        snapHelper.attachToRecyclerView(binding.rvTour);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvTour.setLayoutManager(linearLayoutManager);
        binding.rvTour.setHasFixedSize(true);

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