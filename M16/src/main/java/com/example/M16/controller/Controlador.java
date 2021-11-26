package com.example.M16.controller;

import com.example.M16.models.Estadistiques2Jugador;
import com.example.M16.models.Estadistiques3Jugador;
import com.example.M16.models.EstadistiquesJugador;
import com.example.M16.models.Partida;
import com.example.M16.models.Partida2;
import com.example.M16.models.Partida3;
import com.example.M16.models.Usuari;
import com.example.M16.models.UsuariAutentificacio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.M16.repository.Partida2Repository;
import com.example.M16.repository.Partida3Repository;
import com.example.M16.repository.PartidaRepository;
import com.example.M16.repository.UsuariRepository;

@RestController
public class Controlador {
	EstadistiquesJugador estadistiquesJugador;
	Estadistiques2Jugador estadistiques2Jugador; 
	Estadistiques3Jugador estadistiques3Jugador; 

	@Autowired
	private PartidaRepository partidaRepository; 
	@Autowired
	private Partida2Repository partida2Repository; 
	@Autowired
	private Partida3Repository partida3Repository; 

	@Autowired
	private UsuariRepository usuariRepository; 

//-----------------------------POST-------------------------------	
//POST VALORS A L'ATZAR PER POBLAR LA LLISTA BUIDA
	@PostMapping(value="generate")
	public String generate(){
		ArrayList<String> uuids = generateUsers(); 
		generateGames(uuids);
		return "50 jocs de cada grup (P1, P2 i P3) i 10 usuaris generats"; 
	}
		
		
	public void generateGames(ArrayList<String> uuids) {	
	//P1 
		
		int idPartida= calculaIdPartida(); 
	Random rd= new Random(); 
		for (int i =0; i<50; i++) {
			Partida partida = new Partida(); 
			partida.setId(idPartida);
			partida.setUuid(uuids.get(rd.nextInt(10))); 
			partidaRepository.save(partida);
			idPartida++;
		}
		
	//P2
	int idPartida2= calculaIdPartida2(); 
		for (int i =0; i<50; i++) {
			Partida2 partida2 = new Partida2(); 
			partida2.setId(idPartida2);
			partida2.setUuid(uuids.get(rd.nextInt(10))); 
			partida2Repository.save(partida2);
			idPartida2++;
			}	
	//P3	
	int idPartida3= calculaIdPartida3(); 
		for (int i =0; i<50; i++) {
			Partida3 partida3 = new Partida3(); 
			partida3.setId(idPartida3);
			partida3.setUuid(uuids.get(rd.nextInt(10))); 
			partida3Repository.save(partida3);
			idPartida3++;
			}	
	}
	
	public ArrayList<String> generateUsers() {
		String lletresNombres ="1234567890abcdefghijklmnopqrstuvwxyz";
		Random rd= new Random();
		ArrayList <String> uuids = new ArrayList<String>(); 
		for (int i =0; i<10; i++) {
			Usuari usuari = new Usuari();
			String uuid = generaUuid();
			usuari.setUuid(uuid);
			String nomUsuari=""; 
			String password=""; 
			for(int j = 0; j<5; j++) {
				nomUsuari= nomUsuari + lletresNombres.charAt(rd.nextInt(36)); 
				password = password + lletresNombres.charAt(rd.nextInt(36)); 
			}
			usuari.setNomUsuari(nomUsuari);
			usuari.setPassword(password);
			uuids.add(uuid);
			usuariRepository.save(usuari);
		}
		return uuids; 
	}
	
// POST JUGADOR
    @PostMapping(value="player")
    public String createUsuari(@RequestBody Usuari usuari){
    	if(usuariRepository.findByNomUsuari(usuari.getNomUsuari()).isEmpty()) {
        	usuari.setUuid(generaUuid());
            usuariRepository.save(usuari);
            return "usuari creat";
    	} else {
    		return "El nom d'usuari ja existeix"; 
    	}

    }
//POST PARTIDA-USUARI
	@PostMapping(value="/player/{uuid}/games")
	public void createPartida(@PathVariable("uuid") String uuid) {
		Partida partida = new Partida(); 
		partida.setId(calculaIdPartida()); 
		partida.setUuid(uuid);
		partidaRepository.save(partida); 
	}
	
//-----------------------------PUT-------------------------------	
//PUT NOM USUARI
    @PutMapping(value = "player/{uuid}")
    public String modificaNomUsuari(@PathVariable("uuid") String uuid, @RequestBody Usuari usuari) {
    	usuari.setUuid(uuid);
    	usuariRepository.save(usuari);

    	return usuari.getNomUsuari();
    }
    
//-----------------------------GET-------------------------------	
//GET TOTES LES PARTIDES	
	@GetMapping("/games")
	public List<Partida> getPartides(){
		List<Partida> llista= partidaRepository.findAll(); 
		return llista; 
	}	
//GET PARTIDA-USUARI
	@GetMapping(value="/player/{uuid}/games")
	public List<Partida> partidesJugador(@PathVariable("uuid") String uuid){
		if(usuariRepository.findByUuid(uuid)!=null) {
			List<Partida> partidesJugador = partidaRepository.findPartidesByUuid(uuid);
			return partidesJugador; 
		}
		else {
			return null; 
		}
	}

//GET PLAYERS AMB PERCENTATGES
	@GetMapping(value="players")
	public List<EstadistiquesJugador> estadistiquesJugadors(){
		List<EstadistiquesJugador> eJ = new ArrayList<EstadistiquesJugador>();
		for(Usuari usuari: usuariRepository.findAll()) {
			EstadistiquesJugador estadistiquesJugador = new EstadistiquesJugador(usuari, partidaRepository.findPartidesByUuid(usuari.getUuid()));
			eJ.add(estadistiquesJugador);
		}
		return eJ; 
	}
//GET RANKING DE MILLOR A PITJOR
	@GetMapping(value="ranking")
	public List<EstadistiquesJugador> ranking(){
		List<EstadistiquesJugador> ranking = estadistiquesJugadors().stream()
											.sorted(Comparator.comparingInt(EstadistiquesJugador::getPercentGuanya)
											.reversed())
											.collect(Collectors.toList());
		return ranking; 
	}
//GET MILLOR JUGADOR (Retorna només un jugador, no té en compte els empats)
	@GetMapping(value="ranking/winner")
	public Usuari winner() {
		Usuari usuariWinner = ranking().get(0).getUsuari();
		return usuariWinner;
	}
	
//GET PITJOR JUGADOR
	@GetMapping(value="ranking/loser")

	public Usuari loser() {
		Usuari usuariLoser = ranking().get((ranking().size()-1)).getUsuari();
		return usuariLoser;
	}
//-----------------------------DELETE-------------------------------	
//DELETE PARTIDA-USUARI
    @DeleteMapping(value="/player/{uuid}/games")
    public void eliminaPartidesJugador(@PathVariable("uuid") String uuid) {
    	partidaRepository.deletePartidesByUuid(uuid);
    }

//DELETE TOTES LES PARTIDES 1
	@DeleteMapping("/games")
	public String deletePartides() {
		partidaRepository.deleteAll();
		return "Totes les partides eliminades";
	}
//DELETE TOTS ELS USUARIS
	@DeleteMapping("/players")
	public String deletePlayer() {
		usuariRepository.deleteAll();
		return "Tots els usuaris eliminats"; 
	}
	@DeleteMapping("/all")
	public String deleteAll() {
		usuariRepository.deleteAll();
		partidaRepository.deleteAll();
		partida2Repository.deleteAll();
		partida3Repository.deleteAll();
		return "Tot ha estat eliminat"; 
	}

	
//-----------------------------ALTRES FUNCIONS-------------------------------	
public String generaUuid() {
	String uuid=UUID.randomUUID().toString();
	return uuid; 
	
}

public int calculaIdPartida() {
	int idPartida = partidaRepository.findAll().size();
	return idPartida; 
}
public int calculaIdPartida2() {
	int idPartida2 = partida2Repository.findAll().size();
	return idPartida2; 
}
public int calculaIdPartida3() {
	int idPartida3 = partida3Repository.findAll().size();
	return idPartida3; 
}

//-----------------------------JOC DAUS 2 i 3-------------------------------	

	//POST PARTIDA-USUARI 2
		@PostMapping(value="{joc}/player/{uuid}/games")
		public void createPartida23(@PathVariable("joc") int joc, @PathVariable("uuid") String uuid) {
		if (joc==2) {
			Partida2 partida2 = new Partida2(); 
			partida2.setId(calculaIdPartida2()); 
			partida2.setUuid(uuid);
			partida2Repository.save(partida2); 
		} else if (joc==3) {
			Partida3 partida3 = new Partida3(); 
			partida3.setId(calculaIdPartida3()); 
			partida3.setUuid(uuid);
			partida3Repository.save(partida3); 
		}}


		
	//GET TOTES LES PARTIDES 2	
		@GetMapping("2/games")
		public List<Partida2> getPartides23(){
			List<Partida2> llista= partida2Repository.findAll(); 
			return llista; 
		}	
	//GET TOTES LES PARTIDES 3	
		@GetMapping("3/games")
		public List<Partida3> getPartides3(){
			List<Partida3> llista= partida3Repository.findAll(); 
			return llista; 
		}	
	
		
	//GET PARTIDA-USUARI 2
		@GetMapping(value="{joc}/player/{uuid}/games")
		public List<Partida2> partides2Jugador(@PathVariable("uuid") String uuid){
			if(usuariRepository.findByUuid(uuid)!=null) {
				List<Partida2> partides2Jugador = partida2Repository.findPartidesByUuid(uuid);
				return partides2Jugador; 
			}
			else {
				return null; 
			}
		}
	//GET PARTIDA-USUARI 3
		@GetMapping(value="3/player/{uuid}/games")
		public List<Partida3> partides3Jugador(@PathVariable("uuid") String uuid){
			if(usuariRepository.findByUuid(uuid)!=null) {
				List<Partida3> partides3Jugador = partida3Repository.findPartidesByUuid(uuid);
				return partides3Jugador; 
			}
			else {
				return null; 
			}
		}

		
	//GET PLAYERS AMB PERCENTATGES 2
		@GetMapping(value="2/players")
		public List<Estadistiques2Jugador> estadistiques2Jugadors(){
			List<Estadistiques2Jugador> eJ = new ArrayList<Estadistiques2Jugador>();
			for(Usuari usuari: usuariRepository.findAll()) {
				Estadistiques2Jugador estadistiques2Jugador = new Estadistiques2Jugador(usuari, partida2Repository.findPartidesByUuid(usuari.getUuid()));
				eJ.add(estadistiques2Jugador);
			}
			return eJ; 
		}	
	//GET PLAYERS AMB PERCENTATGES 3
		@GetMapping(value="3/players")
		public List<Estadistiques3Jugador> estadistiques3Jugadors(){
			List<Estadistiques3Jugador> eJ = new ArrayList<Estadistiques3Jugador>();
			for(Usuari usuari: usuariRepository.findAll()) {
				Estadistiques3Jugador estadistiques3Jugador = new Estadistiques3Jugador(usuari, partida3Repository.findPartidesByUuid(usuari.getUuid()));
				eJ.add(estadistiques3Jugador);
			}
			return eJ; 
		}	
		

	//GET RANKING DE MILLOR A PITJOR 2
		@GetMapping(value="2/ranking")
		public List<Estadistiques2Jugador> ranking2(){
			List<Estadistiques2Jugador> ranking = estadistiques2Jugadors().stream()
												.sorted(Comparator.comparingInt(Estadistiques2Jugador::getPercentGuanya)
												.reversed())
												.collect(Collectors.toList());
			return ranking; 
		}
		//GET RANKING DE MILLOR A PITJOR 3
		@GetMapping(value="3/ranking")
		public List<Estadistiques3Jugador> ranking3(){
			List<Estadistiques3Jugador> ranking = estadistiques3Jugadors().stream()
												.sorted(Comparator.comparingInt(Estadistiques3Jugador::getPercentGuanya)
												.reversed())
												.collect(Collectors.toList());
			return ranking; 
		}
	
	//GET MILLOR JUGADOR (Retorna només un jugador, no té en compte els empats)
		@GetMapping(value="{joc}/ranking/winner")
		public Usuari winner23(@PathVariable("joc") int joc) {
			if (joc==2) {
				Usuari usuariWinner = ranking2().get(0).getUsuari();
				return usuariWinner;
			}
			else if (joc ==3) {
				Usuari usuariWinner = ranking3().get(0).getUsuari();
				return usuariWinner;
			}
			else {
				return null; 
			}
		}	
	//GET PITJOR JUGADOR (Retorna només un jugador, no té en compte els empats)
		@GetMapping(value="{joc}/ranking/loser")
		public Usuari loser23(@PathVariable("joc") int joc) {
			if (joc==2) {
				Usuari usuariLoser = ranking2().get((ranking2().size()-1)).getUsuari();
				return usuariLoser;
			}
			else if (joc ==3) {
				Usuari usuariLoser = ranking3().get((ranking3().size()-1)).getUsuari();
				return usuariLoser;
			}
			else {
				return null; 
			}
		}		


	//DELETE TOTES LES PARTIDES 2 o 3
		@DeleteMapping("{joc}/games")
		public String deletePartides23 (@PathVariable("joc") int joc) {
			if(joc==2) {
				partida2Repository.deleteAll();
				return "Totes les partides 2 eliminades";
			} else if (joc==3) {
				partida3Repository.deleteAll();
				return "Totes les partides 3 eliminades";
			} else {
				return "Error. La partida no existeix";
			}

		}		
		
}

