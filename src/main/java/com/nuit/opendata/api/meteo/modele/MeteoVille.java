package com.nuit.opendata.api.meteo.modele;

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
public class MeteoVille {

	private int id;
	private String name;
	private Coordonnees coord;
	private Weather weather[];
	private InformationPrincipales main;

}
