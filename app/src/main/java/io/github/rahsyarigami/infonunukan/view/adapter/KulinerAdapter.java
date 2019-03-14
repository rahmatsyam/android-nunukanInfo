package io.github.rahsyarigami.infonunukan.view.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.model.ItemKuliner;

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.KulinerViewHolder> {

    private Context mContext;
    private List<ItemKuliner> mItemKuliner;
    private RequestManager mGlide;

    public KulinerAdapter(List<ItemKuliner> getItemKuliner, RequestManager glide) {
        // mContext = context;
        mGlide = glide;
        mItemKuliner = getItemKuliner;

    }


    @NonNull
    @Override
    public KulinerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //View view = LayoutInflater.from(mContext).inflate(R.layout.item_kuliner_delivery, viewGroup, false);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kuliner_delivery, viewGroup, false);
        mContext = viewGroup.getContext();
        return new KulinerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final KulinerViewHolder kulinerHolder, int position) {
        final ItemKuliner getItemKuliner = mItemKuliner.get(position);
        kulinerHolder.tvNamaUsahaKuliner.setText(getItemKuliner.getItemProfilKuliner());
        kulinerHolder.tvKontakKuliner.setText(getItemKuliner.getItemContactKuliner());
        kulinerHolder.tvDeskripsiKuliner.setText(getItemKuliner.getItemDescriptionKuliner());
        mGlide.load(getItemKuliner.getItemIconKuliner()).into(kulinerHolder.ivIconProfilKuliner);

        //Glide.with(mContext).load(getItemKuliner.getItemIconKuliner()).into(kulinerHolder.ivIconProfilKuliner).clearOnDetach();
        kulinerHolder.ibWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*try {

                } catch (Exception e){

                }*/

                final String nameContact = kulinerHolder.tvNamaUsahaKuliner.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Apakah Anda ingin chat " + nameContact + " untuk menanyakan ketersediaan kuliner?")

                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                final String codeCountry = "+62";
                                String numberPhone = kulinerHolder.tvKontakKuliner.getText().toString();
                                String hello = "Hello";
                                Uri uri = Uri.parse("smsto:" + codeCountry + numberPhone.substring(1));
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + uri + "&text=" + hello));
                                mContext.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemKuliner.size();
    }

    class KulinerViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ivIconProfilKuliner;
        TextView tvNamaUsahaKuliner;
        TextView tvKontakKuliner;
        TextView tvDeskripsiKuliner;
        ImageButton ibWhatsapp;

        KulinerViewHolder(View view) {
            super(view);
            ivIconProfilKuliner = view.findViewById(R.id.img_profil_kuliner);
            tvNamaUsahaKuliner = view.findViewById(R.id.tv_nama_usaha);
            tvKontakKuliner = view.findViewById(R.id.tv_kontak_kuliner);
            tvDeskripsiKuliner = view.findViewById(R.id.tv_deskripsi_kuliner);
            ibWhatsapp = view.findViewById(R.id.btn_wa);
        }


    }

    @Override
    public void onViewRecycled(@NonNull final KulinerViewHolder kulinerViewHolder) {
        mGlide.clear(kulinerViewHolder.ivIconProfilKuliner);
    }


}
