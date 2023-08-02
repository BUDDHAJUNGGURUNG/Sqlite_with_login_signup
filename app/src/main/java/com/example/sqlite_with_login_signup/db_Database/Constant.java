package com.example.sqlite_with_login_signup.db_Database;

public class Constant {
    //Database Name
    public  static  final String DB_NAME="MY_RECORDS_NAME";

    //Database Table Name
    public  static  final String TABLE_NAME="MY_RECORDS_TABLE";

    //Database Version
    public static final int DB_VERSION=1;

    //Database Column
    public  static final  String C_ID="ID";
    public  static final  String C_NAME="NAME";
    public  static final  String C_IMAGE="IMAGE";
    public  static final  String C_ADDRESS="ADDRESS";
    public  static final  String C_EMAIL="EMAIL";
    public  static final  String C_PHONE="PHONE";

    //Create table query
    public static final  String CREATE_TABLE="CREATE TABLE" + TABLE_NAME + "("
            +C_ID +"TEXT,"
            +C_NAME +"TEXT,"
            +C_IMAGE +"TEXT,"
            +C_ADDRESS +"TEXT,"
            +C_EMAIL +"TEXT,"
            +C_PHONE +"TEXT"
            +")";

}
