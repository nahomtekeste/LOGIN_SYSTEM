package com.example.lesson_four

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import java.security.AccessControlContext

class DateBaseHelper (context: Context) : SQLiteOpenHelper(context , dbname , factory ,version){


    override fun onCreate(p0: SQLiteDatabase?) {
    p0?.execSQL("create  table user (id integer primary key autoincreament ," +
    " name varchar (30) , email varcher(100) , passowrod varchar (20)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun inserUserData(name : String, email:String , password : String) {
        val db : SQLiteDatabase = writableDatabase
        val values : ContentValues=  ContentValues()
        values.put("name" , name)
        values.put("email" , email)
        values.put("password" , password)

        db.insert("user " , null, values)
        db.close()
    }
    fun userPresent(emial: String , password: String) : Boolean {
        val db = writableDatabase
        val query = " select * from user where email = $emial and password  = $password"
        val  cursor  = db.rawQuery(query , null)
        if(cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    companion object{
        internal val dbname ="userDB"
        internal val factory = null
        internal val version = 1
    }

}