package io.github.rahsyarigami.infonunukan.ui.main.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemTentang;
import io.github.rahsyarigami.infonunukan.databinding.ItemTentangNunukanBinding;

public class AboutNunukanAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private final Context mContext;
    private  List<ItemTentang> mItemData;

    public AboutNunukanAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ItemTentang> list){
        mItemData = list;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemTentangNunukanBinding binding = ItemTentangNunukanBinding.inflate(inflater, viewGroup, false);
        return new HomeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bindTo(mItemData.get(position));
        animate(holder);
    }

    private void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(mContext, R.anim.slide_right);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

    @Override
    public int getItemCount() {
        return mItemData.size();
    }

}
