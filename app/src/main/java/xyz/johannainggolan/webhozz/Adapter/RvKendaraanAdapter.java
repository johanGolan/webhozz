package xyz.johannainggolan.webhozz.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.johannainggolan.webhozz.HomeActivity;
import xyz.johannainggolan.webhozz.Model.KendaraanModel;
import xyz.johannainggolan.webhozz.R;
import xyz.johannainggolan.webhozz.Utilities.KeyUtil;
import xyz.johannainggolan.webhozz.Utilities.ValueUtil;

public class RvKendaraanAdapter extends RecyclerView.Adapter<RvKendaraanAdapter.KendaraanViewHolder> {

    List<KendaraanModel> kdrModel= null;

    public void setListKendaraan(List<KendaraanModel> kdrModel){
        this.kdrModel = kdrModel;
    }

    @NonNull
    @Override
    public RvKendaraanAdapter.KendaraanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_kendaraan,parent,false);
        return new KendaraanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvKendaraanAdapter.KendaraanViewHolder holder, int position) {

        KendaraanModel kendaraanModel = kdrModel.get(position);
        holder.tvItemName.setText(ValueUtil.showValueifNull(kendaraanModel.getName()));
        holder.tvItemNumberPlate.setText(ValueUtil.showValueifNull(kendaraanModel.getNumberPlate()));

        holder.clRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fungsinya untuk nampilin message
                handleOnClick(v,kendaraanModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kdrModel == null ? 0: kdrModel.size();
    }

    class KendaraanViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout clRoot=null;
        AppCompatTextView tvItemName, tvItemNumberPlate = null;
        AppCompatImageView ivItemPhoto =null;

        public KendaraanViewHolder(@NonNull View itemView) {
            super(itemView);
            clRoot = itemView.findViewById(R.id.clKendaraan);
            tvItemName = itemView.findViewById(R.id.item_kendaraan_name);
            tvItemNumberPlate = itemView.findViewById(R.id.item_kendaraan_number);
            ivItemPhoto = itemView.findViewById(R.id.item_kendaraan_image);
        }
    }
                            //Object //variable    //Object //variable
    private void handleOnClick(View view, KendaraanModel kendaraanModel){
        if(view!=null){
            ValueUtil.shoutMessage(view.getContext(),kendaraanModel.getNumberPlate());

            Intent goToHome = new Intent(view.getContext(), HomeActivity.class);
            goToHome.putExtra(KeyUtil.SAVED_EMAIL, kendaraanModel.getName());
            goToHome.putExtra(KeyUtil.SAVED_PASSWORD, kendaraanModel.getNumberPlate());
            view.getContext().startActivity(goToHome);
        }
    }
}
