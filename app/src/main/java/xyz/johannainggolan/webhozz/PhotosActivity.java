package xyz.johannainggolan.webhozz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.net.NetworkInterface;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.johannainggolan.webhozz.Adapter.RvKendaraanAdapter;
import xyz.johannainggolan.webhozz.Adapter.RvPhotosAdapter;
import xyz.johannainggolan.webhozz.Model.PhotosModel;
import xyz.johannainggolan.webhozz.Networking.NetworkClient;
import xyz.johannainggolan.webhozz.Networking.NetworkingInterface;

public class PhotosActivity extends AppCompatActivity {

    RecyclerView rvPhotos=null;
    RvPhotosAdapter rvPhotosAdapter = null;
    NetworkingInterface networkService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        initView();
    }

    private void initView(){
        rvPhotosAdapter = new RvPhotosAdapter(); // constructor
        networkService = NetworkClient.getClient().create(NetworkingInterface.class); // constructor
        rvPhotos = findViewById(R.id.rv_photos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvPhotos.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Call<List<PhotosModel>> caller = networkService.getPhotosFromServer(); //ini jadi pintu masuk data di server
        caller.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {
                if(response.code()==200){
                    //ini pasti sudah ada datanya
                   /* PhotosModel photosModel=null;
                    if(response.body().size()>0){
                        for(int i=0 ; i<response.body().size();i++){
                            photosModel= response.body().get(i);
                            Log.d("trace-response", photosModel.getTitle());
                        }
                    }*/

                    if(response.body().size()>0){
                        rvPhotosAdapter.setListPhoto(response.body());
                    }
                    else{
                        rvPhotosAdapter.setListPhoto(null);
                    }
                }
                else{
                    //set error atau notfound
                    Log.d("trace-response", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {
                Log.d("trace-response", String.valueOf(t.getMessage()));
            }
        });

        rvPhotos.setAdapter(rvPhotosAdapter);
        rvPhotosAdapter.notifyDataSetChanged();
    }
}