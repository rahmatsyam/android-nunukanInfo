package io.github.rahsyarigami.infonunukan.ui.detail.deliverfood.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.model.ItemFoodDeliver;
import io.github.rahsyarigami.infonunukan.databinding.ItemKulinerDeliveryBinding;

public class KulinerAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List<ItemFoodDeliver> mItemKuliner;
    private RequestManager mGlide;

    OnItemFoodClickListener mListener;

    public KulinerAdapter() {

    }

    public void setData(List<ItemFoodDeliver> list, RequestManager glide) {
        mItemKuliner = list;
        mGlide = glide;

    }

    public void setClickItem(OnItemFoodClickListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemKulinerDeliveryBinding binding = ItemKulinerDeliveryBinding.inflate(inflater, viewGroup, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bindTo(mItemKuliner.get(position), mGlide, mListener);
    }


//
//                final String nameContact = kulinerHolder.tvNamaUsahaKuliner.getText().toString();
//                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                builder.setMessage("Apakah Anda ingin chat " + nameContact + " untuk menanyakan ketersediaan kuliner?")
//
//                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                final String codeCountry = "+62";
//                                String numberPhone = kulinerHolder.tvKontakKuliner.getText().toString();
//                                String hello = "Hello";
//                                Uri uri = Uri.parse("smsto:" + codeCountry + numberPhone.substring(1));
//                                Intent intent = new Intent(Intent.ACTION_VIEW);
//                                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + uri + "&text=" + hello));
//                                mContext.startActivity(intent);
//                            }
//                        })
//                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        })
//                        .setCancelable(false)
//                        .create()
//                        .show();
//
//            }
//        });
//
//    }

    @Override
    public int getItemCount() {
        return mItemKuliner.size();
    }

//    @Override
//    public void onViewRecycled(@NonNull final FoodViewHolder foodViewHolder) {
//        mGlide.clear(foodViewHolder.itemView);
//    }


}
