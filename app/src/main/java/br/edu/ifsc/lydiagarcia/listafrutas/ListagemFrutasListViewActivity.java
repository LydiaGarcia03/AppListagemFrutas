package br.edu.ifsc.lydiagarcia.listafrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListagemFrutasListViewActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_fruta_list_view);

        listView=findViewById(R.id.listView);

        FrutaController frutaController = new FrutaController();

        FrutaAdapterListView adapter = new FrutaAdapterListView(
                getApplicationContext(),
                R.layout.template_item_fruta,
                frutaController.FRUTAS
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), ExibeFruta.class);
                intent.putExtra("id", i);
                startActivity(intent);

            }
        });

    }
}
