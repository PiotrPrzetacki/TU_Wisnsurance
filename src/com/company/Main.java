package com.company;

import com.company.model.Address;
import com.company.model.Person;
import com.company.model.PolicyTypes;
import com.company.model.Risk;

import java.sql.SQLException;

import static com.company.model.DBConnection.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        connect("jdbc:sqlite:db.sqlite");
        createTables();

        Risk risk = new Risk();
        risk.setPriceFrom(50d);
        risk.setPriceTo(99.99);
        risk.setDescription("test");
        risk.setPolicyType(PolicyTypes.HEALTH_POLICY);
        risk.save();

        Address address1 = new Address("Polska", "00-000", "Warszawa", "ul. Nowa", "99", "2");
        address1.save();

        Person person = new Person();
        person.setAddress(address1);
        person.setPesel("11111111122");
        person.setPhone("123456789");
        person.setFirstName("Jan");
        person.setLastName("Kowalski");
        person.save();

        disconnect();
    }
}
