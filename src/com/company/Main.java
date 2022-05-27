package com.company;

import com.company.model.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

import static com.company.DBConnection.*;

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

        Risk risk2 = new Risk();
        risk2.setPriceFrom(55d);
        risk2.setPriceTo(119.99);
        risk2.setDescription("test2");
        risk2.setPolicyType(PolicyTypes.HEALTH_POLICY);
        risk2.save();

        Address address1 = new Address("Polska", "00-000", "Warszawa", "ul. Nowa", "99", "2");
        address1.save();

        Person person = new Person();
        person.setAddress(address1);
        person.setPesel("11111111122");
        person.setPhone("123456789");
        person.setFirstName("Jan");
        person.setLastName("Kowalski");
        person.save();

        Policy policy1 = new Policy();
        policy1.setPolicyholder(person);
        policy1.setInsured(person);
        policy1.setBeneficiary(person);
        policy1.setDurationFrom(LocalDate.now());
        policy1.setDurationTo(LocalDate.of(2024, Month.NOVEMBER, 10));
        policy1.setPrice(1000d);
        policy1.setPolicyType(PolicyTypes.HEALTH_POLICY);
        policy1.setRisks(List.of(risk, risk2));
        policy1.save();

        Document document = new Document();
        document.setDocument_url("url/test");
        document.save();

        Damage damage = new Damage();
        damage.setPolicy(policy1);
        damage.setDocuments(Set.of(document));
        damage.setVictim(person);
        damage.save();

        Address address2 = new Address("Polska", "00-111", "Kraków", "ul. Długa", "2", "1");
        address2.save();

        Incident incident = new Incident();
        incident.setDate(LocalDate.of(2022, Month.FEBRUARY, 5));
        incident.setPlace(address2);
        incident.setDamages(List.of(damage));
        incident.save();

        incident.getPlace().setCity("Poznań");
        incident.getPlace().save();

        Controller controller = new Controller();
        List<Policy> policies = controller.getAllPolicies();
        policies.get(0).getRisks().forEach(System.out::println);

        disconnect();
    }
}
