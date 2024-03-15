package com.example.thirdlesson

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(private val context: Context, private val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context,"appDb" , factory, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users(id INT PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }


    fun addUser(user: User){
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("password", user.password)

        val db = this.writableDatabase
        db.insert("users",null, values)

        db.close()
    }

    fun checkUser(login: String, password : String) : Boolean{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE login=? AND password=?", arrayOf(login, password))
        val exists = cursor.moveToFirst()
        cursor.close()
        db.close()
        return exists
    }


}