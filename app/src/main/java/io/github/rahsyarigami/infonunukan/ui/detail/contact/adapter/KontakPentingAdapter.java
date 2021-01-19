package io.github.rahsyarigami.infonunukan.ui.detail.contact.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemContact;
import io.github.rahsyarigami.infonunukan.databinding.ItemKontakPentingBinding;
import io.github.rahsyarigami.infonunukan.util.ViewUtils;


public class KontakPentingAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private Context mContext;
    private List<ItemContact> mItemContact;
    private OnItemContactClickListener mListener;

    public KontakPentingAdapter() {

    }

    public void setData(List<ItemContact> contactList, Context context) {
        mItemContact = contactList;
        mContext = context;
        notifyDataSetChanged();
    }

    public void setClickItem(OnItemContactClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemKontakPentingBinding binding = ItemKontakPentingBinding.inflate(inflater, viewGroup, false);
        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bindTo(setFilterColor().get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mItemContact.size();
    }

    private List<ItemContact> setFilterColor() {
        List<ItemContact> contactList = new ArrayList<>();
        contactList.clear();
        for (ItemContact itemContact : mItemContact) {
            itemContact.setColor(ViewUtils.getRandomGeneratorColor("400", mContext));
            contactList.add(itemContact);
        }
        return contactList;
    }


}
