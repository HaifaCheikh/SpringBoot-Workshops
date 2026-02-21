package org.example.springproject.Repository;

import org.example.springproject.Entities.DetailChampionnat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailChampionnatRepository extends JpaRepository<DetailChampionnat, Long> {
}
