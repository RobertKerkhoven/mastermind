package eu.datagraphics.demo.repository;

import eu.datagraphics.demo.model.Guess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Long> {
}
