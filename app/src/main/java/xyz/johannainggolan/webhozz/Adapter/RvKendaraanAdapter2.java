package xyz.johannainggolan.webhozz.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import xyz.johannainggolan.webhozz.R;

public class RvKendaraanAdapter2 extends RecyclerView.Adapter<RvKendaraanAdapter.KendaraanViewHolder> {


    @NonNull
    @Override
    public RvKendaraanAdapter.KendaraanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
        //KendaraanViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull RvKendaraanAdapter.KendaraanViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class KendaraanViewHolder extends RecyclerView.ViewHolder{
        /*
        * Ini block kelas untuk inisialisasi dari item view kendaraan
        * */
        AppCompatTextView tvName, tvNumberPlate = null;
        AppCompatImageView ivPhoto =null;

        public KendaraanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_kendaraan_name);
            tvNumberPlate = itemView.findViewById(R.id.item_kendaraan_number);
            ivPhoto = itemView.findViewById(R.id.item_kendaraan_image);
        }
    }
}
