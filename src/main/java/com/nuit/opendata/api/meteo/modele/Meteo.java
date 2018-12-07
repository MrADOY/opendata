package com.nuit.opendata.api.meteo.modele;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Meteo {

	@Id
	private String _id;
	private int id;
	private String name;
	private String country;
	private Coordonnees coord;

}
