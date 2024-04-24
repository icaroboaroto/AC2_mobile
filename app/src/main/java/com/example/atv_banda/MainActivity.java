package com.example.atv_banda;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atv_banda.adapter.AlbumAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumAdapter adapter;
    private List<Album> albumList;
    private boolean isHorizontal = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = recyclerView.findViewById(R.id.recyclerView);
        albumList = new ArrayList<>();
        // Adicione seus álbuns aqui ou recupere-os de um banco de dados
        albumList.add(new Album("Lagum", 2023, "Mais informações sobre banda 1", "Fotógrafo 1", R.mipmap.ic_launcher));
        albumList.add(new Album("AC/DC", 1979, "Mais informações sobre banda 2", "Fotógrafo 2", R.mipmap.ic_launcher));
        albumList.add(new Album("Paramore", 2009, "Mais informações sobre banda 3", "Fotógrafo 3", R.mipmap.ic_launcher));

        adapter = new AlbumAdapter(this, albumList) {
            @Override
            protected void onCreate(Bundle savedInstanceState) {

            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Button changeLayoutButton = findViewById(R.id.changeLayoutButton);
        changeLayoutButton.setOnClickListener(v -> {
            if (isHorizontal) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                isHorizontal = false;
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                isHorizontal = true;
            }
        });
    }


}