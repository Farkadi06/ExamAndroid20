package com.example.sqlliteexam.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.sqlliteexam.models.PlantesModelClass;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {


    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "plantes_database";
    //Database Table name
    private static final String TABLE_NAME = "PLANTES";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String QUATITY = "quatity";
    public static SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+ DESCRIPTION +" TEXT NOT NULL,"+PRICE + " TEXT NOT NULL,"+ QUATITY +" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelperClass (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Plante Data
    public void addPlante(PlantesModelClass plantesModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, plantesModelClass.getName());
        contentValues.put(DatabaseHelperClass.DESCRIPTION, plantesModelClass.getDescription());
        contentValues.put(DatabaseHelperClass.PRICE, plantesModelClass.getPrice());
        contentValues.put(DatabaseHelperClass.QUATITY, plantesModelClass.getQuatity());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
    }

    public List<PlantesModelClass> getPlanteList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<PlantesModelClass> storePlante = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String price = cursor.getString(3);
                String quatity = cursor.getString(4);
                storePlante.add(new PlantesModelClass(id,name,description,price,quatity));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storePlante;
    }

    public void updatePlante(PlantesModelClass plantesModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, plantesModelClass.getName());
        contentValues.put(DatabaseHelperClass.DESCRIPTION, plantesModelClass.getDescription());
        contentValues.put(DatabaseHelperClass.PRICE, plantesModelClass.getPrice());
        contentValues.put(DatabaseHelperClass.QUATITY, plantesModelClass.getQuatity());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(plantesModelClass.getId())});
    }

     public void deletePlante(String id){
        System.out.println("µµµµµµµµµµµµµµµµµµµµµµ** :  "+ id);
         SQLiteDatabase db = this.getWritableDatabase();
         db.delete(TABLE_NAME, ID + " = ? ", new String[]
                {id});
    }
}
