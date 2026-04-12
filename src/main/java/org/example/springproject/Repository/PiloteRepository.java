package org.example.springproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.springproject.Entities.Pilote;

public interface PiloteRepository extends JpaRepository<Pilote, Long> {
}