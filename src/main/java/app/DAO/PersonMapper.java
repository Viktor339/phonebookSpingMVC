package app.DAO;

import app.entity.Person;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setPhoneNumber(resultSet.getString("phoneNumber"));
        person.setName(resultSet.getString("name"));
        person.setSecondName(resultSet.getString("secondName"));
        person.setAddress(resultSet.getString("address"));
        return person;
    }
}