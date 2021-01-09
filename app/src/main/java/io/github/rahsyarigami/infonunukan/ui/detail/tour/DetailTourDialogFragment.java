package io.github.rahsyarigami.infonunukan.ui.detail.tour;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemTour;
import io.github.rahsyarigami.infonunukan.databinding.FragmentDetailTourDialogBinding;
import io.github.rahsyarigami.infonunukan.ui.base.BaseDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailTourDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailTourDialogFragment extends BaseDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    public static final String TAG_FULLSCREEN = "tag_fullscreen";

    private FragmentDetailTourDialogBinding binding;


    public DetailTourDialogFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailTourDialogFragment newInstance(ItemTour itemTour) {
        DetailTourDialogFragment fragment = new DetailTourDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, itemTour);
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

    private void receivedData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            ItemTour itemTour = bundle.getParcelable(ARG_PARAM1);
            binding.tvHeader.setText(itemTour.getItemTitle());
            binding.imgInfoWisata.setImageResource(itemTour.getItemIconTour());
            binding.tvDescription.setText(itemTour.getItemDescription());

        }

        binding.tvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}