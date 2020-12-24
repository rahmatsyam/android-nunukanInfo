package io.github.rahsyarigami.infonunukan.ui.detail.contact;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.View;

import io.github.rahsyarigami.infonunukan.data.local.RepoLocal;
import io.github.rahsyarigami.infonunukan.databinding.FragmentImportantContactBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutRecylerviewBinding;
import io.github.rahsyarigami.infonunukan.ui.adapter.KontakPentingAdapter;
import io.github.rahsyarigami.infonunukan.ui.base.BaseFragment;


public class ImportantContactFragment extends BaseFragment {

    public static final String THIRD_FRAGMENT = "third_fragment";

    private FragmentImportantContactBinding binding;
    private LayoutRecylerviewBinding recyclerViewBinding;


    public ImportantContactFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initEvents() {
        recyclerViewBinding = binding.rvContact;

        setRVContact();

        stopLoadShimmer();
    }

    private void setRVContact() {
        KontakPentingAdapter adapter = new KontakPentingAdapter(RepoLocal.getContactData(), getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewBinding.recyclerview.setLayoutManager(layoutManager);
        recyclerViewBinding.recyclerview.setHasFixedSize(true);
        recyclerViewBinding.recyclerview.setAdapter(adapter);

    }

    private void stopLoadShimmer() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.shimmerView.stopShimmer();
                binding.shimmerView.setVisibility(View.GONE);
            }
        }, 1000);
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.shimmerView.stopShimmer();
    }

    @Override
    public void onStop() {
        super.onStop();
        binding.shimmerView.stopShimmer();
    }

}