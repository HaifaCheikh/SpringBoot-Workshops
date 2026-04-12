package org.example.springproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.springproject.Entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}