package io.github.rahsyarigami.infonunukan.ui.detail.tour.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemTour;
import io.github.rahsyarigami.infonunukan.databinding.ItemInfoWisataBinding;

public class InfoWisataAdapter extends RecyclerView.Adapter<TourViewHolder> {

    private List<ItemTour> mItemData;
    private RequestManager mGlide;

    OnItemTourClickListener mListener;

    public InfoWisataAdapter() {

    }

    public void setData(List<ItemTour> getItemTour, RequestManager glide) {
        mGlide = glide;
        mItemData = getItemTour;
    }

    public void setItemClick(OnItemTourClickListener clickListener) {
        mListener = clickListener;

    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemInfoWisataBinding binding = ItemInfoWisataBinding.inflate(inflater, viewGroup, false);
        return new TourViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        holder.bindTo(mItemData.get(position), mGlide, mListener);


    }

    @Override
    public int getItemCount() {
        return mItemData.size();
    }

}
