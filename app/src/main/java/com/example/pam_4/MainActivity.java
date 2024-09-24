package com.example.pam_4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText inputNama, inputNIM;
    private Button btnTambah;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ArrayList<ItemData> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNama = findViewById(R.id.InputNama);
        inputNIM = findViewById(R.id.InputNIM);
        btnTambah = findViewById(R.id.BtnTambah);
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize data list and adapter
        dataList = new ArrayList<>();
        adapter = new MainAdapter(dataList);

        // Setup RecyclerView with adapter and layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Set up button click listener
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = inputNama.getText().toString();
                String nim = inputNIM.getText().toString();

                if (!nama.isEmpty() && !nim.isEmpty()) {
                    // Add new data to the list
                    dataList.add(new ItemData(nama, nim));

                    // Notify adapter of data change
                    adapter.notifyItemInserted(dataList.size() - 1);

                    // Clear input fields
                    inputNama.setText("");
                    inputNIM.setText("");
                }
            }
        });
    }
}