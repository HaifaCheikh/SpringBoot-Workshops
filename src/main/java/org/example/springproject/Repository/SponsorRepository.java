package org.example.springproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.example.springproject.Entities.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor,Long> {


}
