package be.vdab.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static  org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
@Sql("/insertPersonen.sql")
class PersoonRepositoryTest {
    private final PersoonRepository repository;
    @Container @ServiceConnection
    private static final MySQLContainer mySQL =
            new MySQLContainer("mysql:latest")
                    .withDatabaseName("testcontainers")
                    .withUsername("cursist")
                    .withPassword("cursist");

    public PersoonRepositoryTest(PersoonRepository repository) {
        this.repository = repository;
    }
    @Test
    void erIs1PersoonEnDatIsJoe(){
        assertThat(repository.findAll())
                .singleElement()
                .extracting(Persoon::getVoornaam)
                .isEqualTo("Joe");
    }
}
