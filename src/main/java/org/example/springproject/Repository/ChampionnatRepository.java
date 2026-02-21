package org.example.springproject.Repository;

import org.example.springproject.Entities.Championnat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionnatRepository extends JpaRepository<Championnat, Long> {
}
