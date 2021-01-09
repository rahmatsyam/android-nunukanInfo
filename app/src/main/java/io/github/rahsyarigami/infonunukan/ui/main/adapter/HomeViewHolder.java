package io.github.rahsyarigami.infonunukan.ui.main.adapter;

import androidx.recyclerview.widget.RecyclerView;

import io.github.rahsyarigami.infonunukan.data.model.ItemTentang;
import io.github.rahsyarigami.infonunukan.databinding.ItemTentangNunukanBinding;


public class HomeViewHolder extends RecyclerView.ViewHolder {

    private final ItemTentangNunukanBinding mBinding;

    public HomeViewHolder(ItemTentangNunukanBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindTo(ItemTentang item){
        mBinding.tvDeskripsiSejarah.setText(item.getItemHistory());
        mBinding.tvSuku.setText(item.getItemEthnic());
        mBinding.tvHasilBudidaya.setText(item.getItemCultivation());
        mBinding.tvDeskripsiGeografi.setText(item.getItemGeography());

    }

}
