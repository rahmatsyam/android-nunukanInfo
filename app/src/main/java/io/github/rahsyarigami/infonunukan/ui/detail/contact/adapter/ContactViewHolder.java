package io.github.rahsyarigami.infonunukan.ui.detail.contact.adapter;

import androidx.recyclerview.widget.RecyclerView;

import io.github.rahsyarigami.infonunukan.data.model.ItemContact;
import io.github.rahsyarigami.infonunukan.databinding.ItemKontakPentingBinding;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private final ItemKontakPentingBinding mBinding;

    public ContactViewHolder(ItemKontakPentingBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindTo(ItemContact itemContact, OnItemContactClickListener listener) {
        mBinding.tvNamaKontak.setText(itemContact.getNama());
        mBinding.tvIcon.setText(itemContact.getNama().substring(0, 1));
        mBinding.tvAlamat.setText(itemContact.getAlamat());
        mBinding.tvTelepon.setText(itemContact.getTelpon());
        mBinding.ivIcon.setColorFilter(itemContact.getColor());

        mBinding.btnCall.setOnClickListener(v -> listener.onItemClick(itemContact));

        mBinding.btnCopy.setOnClickListener(v -> listener.onItemCopy(itemContact));
    }
}
