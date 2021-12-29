package com.example.sqlliteexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sqlliteexam.adapters.EmployeeAdapterClass;
import com.example.sqlliteexam.database.DatabaseHelperClass;
import com.example.sqlliteexam.models.EmployeeModelClass;

import java.util.List;

public class ViewEmployeeActivity extends AppCompatActivity implements SelectItemListener {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<EmployeeModelClass> employeeModelClasses = databaseHelperClass.getEmployeeList();

        if (employeeModelClasses.size() > 0){
            EmployeeAdapterClass employeadapterclass = new EmployeeAdapterClass(employeeModelClasses,ViewEmployeeActivity.this, this::onItemClicked);
            recyclerView.setAdapter(employeadapterclass);
        }else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemClicked(EmployeeModelClass myModel) {
        Toast.makeText(ViewEmployeeActivity.this, "11"+ myModel.getName(), Toast.LENGTH_LONG).show();
    }
}