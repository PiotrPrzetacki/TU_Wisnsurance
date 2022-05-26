package com.company;

import com.company.model.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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

        Policy policy = new Policy();
        policy.setPolicyholder(person);
        policy.setInsured(person);
        policy.setBeneficiary(person);
        policy.setDuration_from(new Date());
        policy.setDuration_to(new Date(2024-1900, Calendar.NOVEMBER, 10));
        policy.setPrice(1000d);
        policy.setPolicyType(PolicyTypes.HEALTH_POLICY);

        policy.save();

        disconnect();
    }
}
