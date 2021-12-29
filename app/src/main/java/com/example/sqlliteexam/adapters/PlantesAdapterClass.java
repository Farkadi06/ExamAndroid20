package com.example.sqlliteexam.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlliteexam.R;
import com.example.sqlliteexam.SelectItemListener;
import com.example.sqlliteexam.activities.MainActivity;
import com.example.sqlliteexam.database.DatabaseHelperClass;
import com.example.sqlliteexam.models.PlantesModelClass;

import java.util.List;

public class PlantesAdapterClass extends RecyclerView.Adapter<PlantesAdapterClass.ViewHolder> {

    List<PlantesModelClass> plante;
    Context context;
    DatabaseHelperClass databaseHelperClass;
    private SelectItemListener mListener;

    public PlantesAdapterClass(List<PlantesModelClass> plante, Context context, SelectItemListener listener) {
        this.plante = plante;
        this.context = context;
        this.mListener = listener;
    }

    public PlantesAdapterClass(List<PlantesModelClass> plante, Context context) {
        this.plante = plante;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.plante_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final PlantesModelClass plantesModelClass = plante.get(position);


        holder.textViewID.setText(Integer.toString(plantesModelClass.getId()));
        holder.editText_Name.setText(plantesModelClass.getName());
        holder.editText_description.setText(plantesModelClass.getDescription());
        holder.editText_price.setText(plantesModelClass.getPrice());
        holder.editText_quatity.setText(plantesModelClass.getQuatity());


        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClicked(plantesModelClass);
            }
        });


        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringDescription = holder.editText_description.getText().toString();
                String stringPrice = holder.editText_price.getText().toString();
                String stringQuatity = holder.editText_quatity.getText().toString();
                databaseHelperClass = new DatabaseHelperClass(context);
                databaseHelperClass.updatePlante(new PlantesModelClass(plantesModelClass.getId(),stringName,stringDescription,stringPrice,stringQuatity));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("=========>   "+plantesModelClass.getId());
                databaseHelperClass = new DatabaseHelperClass(context);
                databaseHelperClass.deletePlante(plantesModelClass.getId().toString());
                plante.remove(position);
                notifyDataSetChanged();
            }
        });




    }

    @Override
    public int getItemCount() {
        return plante.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_description;
        EditText editText_price , editText_quatity ;
        Button button_Edit;
        Button button_delete;
        LinearLayout item;
        Button show;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_description = itemView.findViewById(R.id.edittext_description);
            editText_price = itemView.findViewById(R.id.edittext_price2);
            editText_quatity = itemView.findViewById(R.id.edittext_quantity2);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);
            item = itemView.findViewById(R.id.singleItem);
            show = itemView.findViewById(R.id.button_show);

        }
    }
}