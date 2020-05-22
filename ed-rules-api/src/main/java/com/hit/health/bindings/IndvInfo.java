package com.hit.health.bindings;

import lombok.Data;

@Data
public class IndvInfo {

	private String indvFirstName;
	private String indvLastName;
	private String indvDob;
	private String planName;
	private boolean employed;
	private ElgDetails elgDetails;
	
}
