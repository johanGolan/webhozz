package xyz.johannainggolan.webhozz.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.johannainggolan.webhozz.HomeActivity;
import xyz.johannainggolan.webhozz.Model.KendaraanModel;
import xyz.johannainggolan.webhozz.Model.PhotosModel;
import xyz.johannainggolan.webhozz.R;
import xyz.johannainggolan.webhozz.Utilities.KeyUtil;
import xyz.johannainggolan.webhozz.Utilities.ValueUtil;

public class RvPhotosAdapter extends RecyclerView.Adapter<RvPhotosAdapter.PhotosViewHolder> {

    List<PhotosModel> listPhotos = null;

    public void setListPhoto(List<PhotosModel> listPhotos){
        this.listPhotos = listPhotos;
    }

    @NonNull
    @Override
    public RvPhotosAdapter.PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photos,parent,false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvPhotosAdapter.PhotosViewHolder holder, int position) {
        PhotosModel photosModel = listPhotos.get(position);//postio
        holder.tvTitle.setText(ValueUtil.showValueifNull(photosModel.getTitle()));
        holder.tvUrl.setText(ValueUtil.showValueifNull(photosModel.getUrl()));
        ValueUtil.setImageFromUrl(
                holder.itemView.getContext(),
                photosModel.getThumbnailUrl(),
                holder.ivItemPhoto);

        holder.clRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClick(v,photosModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPhotos == null ? 0: listPhotos.size();
    }

    class PhotosViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout clRoot=null;
        AppCompatTextView tvTitle, tvUrl = null;
        AppCompatImageView ivItemPhoto =null;

        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            clRoot = itemView.findViewById(R.id.clPhotos);
            tvTitle = itemView.findViewById(R.id.item_photo_title);
            tvUrl = itemView.findViewById(R.id.item_photo_url);
            ivItemPhoto = itemView.findViewById(R.id.item_photo_image);
        }
    }
                            //Object //variable    //Object //variable
    private void handleOnClick(View view, PhotosModel photosModel){
        if(view!=null){
            ValueUtil.shoutMessage(view.getContext(),photosModel.getTitle());

             Intent goToHome = new Intent(view.getContext(), HomeActivity.class);
            goToHome.putExtra(KeyUtil.SAVED_EMAIL, photosModel.getTitle());
            goToHome.putExtra(KeyUtil.SAVED_PASSWORD, photosModel.getUrl());
            view.getContext().startActivity(goToHome);
        }
    }
}
