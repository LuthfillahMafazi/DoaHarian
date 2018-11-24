package co.example.lutfillahmafazi.doaharian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    String[] doaTidur,arabTidur,detailTidur,doaWC,arabWC,detailWc,doaMakan,arabMakan,detailMakan
            ,doaMasjid,arabMasjid,detailMasjid;
    int[] gambarTidur,gambarWC,gambarMakan,gambarMasjid;

    AdapterDoa adapterDoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        doaTidur = getResources().getStringArray(R.array.doa_tidur);
        arabTidur = getResources().getStringArray(R.array.arab_tidur);
        detailTidur = getResources().getStringArray(R.array.detail_tidur);
        gambarTidur = new int[]{R.drawable.sleep,R.drawable.sleep};
        doaWC = getResources().getStringArray(R.array.doa_wc);
        arabWC = getResources().getStringArray(R.array.arab_wc);
        detailWc = getResources().getStringArray(R.array.detail_wc);
        gambarWC = new int[]{R.drawable.bathroom,R.drawable.bathroom};
        doaMakan = getResources().getStringArray(R.array.doa_makan);
        arabMakan = getResources().getStringArray(R.array.arab_makan);
        detailMakan = getResources().getStringArray(R.array.detail_makan);
        gambarMakan = new int[] {R.drawable.eat,R.drawable.eat};
        doaMasjid = getResources().getStringArray(R.array.doa_masjid);
        arabMasjid = getResources().getStringArray(R.array.arab_masjid);
        detailMasjid = getResources().getStringArray(R.array.detail_masjid);
        gambarMasjid = new int[]{R.drawable.mosque,R.drawable.mosque};

        String doa = getIntent().getStringExtra("doa");
        Log.i("isi doa",doa);

        if (doa.equals("tidur")){
            adapterDoa = new AdapterDoa(RecycleActivity.this,doaTidur,arabTidur,detailTidur,gambarTidur);
        }else if (doa.equals("wc")){
            adapterDoa = new AdapterDoa(RecycleActivity.this,doaWC,arabWC,detailWc,gambarWC);
        }else if (doa.equals("makan")){
            adapterDoa = new AdapterDoa(RecycleActivity.this,doaMakan,arabMakan,detailMakan,gambarMakan);
        }else {
            adapterDoa = new AdapterDoa(RecycleActivity.this,doaMasjid,arabMasjid,detailMasjid,gambarMasjid);
        }

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapterDoa);


    }
}
