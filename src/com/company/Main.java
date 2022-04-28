package com.company;

public class Main {

    public static void main(String[] args) {
        DBConnection.connect("jdbc:sqlite:db.sqlite");
        DBConnection.createTables();
        DBConnection.disconnect();
    }
}
