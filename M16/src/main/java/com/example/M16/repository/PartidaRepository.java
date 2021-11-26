package com.example.M16.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.M16.models.Partida;

public interface PartidaRepository extends MongoRepository<Partida, Integer>{
    List<Partida> findPartidesByUuid(String uuid);
    int deletePartidesByUuid( String uuid);
	List<Partida> findPartidesByGuanyada(boolean b);

}
