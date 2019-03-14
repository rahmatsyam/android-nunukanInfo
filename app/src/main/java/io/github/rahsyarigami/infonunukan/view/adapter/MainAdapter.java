package io.github.rahsyarigami.infonunukan.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.model.ItemData;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    //private Context mContext;
    private List<ItemData> mItemData;
    final private ListItemClickListener mOnClickListener;

    public MainAdapter(List<ItemData> getItemData,  ListItemClickListener listener) {
        mOnClickListener = listener;
        //mContext = context;
        mItemData = getItemData;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        final ItemData getItemData1 = mItemData.get(position);
        viewHolder.textView.setText(getItemData1.getItemName());
        viewHolder.imageView.setImageResource(getItemData1.getItemIcon());



    }

    @Override
    public int getItemCount() {
        return mItemData.size();
    }



    // ListItemClickListener
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;


        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.txt_item);
            imageView = view.findViewById(R.id.icon_item);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }


    }


}
