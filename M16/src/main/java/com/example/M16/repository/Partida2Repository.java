package com.example.M16.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.M16.models.Partida;
import com.example.M16.models.Partida2;

public interface Partida2Repository extends MongoRepository<Partida2, Integer>{
    List<Partida2> findPartidesByUuid(String uuid);
    int deletePartidesByUuid( String uuid);
	List<Partida2> findPartidesByGuanyada(boolean b);

}
