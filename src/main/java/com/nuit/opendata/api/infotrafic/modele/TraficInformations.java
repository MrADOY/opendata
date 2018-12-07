package com.nuit.opendata.api.infotrafic.modele;

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
public class TraficInformations {

	@JsonProperty("VERSION")
	private int version;
	@JsonProperty("TRAFFICITEMS")
	private TraficItem trafficitems;
}
