package br.edu.ifsc.lydiagarcia.listafrutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FrutaAdapterRecyclerView extends RecyclerView.Adapter<FrutaAdapterRecyclerView.MyViewHolder> {

    Context mContext;
    int mResource;
    Fruta[] mDataSet;

    public FrutaAdapterRecyclerView(Context mContext, int mResource, Fruta[] mDataSet) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(convertView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Fruta fruta = mDataSet[position];

        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

        // Populando sa views do layout inflado
        holder.tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        holder.tvNome.setText(fruta.getNome());
        holder.tvPreco.setText(decimalFormat.format(fruta.getPreco()));
        holder.tvPrecoVenda.setText(decimalFormat.format(fruta.getPreco_venda()));
        holder.img.setImageResource(fruta.getImagem());

    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvCodigo, tvNome, tvPreco, tvPrecoVenda;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // Associando objetos da interface a identificadores locais
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvPreco = itemView.findViewById(R.id.tvPreco);
            tvPrecoVenda = itemView.findViewById(R.id.tvPrecoVenda);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
