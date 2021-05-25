package xyz.johannainggolan.webhozz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import xyz.johannainggolan.webhozz.Adapter.RvKendaraanAdapter;
import xyz.johannainggolan.webhozz.Model.KendaraanModel;

public class KendaraanActivity extends AppCompatActivity {

    RecyclerView rvKendaraan = null;

    List<KendaraanModel> listKdr = new ArrayList<>();
    RvKendaraanAdapter rvKdrAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kendaraan);
        initView();
    }

    private void initView(){
        rvKendaraan = findViewById(R.id.rv_kendaraan);
        rvKdrAdapter = new RvKendaraanAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvKendaraan.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillData();
    }

    private void fillData(){
        listKdr.clear();
        for(int i=0; i<10;i++){
            listKdr.add(new KendaraanModel("", i+"888"+"GD",R.mipmap.ic_launcher));
        }

        if(listKdr!=null){
            rvKdrAdapter.setListKendaraan(listKdr);
            rvKendaraan.setAdapter(rvKdrAdapter);
        }
    }
}