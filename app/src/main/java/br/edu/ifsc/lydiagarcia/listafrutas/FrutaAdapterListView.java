package br.edu.ifsc.lydiagarcia.listafrutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class FrutaAdapterListView extends ArrayAdapter<Fruta> {

    Context mContext;
    int mResource;
    Fruta[] arrayFruta;

    public FrutaAdapterListView(@NonNull Context context, int resource, @NonNull Fruta[] objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource;
        arrayFruta = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        // Associando objetos da interface a identificadores locais
        TextView tvCodigo = convertView.findViewById(R.id.tvCodigo);
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        TextView tvPreco = convertView.findViewById(R.id.tvPreco);
        TextView tvPrecoVenda = convertView.findViewById(R.id.tvPrecoVenda);
        ImageView img = convertView.findViewById(R.id.imageView);

        // Recuperando um objeto do data set na posição 'position'
        Fruta fruta = getItem(position);

        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

        // Populando sa views do layout inflado
        tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        tvPreco.setText(decimalFormat.format(fruta.getPreco()));
        tvPrecoVenda.setText(decimalFormat.format(fruta.getPreco_venda()));
        img.setImageResource(fruta.getImagem());

        return convertView;

    }
}
