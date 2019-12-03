package br.edu.ifsc.lydiagarcia.listafrutas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class ListagemFrutasRecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FrutaController frutaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_fruta_recycler_view);

        FrutaController frutaController = new FrutaController();

        recyclerView = findViewById(R.id.recylerView);

        // Config RecyclerView
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FrutaAdapterRecyclerView adapter = new FrutaAdapterRecyclerView(
                getApplicationContext(),
                R.layout.template_item_fruta,
                frutaController.FRUTAS
        );

        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { }

                    @Override
                    public void onItemClick(View view, int i) {
                        Intent intent = new Intent(getApplicationContext(), ExibeFruta.class);
                        intent.putExtra("id", i);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) { }
                }
        ));

    }

}
