package com.nuit.opendata.api.meteo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nuit.opendata.api.meteo.modele.Coordonnees;
import com.nuit.opendata.api.meteo.modele.Meteo;

public interface MeteoRepository extends MongoRepository<Meteo, Integer> {

	public Optional<Meteo> findByCoord(Coordonnees coord);

	public Optional<Meteo> findByName(String name);

	public Page<Meteo> findAll(Pageable pageable);
}