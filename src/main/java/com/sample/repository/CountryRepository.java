package com.sample.repository;

import com.sample.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("select c from Country c left join fetch c.countryLanguages cl where c.code =:code and cl.isOfficial=true")
    Optional<Country> findOneWithOfficialLanguage(@Param("code") String code);

}
