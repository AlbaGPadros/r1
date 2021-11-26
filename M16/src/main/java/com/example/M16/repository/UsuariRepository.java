package com.example.M16.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.M16.models.Usuari;

public interface UsuariRepository extends MongoRepository<Usuari, String>{
	public List<Usuari> findByNomUsuari(String nomUsuari);
	List<Usuari> findByUuid(String uuid);

}
