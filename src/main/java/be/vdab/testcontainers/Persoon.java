package be.vdab.testcontainers;

import jakarta.persistence.*;

@Entity
@Table(name = "personen")
class Persoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voornaam;

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }
}
