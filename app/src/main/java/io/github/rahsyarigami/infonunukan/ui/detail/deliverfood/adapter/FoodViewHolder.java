package io.github.rahsyarigami.infonunukan.ui.detail.deliverfood.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;

import io.github.rahsyarigami.infonunukan.data.model.ItemFoodDeliver;
import io.github.rahsyarigami.infonunukan.databinding.ItemKulinerDeliveryBinding;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    protected ItemKulinerDeliveryBinding mBinding;

    public FoodViewHolder(ItemKulinerDeliveryBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindTo(ItemFoodDeliver itemFoodDeliver, RequestManager glide, OnItemFoodClickListener listener) {
        mBinding.tvNamaUsaha.setText(itemFoodDeliver.getNamaPemilik());
        mBinding.tvDeskripsiKuliner.setText(itemFoodDeliver.getDeskKuliner());
        mBinding.tvKontakKuliner.setText(itemFoodDeliver.getTelpon());
        glide.load(itemFoodDeliver.getUrlPhoto()).centerCrop().into(mBinding.imgProfilKuliner);
        mBinding.btnMore.setOnClickListener(v -> listener.onItemClick(itemFoodDeliver));
    }
}
