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
public class TraficInformation {

	@JsonProperty("TRAFFICITEMTYPEDESC")
	private String trafficItemTypeDesc;
	@JsonProperty("STARTTIME")
	private String startime;
	@JsonProperty("ENDTIME")
	private String endTime;
	@JsonProperty("ENTRYTIME")
	private String entryTime;
	@JsonProperty("CRITICALITY")
	private Criticite criticality;
	@JsonProperty("COMMENTS")
	private String comments;
	@JsonProperty("TRAFFICITEMDESCRIPTION")
	private TraficDescription[] traficDescription;
}
