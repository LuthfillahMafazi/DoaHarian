package co.example.lutfillahmafazi.doaharian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailDoa extends AppCompatActivity {

    @BindView(R.id.imgDoa1)
    ImageView imgDoa1;
    @BindView(R.id.txtNamaDoa)
    TextView txtNamaDoa;
    @BindView(R.id.txtDetailDoa)
    TextView txtDetailDoa;
    @BindView(R.id.txtdetailArab)
    TextView txtdetailArab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_doa);
        ButterKnife.bind(this);

        txtdetailArab.setText(getIntent().getStringExtra("arab"));
        txtNamaDoa.setText(getIntent().getStringExtra("nd"));
        txtDetailDoa.setText(getIntent().getStringExtra("dd"));
        Glide.with(this).load(getIntent().getIntExtra("gd", 0)).into(imgDoa1);
    }
}
