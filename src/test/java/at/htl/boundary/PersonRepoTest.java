package at.htl.boundary;

import at.htl.entity.Person;
import com.thoughtworks.xstream.converters.time.LocalDateConverter;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;

@QuarkusTest
public class PersonRepoTest {

    @Inject
    PersonRepo personRepo;

    @Inject
    AgroalDataSource dataSource;

    @Test
    @Transactional
    public void testTempUserExists() {
        personRepo.persist(new Person(LocalDate.now(),"David"));
        Table table = new Table(dataSource, "person");
        output(table).toConsole();
        assertThat(table).row(0).column(2).value().isEqualTo("David");
    }
}
