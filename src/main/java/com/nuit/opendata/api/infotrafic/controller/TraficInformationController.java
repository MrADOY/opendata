package com.nuit.opendata.api.infotrafic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.nuit.opendata.api.infotrafic.modele.TraficInformations;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TraficInformationController {

	@GetMapping("/traficinfo")
	public ResponseEntity<TraficInformations> getTraficInformation(@RequestParam(value = "lon", required=false) double lon, @RequestParam(value = "lat", required = false) double lat){
		UriComponents uri = null;
		if(lon == 0 && lat == 0) {
			 uri = UriComponentsBuilder.fromHttpUrl(
					"https://traffic.api.here.com/traffic/6.0/incidents.json?prox=48.8651,2.3780,16119&criticality=0,1&app_id=eJEXHjhWdQT0e6895cjJ&app_code=DBZX2VCflBEfRGTZOmou7g")
					.build();
		} else {
			 uri = UriComponentsBuilder.fromHttpUrl(
					"https://traffic.api.here.com/traffic/6.0/incidents.json?prox={lon},{lat}&criticality=0%2C1&app_id=eJEXHjhWdQT0e6895cjJ&app_code=DBZX2VCflBEfRGTZOmou7g")
					.buildAndExpand(lon,lat);
		}
		
		String url = uri.toUriString();

		RestTemplate restTemplate = new RestTemplate();

		TraficInformations result = restTemplate.getForObject(url, TraficInformations.class);

		return ResponseEntity.ok().body(result);

	}
	
	
}
