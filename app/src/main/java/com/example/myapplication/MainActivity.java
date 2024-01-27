package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SELECT_STATION = 1;

    private TextView selectedStationTextView;
    private TextView stationLabel;
    private Button selectStationButton;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String action = getIntent().getAction();
        Toast.makeText(this, "Action: " + action, Toast.LENGTH_SHORT).show();

        stationLabel = findViewById(R.id.text_view_station_label);
        selectStationButton = findViewById(R.id.button_select_station);
        selectedStationTextView = findViewById(R.id.selected_station_text_view);

        selectStationButton.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.metropicker.intent.action.PICK_METRO_STATION");
            startActivityForResult(intent, REQUEST_CODE_SELECT_STATION);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SELECT_STATION && resultCode == RESULT_OK) {
            String selectedStation = data.getStringExtra("selectedStation");
            if (selectedStation != null) {
                selectedStationTextView.setText(selectedStation);
                return;
            }
        }

        selectedStationTextView.setText(R.string.no_station_selected);
    }
}