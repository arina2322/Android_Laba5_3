package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StationsListActivity extends AppCompatActivity {

    private ListView stationListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_list);

        stationListView = findViewById(R.id.list_view_stations);

        String action = getIntent().getAction();
        Toast.makeText(this, "Action: " + action, Toast.LENGTH_SHORT).show();

        populateStationList();

        stationListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedStation = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent();
            intent.putExtra("selectedStation", selectedStation);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void populateStationList() {
        String[] stations = getStations();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stations);
        stationListView.setAdapter(adapter);
    }

    @NonNull
    private String[] getStations() {
        return new String[]{
                "Автозаводская",
                "Грушевская",
                "Институт культуры",
                "Каменная Горка",
                "Кунцевщина",
                "Малиновка",
                "Могилевская",
                "Молодежная",
                "Немига",
                "Петровщина",
                "Площадь Якуба Коласа",
                "Спортивная",
                "Уручье",
                "Черная речка",
                "Юбилейная",
                "Якуба Коласа"
        };
    }
}