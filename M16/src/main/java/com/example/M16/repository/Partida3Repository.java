package com.example.M16.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.M16.models.Partida;
import com.example.M16.models.Partida2;
import com.example.M16.models.Partida3;

public interface Partida3Repository extends MongoRepository<Partida3, Integer>{
    List<Partida3> findPartidesByUuid(String uuid);
    int deletePartidesByUuid( String uuid);
	List<Partida3> findPartidesByGuanyada(boolean b);

}
