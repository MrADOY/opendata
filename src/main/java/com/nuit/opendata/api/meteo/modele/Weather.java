package com.nuit.opendata.api.meteo.modele;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Weather {

	private int id;
	private String main;
	private String description;
	@JsonProperty("icon")
	private String icon;
}
