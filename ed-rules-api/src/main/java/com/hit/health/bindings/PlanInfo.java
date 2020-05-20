package com.hit.health.bindings;

import lombok.Data;

@Data
public class PlanInfo {
	private String planName;
	private String planStatus;
	private String planStartDate;
	private String planEndDate;
	private String benefitAmount;
	private String denialReson;
	

}
