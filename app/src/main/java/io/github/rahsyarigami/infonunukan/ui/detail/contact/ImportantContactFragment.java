package io.github.rahsyarigami.infonunukan.ui.detail.contact;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemContact;
import io.github.rahsyarigami.infonunukan.databinding.FragmentImportantContactBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutRecylerviewBinding;
import io.github.rahsyarigami.infonunukan.ui.detail.contact.adapter.KontakPentingAdapter;
import io.github.rahsyarigami.infonunukan.ui.base.BaseFragment;
import io.github.rahsyarigami.infonunukan.ui.detail.contact.adapter.OnItemContactClickListener;
import io.github.rahsyarigami.infonunukan.util.DialogUtils;
import io.github.rahsyarigami.infonunukan.util.ViewUtils;

public class ImportantContactFragment extends BaseFragment implements iContactView {

    public static final String THIRD_FRAGMENT = "third_fragment";

    private FragmentImportantContactBinding binding;
    private LayoutRecylerviewBinding recyclerViewBinding;

    private KontakPentingAdapter adapter;
    private ContactPresenter presenter;

    public ImportantContactFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initEvents() {
        recyclerViewBinding = binding.rvContact;

        presenter = new ContactPresenter(this);
        presenter.onCreateView();
        presenter.loadData();

    }

    private void stopLoadShimmer() {
        binding.shimmerView.stopShimmer();
        binding.shimmerView.setVisibility(View.GONE);

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

    @Override
    public void displayData(List<ItemContact> contactList) {

        adapter = new KontakPentingAdapter();
        adapter.setData(contactList, getActivity());
        recyclerViewBinding.recyclerview.setAdapter(adapter);
        adapter.setClickItem(new OnItemContactClickListener() {
            @Override
            public void onItemClick(ItemContact itemContact) {
                String message = "Apakah Anda ingin menghubungi " + itemContact.getNama() + " ?";
                DialogUtils.showConfirm(requireActivity(), message, (dialog, which) -> {
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:" + itemContact.getTelpon()));
                            startActivity(intent);
                        }, (dialog, which) -> {

                        }
                );

            }

            @Override
            public void onItemCopy(ItemContact itemContact) {
                ViewUtils.copyNumber(itemContact.getTelpon(), itemContact.getNama(), requireActivity());
            }


        });

    }

    @Override
    public void setUpView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewBinding.recyclerview.setLayoutManager(layoutManager);
        recyclerViewBinding.recyclerview.setHasFixedSize(true);
    }

    @Override
    public void showShimmer(boolean showShimmer) {

        if (!showShimmer) {
            stopLoadShimmer();

        }
    }
}