package br.edu.ifsc.lydiagarcia.listafrutas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

public class ExibeFruta extends AppCompatActivity {

    TextView textViewCodigo, textViewNome, textViewPreco, textViewPrecoVenda, textViewNumAvaliacoes, textViewAvaliacoes, textViewDescricao;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_fruta);

        int id = getIntent().getExtras().getInt("id");

        textViewCodigo = findViewById(R.id.textViewCodigo);
        textViewNome = findViewById(R.id.textViewNome);
        textViewPreco = findViewById(R.id.textViewPreco);
        textViewPrecoVenda = findViewById(R.id.textViewPrecoVenda);
        textViewNumAvaliacoes = findViewById(R.id.textViewNumAvaliacoes);
        textViewAvaliacoes = findViewById(R.id.textViewAvaliacoes);
        textViewDescricao = findViewById(R.id.textViewDescricao);
        imageView = findViewById(R.id.imageView);

        FrutaController frutaController = new FrutaController();

        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        textViewCodigo.setText(Integer.toString(frutaController.FRUTAS[id].getCodigo()));
        textViewNome.setText(frutaController.FRUTAS[id].getNome());
        textViewPreco.setText(decimalFormat.format(frutaController.FRUTAS[id].getPreco()));
        textViewPrecoVenda.setText(decimalFormat.format(frutaController.FRUTAS[id].getPreco_venda()));
        textViewNumAvaliacoes.setText(Integer.toString(frutaController.FRUTAS[id].getNum_avaliacoes()));
        textViewAvaliacoes.setText(decimalFormat.format(frutaController.FRUTAS[id].getAvaliacoes()));
        textViewDescricao.setText(frutaController.FRUTAS[id].getDescricao());
        imageView.setImageResource(frutaController.FRUTAS[id].getImagem());
    }
}