package be.vdab.testcontainers;

import org.springframework.data.jpa.repository.JpaRepository;

interface PersoonRepository extends JpaRepository<Persoon, Long> {
}
