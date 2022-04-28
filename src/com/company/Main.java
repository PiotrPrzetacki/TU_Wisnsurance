package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.DBConnection.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        connect("jdbc:sqlite:db.sqlite");
        createTables();

        getStatement().execute("INSERT INTO enterprises (nip, regon, representative_id) VALUES (123, 321, 1);");
        getStatement().execute("INSERT INTO enterprises (nip, regon, representative_id) VALUES (555, 11, 2);");
        ResultSet rs = getStatement().executeQuery("SELECT * FROM enterprises;");
        while (rs.next()){
            System.out.println("id: "+rs.getString("id"));
            System.out.println("nip: "+rs.getString("nip"));
            System.out.println("----");
        }

        disconnect();
    }
}
