package io.github.rahsyarigami.infonunukan.ui.detail.tour.adapter;

import android.text.TextUtils;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;

import io.github.rahsyarigami.infonunukan.data.model.ItemTour;
import io.github.rahsyarigami.infonunukan.databinding.ItemInfoWisataBinding;

public class TourViewHolder extends RecyclerView.ViewHolder {

    protected ItemInfoWisataBinding mBinding;

    public TourViewHolder(ItemInfoWisataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindTo(final ItemTour item, RequestManager glide, final OnItemTourClickListener listener) {
        glide.load(item.getItemIconTour()).into(mBinding.imgInfoWisata).clearOnDetach();
        mBinding.tvTitle.setText(item.getItemTitle());
        mBinding.tvDescription.setText(item.getItemDescription());
        mBinding.tvDescription.setLines(3);
        mBinding.tvDescription.setEllipsize(TextUtils.TruncateAt.END);

        mBinding.btnReadMore.setOnClickListener(v -> listener.onItemClick(item));


    }

}
