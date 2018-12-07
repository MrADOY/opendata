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
public class InformationPrincipales {

	private double temp;
	private double pressure;
	private double humidity;
	private double temp_min;
	private double temp_max;

}
