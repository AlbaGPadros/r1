package com.example.CRUD.repository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.CRUD.bean.Treballador;
@Repository
public interface BaseDades3 extends JpaRepository<Treballador, Integer> {
	
	 @Query(value = "SELECT * FROM treballador WHERE feina = :feina", nativeQuery = true)
	    ArrayList<Treballador> findTreballadorByFeina(@Param("feina") int feina);
}
