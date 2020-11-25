package io.github.rahsyarigami.infonunukan.ui.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.rahsyarigami.infonunukan.R;
import io.github.rahsyarigami.infonunukan.data.model.ItemKontak;


public class KontakPentingAdapter extends RecyclerView.Adapter<KontakPentingAdapter.KontakViewHolder> {

    private final Context mContext;
    private final List<ItemKontak> mItemKontak;
    // private static final int PERMISSION_REQUEST_CODE = 200;


    public KontakPentingAdapter(List<ItemKontak> getItemKontak, Context context) {
        mContext = context;
        mItemKontak = getItemKontak;
    }


    @NonNull
    @Override
    public KontakViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_kontak_penting, viewGroup, false);
        return new KontakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final KontakViewHolder kontakHolder, int position) {
        final ItemKontak getItemKontak = mItemKontak.get(position);
        kontakHolder.tvKontak.setText(getItemKontak.getItemContact());
        kontakHolder.tvAlamat.setText(getItemKontak.getItemAddress());
        kontakHolder.tvTelepon.setText(getItemKontak.getItemPhone());

        kontakHolder.ibCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String contactName = kontakHolder.tvKontak.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Apakah Anda ingin menghubungi " + contactName + "?")

                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String numberPhone = kontakHolder.tvTelepon.getText().toString();
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:" + numberPhone));
                                // intent.setDataAndType(Uri.parse("tel:"+numberPhone), ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                                mContext.startActivity(intent);
                                // mContext.startActivity(intent.resolveActivity());
                                   /* Intent intent = new Intent(Intent.ACTION_CALL);
                                    intent.setData(Uri.parse("tel:" + numberPhone));
                                    if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                        checkPermission();
                                    }
                                    mContext.startActivity(intent);*/
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


              /*  if (checkPermission()) {


                } else {
                    requestPermission();
                }*/


            }
        });


        kontakHolder.ibCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String text = kontakHolder.tvTelepon.getText().toString();
                String label = "";
                ClipboardManager clipboardManager = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText(label, text);
                assert clipboardManager != null;
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(mContext, "Nomor kontak berhasil disalin", Toast.LENGTH_SHORT).show();
            }
        });


    }


    class KontakViewHolder extends RecyclerView.ViewHolder {

        TextView tvKontak;
        TextView tvAlamat;
        TextView tvTelepon;
        ImageButton ibCopy;
        ImageButton ibCall;

        KontakViewHolder(View view) {
            super(view);
            tvKontak = view.findViewById(R.id.tv_nama_kontak);
            tvAlamat = view.findViewById(R.id.tv_alamat);
            tvTelepon = view.findViewById(R.id.tv_telepon);
            ibCopy = view.findViewById(R.id.btn_copy);
            ibCall = view.findViewById(R.id.btn_call);

        }


    }

    @Override
    public int getItemCount() {
        return mItemKontak.size();
    }

   /* private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(mContext, CALL_PHONE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions((Activity) mContext, new String[]{CALL_PHONE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean phoneAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (phoneAccepted) {
                        Toast.makeText(mContext, "Permissions Granted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "Permissions Not Granted", Toast.LENGTH_SHORT).show();
                    }


                }

                break;
        }
    }*/


}
