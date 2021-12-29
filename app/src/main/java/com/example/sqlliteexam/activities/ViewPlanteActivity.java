package com.example.sqlliteexam.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sqlliteexam.R;
import com.example.sqlliteexam.SelectItemListener;
import com.example.sqlliteexam.adapters.PlantesAdapterClass;
import com.example.sqlliteexam.database.DatabaseHelperClass;
import com.example.sqlliteexam.models.PlantesModelClass;

import java.util.List;

public class ViewPlanteActivity extends AppCompatActivity implements SelectItemListener {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plante);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<PlantesModelClass> plantesModelClasses = databaseHelperClass.getPlanteList();

        if (plantesModelClasses.size() > 0){
            PlantesAdapterClass employeadapterclass = new PlantesAdapterClass(plantesModelClasses, ViewPlanteActivity.this, this::onItemClicked);
            recyclerView.setAdapter(employeadapterclass);
        }else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemClicked(PlantesModelClass myModel) {
        Toast.makeText(ViewPlanteActivity.this, "11"+ myModel.getName(), Toast.LENGTH_LONG).show();
    }
}