package com.example.sqlliteexam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlliteexam.R;
import com.example.sqlliteexam.database.DatabaseHelperClass;
import com.example.sqlliteexam.models.PlantesModelClass;

public class MainActivity extends AppCompatActivity  {

    EditText editText_name, editText_description, editText_price , editText_quatity ;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.edittext_name);
        editText_description = findViewById(R.id.edittext_description);
        editText_price = findViewById(R.id.edittext_price);
        editText_quatity = findViewById(R.id.edittext_quantity);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);

        button_add.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringDescription = editText_description.getText().toString();
                String stringPrice = editText_price.getText().toString();
                String stringQuatity = editText_quatity.getText().toString();

                if (stringName.length() <=0 || stringDescription.length() <=0){
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    PlantesModelClass plantesModelClass = new PlantesModelClass(stringName,stringDescription, stringPrice, stringQuatity);
                    databaseHelperClass.addPlante(plantesModelClass);
                    Toast.makeText(MainActivity.this, "Add plante Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPlanteActivity.class);
                startActivity(intent);
            }
        });
    }

}