package com.example.lab04.PHAN2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 3;
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " +
                TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY autoincrement," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
        onCreate(db);
    }
    public void addContact(Contact new_contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", new_contact.getID());
        values.put("name", new_contact.getName());
        values.put("phone_number", new_contact.getPhoneNumber());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<Contact> getAllContacts()
    {
        List<Contact> contacts_ = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID,KEY_NAME,KEY_PH_NO}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            contacts_.add(new Contact(cursor.getInt(cursor.getColumnIndex(KEY_ID)), cursor.getString(cursor.getColumnIndex(KEY_NAME)),cursor.getString(cursor.getColumnIndex(KEY_PH_NO))));
        }
        return contacts_;
    }
    public boolean deleteContact(long rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CONTACTS, KEY_ID + "=" + rowId,
                null) > 0;
    }
    public Contact getContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS + " WHERE id = ? ";

        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") Contact contact = new Contact(cursor.getInt(cursor.getColumnIndex(KEY_ID)), cursor.getString(cursor.getColumnIndex(KEY_NAME)),cursor.getString(cursor.getColumnIndex(KEY_PH_NO)));
            cursor.close();
            return contact;
        } else {
            cursor.close();
            return null;
        }
    }
    public void deleteAllContacts()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, null, null);
    }
    public String updateContactPhoneNumber(long id, String newPhonenumber) {
            SQLiteDatabase db = this.getWritableDatabase();
            String query = " UPDATE "+ TABLE_CONTACTS +" SET phone_number = ? WHERE id = ?";

            SQLiteStatement statement = db.compileStatement(query);
            statement.bindString(1, newPhonenumber);
            statement.bindLong(2, id);
            statement.executeUpdateDelete();
            statement.close();
            db.close();
            Contact contact = this.getContact((int)id);
            return contact.toString();
    }
}
