package app.DAO;

import app.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DirectoryDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DirectoryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> showDirectory() {
        return jdbcTemplate.query("SELECT * FROM Directory ORDER BY id", new PersonMapper());
    }

    public Person getNotationByUserId(int id) {
        return  jdbcTemplate.query("SELECT * FROM Directory WHERE id=?",new Object[]{id},new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void addNewNotation(Person person) {
        jdbcTemplate.update("insert  into Directory(phonenumber, name, secondname, address) values (?,?,?,?);",
                person.getPhoneNumber(),person.getName(),person.getSecondName(),person.getAddress());
    }

    public void deleteNotation(int id) {
        jdbcTemplate.update("DELETE FROM Directory WHERE id=?", id);
    }

    public void updateNotation(Person person) {
        jdbcTemplate.update("UPDATE Directory SET phonenumber=?, name=?,secondname=?,address=? WHERE id=?",
                person.getPhoneNumber(),person.getName(),
                person.getSecondName(), person.getAddress(), person.getId());
    }
}
