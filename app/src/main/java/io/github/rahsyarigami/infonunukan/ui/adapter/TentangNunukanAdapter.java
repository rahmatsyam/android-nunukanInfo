package io.github.rahsyarigami.infonunukan.ui.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemTentang;

public class TentangNunukanAdapter extends RecyclerView.Adapter<TentangNunukanAdapter.NunukanViewHolder> {

    private final Context mContext;
    private final List<ItemTentang> mIteData;

    public TentangNunukanAdapter(List<ItemTentang> getItemTentang, Context context) {
        mContext = context;
        mIteData = getItemTentang;
    }

    @NonNull
    @Override
    public NunukanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tentang_nunukan, viewGroup, false);
        return new NunukanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NunukanViewHolder viewHolder, int position) {
        final ItemTentang getItemData = mIteData.get(position);
        viewHolder.tvSejarahNunukan.setText(getItemData.getItemHistory());
        viewHolder.tvSukuNunukan.setText(getItemData.getItemEthnic());
        viewHolder.tvHasilBudidaya.setText(getItemData.getItemCultivation());
        viewHolder.tvGeografi.setText(getItemData.getItemGeography());

        animate(viewHolder);
    }

    private void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(mContext, R.anim.slide_right);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

    @Override
    public int getItemCount() {
        return mIteData.size();
    }

    static class NunukanViewHolder extends RecyclerView.ViewHolder {

        TextView tvSejarahNunukan;
        TextView tvSukuNunukan;
        TextView tvHasilBudidaya;
        TextView tvGeografi;

        NunukanViewHolder(View view) {
            super(view);
            tvSejarahNunukan = view.findViewById(R.id.tv_deskripsi_sejarah);
            tvSukuNunukan = view.findViewById(R.id.tv_suku);
            tvHasilBudidaya = view.findViewById(R.id.tv_hasil_budidaya);
            tvGeografi = view.findViewById(R.id.tv_deskripsi_geografi);
        }
    }
}
