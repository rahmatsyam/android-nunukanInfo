package io.github.rahsyarigami.infonunukan.view.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.model.ItemTour;

public class InfoWisataAdapter extends RecyclerView.Adapter<InfoWisataAdapter.WisataViewHolder> {

    private List<ItemTour> mItemData;
    private RequestManager mGlide;


    public InfoWisataAdapter(List<ItemTour> getItemTour, RequestManager glide) {

        mGlide = glide;
        mItemData = getItemTour;
    }


    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //  View view = LayoutInflater.from(mContext).inflate(R.layout.item_info_wisata, viewGroup, false);
        //  View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_info_wisata, viewGroup, false);
        /*View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_info_wisata, viewGroup, false);
        return new WisataViewHolder(view);*/
        return new WisataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_info_wisata, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final WisataViewHolder viewHolder, final int position) {
        final ItemTour getItemData2 = mItemData.get(position);
        mGlide.load(getItemData2.getItemIconTour()).into(viewHolder.ikonWisata).clearOnDetach();
        viewHolder.judulWisata.setText(getItemData2.getItemTitle());
        viewHolder.deskripsiWisata.setText(getItemData2.getItemDescription());
        viewHolder.deskripsiWisata.setEllipsize(TextUtils.TruncateAt.END);


        viewHolder.BTbacaSelengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.BTbacaSelengkapnya.setVisibility(View.GONE);
                viewHolder.BTkembali.setVisibility(View.VISIBLE);
                viewHolder.deskripsiWisata.setMaxLines(Integer.MAX_VALUE);

               /* ViewTreeObserver viewTreeObserver = viewHolder.deskripsiWisata.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        ViewTreeObserver viewTreeObserver1 = viewHolder.deskripsiWisata.getViewTreeObserver();
                        viewTreeObserver1.removeOnGlobalLayoutListener(this);

                        if (viewHolder.deskripsiWisata.getLineCount() > 2) {
                            int endOfLastLine = viewHolder.deskripsiWisata.getLayout().getLineEnd(10);
                            String newLine = viewHolder.deskripsiWisata.getText().subSequence(0, endOfLastLine - 3) + "...";
                            viewHolder.deskripsiWisata.setText(newLine);
                        }
                    }
                });*/


            }
        });
        viewHolder.BTkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.BTkembali.setVisibility(View.GONE);
                viewHolder.BTbacaSelengkapnya.setVisibility(View.VISIBLE);
                viewHolder.deskripsiWisata.setMaxLines(3);
                viewHolder.deskripsiWisata.setEllipsize(TextUtils.TruncateAt.END);

            }
        });


    }


    @Override
    public int getItemCount() {
        return mItemData.size();
    }


    class WisataViewHolder extends RecyclerView.ViewHolder {

        ImageView ikonWisata;
        TextView judulWisata;
        TextView deskripsiWisata;
        Button BTbacaSelengkapnya;
        ImageButton BTkembali;

        WisataViewHolder(View view) {
            super(view);
            ikonWisata = view.findViewById(R.id.img_infoWisata);
            judulWisata = view.findViewById(R.id.tv_title);
            deskripsiWisata = view.findViewById(R.id.tv_description);
            BTbacaSelengkapnya = view.findViewById(R.id.btn_readMore);
            BTkembali = view.findViewById(R.id.btn_close);


        }


    }


}
