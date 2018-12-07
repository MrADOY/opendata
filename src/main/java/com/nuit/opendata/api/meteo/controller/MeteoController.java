package com.nuit.opendata.api.meteo.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.nuit.opendata.api.meteo.modele.Coordonnees;
import com.nuit.opendata.api.meteo.modele.Meteo;
import com.nuit.opendata.api.meteo.modele.MeteoVille;
import com.nuit.opendata.api.meteo.repository.MeteoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MeteoController {

	@Autowired
	private MeteoRepository repository;
	
	@GetMapping(value = "/meteo")
	public ResponseEntity<MeteoVille> getTodoById(@RequestParam("lon") double lon, @RequestParam("lat") double lat) {
	
		Meteo meteo = repository.findByCoord(new Coordonnees(lon, lat)).get();

		meteo.getName();

		UriComponents uri = UriComponentsBuilder

				.fromHttpUrl(
						"http://api.openweathermap.org/data/2.5/weather?q={name}&APPID=a1e5ea2bc50227fb037cd1f01d5e541b")
				.buildAndExpand(meteo.getName());

		String urlString = uri.toUriString();

		RestTemplate restTemplate = new RestTemplate();

		MeteoVille result = restTemplate.getForObject(urlString, MeteoVille.class);

		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/meteo/{name}")
	public ResponseEntity<MeteoVille> getTodoByName(@PathVariable("name") String name) {
		Meteo meteo = repository.findByName(name).get();

		meteo.getName();

		UriComponents uri = UriComponentsBuilder

				.fromHttpUrl(
						"http://api.openweathermap.org/data/2.5/weather?q={name}&APPID=a1e5ea2bc50227fb037cd1f01d5e541b")
				.buildAndExpand(meteo.getName());

		String urlString = uri.toUriString();

		RestTemplate restTemplate = new RestTemplate();

		MeteoVille result = restTemplate.getForObject(urlString, MeteoVille.class);

		return ResponseEntity.ok().body(result);

	}
	
	
	public MeteoVille callApi(Meteo m) {
		UriComponents uri = UriComponentsBuilder

				.fromHttpUrl(
						"http://api.openweathermap.org/data/2.5/weather?q={name}&APPID=a1e5ea2bc50227fb037cd1f01d5e541b")
				.buildAndExpand(m.getName());

		String urlString = uri.toUriString();

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(urlString, MeteoVille.class);
	}
	
	@GetMapping(value = "/meteos")
	public ResponseEntity<List<MeteoVille>> getAllMeteo() {
		Pageable pageable = PageRequest.of(0, 5);
		List<Meteo> meteo = repository.findAll(pageable).stream().limit(5).collect(Collectors.toList());

		Collections.shuffle(meteo);
		
		return ResponseEntity.ok().body(meteo.stream().map(m -> callApi(m)).collect(Collectors.toList()));

	}
	

}
