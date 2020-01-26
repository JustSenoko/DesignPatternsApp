package com.blueroofstudio.plantcareapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.blueroofstudio.plantcareapp.R;
import com.blueroofstudio.plantcareapp.database.DBHelper;
import com.blueroofstudio.plantcareapp.database.DBHelperImpl;
import com.blueroofstudio.plantcareapp.plant.Plant;
import com.blueroofstudio.plantcareapp.plant.PlantModel;
import com.blueroofstudio.plantcareapp.plant.PlantPresenter;
import com.google.android.material.textfield.TextInputEditText;

public class NewPlantActivity extends AppCompatActivity {

    private TextInputEditText etName;
    private TextInputEditText etDays;

    private PlantPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plant);
        init();
    }

    private void init() {

        etName = findViewById(R.id.plant_name);
        etDays = findViewById(R.id.plant_days_between_watering);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.add();
                finish();
            }
        });

        DBHelper dbHelper = new DBHelperImpl();
        PlantModel model = new PlantModel(dbHelper);
        presenter = new PlantPresenter(model);
        presenter.attachView(this);
        presenter.loadPlants();
    }

    public void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public Plant getPlantData() {
        Plant plant = new Plant(0, etName.getText().toString());
        plant.setDaysBetweenWatering(Integer.valueOf(etDays.getText().toString()));
        return plant;
    }
}
