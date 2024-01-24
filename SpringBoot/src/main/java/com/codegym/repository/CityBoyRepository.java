package com.codegym.repository;

import com.codegym.model.CityBoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityBoyRepository extends JpaRepository<CityBoy, Long> {
    List<CityBoy> findByAge(int age);

    List<CityBoy> findByNameContaining(String name);

    @Query(value = "select * from cityboy where name = :name and age = :age", nativeQuery = true)
    CityBoy findCustom(@Param("name") String name, @Param("age") int age);

//    List<CityBoy> findByTeamsId(Long id);
}
