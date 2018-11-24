package co.example.lutfillahmafazi.doaharian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class chooseActivity extends AppCompatActivity {


    @BindView(R.id.btnDoaTidur)
    Button btnDoaTidur;
    @BindView(R.id.btnDoaKamarMandi)
    Button btnDoaKamarMandi;
    @BindView(R.id.btnDoaMakan)
    Button btnDoaMakan;
    @BindView(R.id.btnDoaMasjid)
    Button btnDoaMasjid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnDoaTidur, R.id.btnDoaKamarMandi, R.id.btnDoaMakan, R.id.btnDoaMasjid})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnDoaTidur:
                intent = new Intent(this, RecycleActivity.class);
                intent.putExtra("doa","tidur");
                startActivity(intent);
                break;
            case R.id.btnDoaKamarMandi:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("doa","wc");
                startActivity(intent);
                break;
            case R.id.btnDoaMakan:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("doa","makan");
                startActivity(intent);
                break;
            case R.id.btnDoaMasjid:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("doa","masjid");
                startActivity(intent);
                break;
        }
    }
}

