package com.example.found;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LostFound.db";
    private static final int DATABASE_VERSION = 2; // Incremented version to trigger onUpgrade

    private static final String TABLE_NAME = "lost_items";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "item_name TEXT," +
                "location TEXT," +
                "description TEXT," +
                "contact TEXT," +
                "item_type TEXT" +
                ")";
        db.execSQL(createTable);
    }

    // Called when database version is incremented
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop old table if exists, then create a new one with updated schema
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert a lost or found item
    public boolean insertLostItem(String name, String location, String desc, String contact, String itemType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("item_name", name);
        cv.put("location", location);
        cv.put("description", desc);
        cv.put("contact", contact);
        cv.put("item_type", itemType);

        long result = db.insert(TABLE_NAME, null, cv);
        return result != -1;
    }

    // Get all lost and found items
    public List<LostItem> getAllItems() {
        List<LostItem> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY id DESC", null);
        if (cursor.moveToFirst()) {
            do {
                LostItem item = new LostItem(
                        cursor.getString(cursor.getColumnIndexOrThrow("item_name")),
                        cursor.getString(cursor.getColumnIndexOrThrow("location")),
                        cursor.getString(cursor.getColumnIndexOrThrow("description")),
                        cursor.getString(cursor.getColumnIndexOrThrow("contact")),
                        cursor.getString(cursor.getColumnIndexOrThrow("item_type"))
                );
                itemList.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return itemList;
    }

    // Get items filtered by type: "Lost" or "Found"
    public List<LostItem> getItemsByType(String type) {
        List<LostItem> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE item_type = ? ORDER BY id DESC",
                new String[]{type});
        if (cursor.moveToFirst()) {
            do {
                LostItem item = new LostItem(
                        cursor.getString(cursor.getColumnIndexOrThrow("item_name")),
                        cursor.getString(cursor.getColumnIndexOrThrow("location")),
                        cursor.getString(cursor.getColumnIndexOrThrow("description")),
                        cursor.getString(cursor.getColumnIndexOrThrow("contact")),
                        cursor.getString(cursor.getColumnIndexOrThrow("item_type"))
                );
                itemList.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return itemList;
    }
}
