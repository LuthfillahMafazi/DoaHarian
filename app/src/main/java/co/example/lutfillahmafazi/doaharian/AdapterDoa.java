package co.example.lutfillahmafazi.doaharian;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterDoa extends RecyclerView.Adapter<AdapterDoa.ViewHolder> {

    Context context;
    String[] namaDoa, arabDoa, detailDoa;
    int [] gambarDoa;

    public AdapterDoa(Context context, String[] namaDoa, String[] arabDoa, String[] detailDoa, int[] gambarDoa) {
        this.context = context;
        this.namaDoa = namaDoa;
        this.arabDoa = arabDoa;
        this.detailDoa = detailDoa;
        this.gambarDoa = gambarDoa;
    }

    @NonNull

    @Override
    public AdapterDoa.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_doa,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDoa.ViewHolder viewHolder, final int i) {
        viewHolder.txtDoa.setText(namaDoa[i]);
        Glide.with(context).load(gambarDoa[i]).into(viewHolder.imgDoa);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailDoa.class);
                intent.putExtra("arab",arabDoa[i]);
                intent.putExtra("nd",namaDoa[i]);
                intent.putExtra("dd",detailDoa[i]);
                intent.putExtra("gd",gambarDoa[i]);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarDoa.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDoa;
        ImageView imgDoa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDoa = itemView.findViewById(R.id.txtDoa);
            imgDoa = itemView.findViewById(R.id.imgDoa);
        }
    }
}
