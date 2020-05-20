package com.hit.health.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hit.health.bindings.IndvInfo;
import com.hit.health.bindings.PlanInfo;
import com.hit.health.service.DetermineEligibilityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
public class DetermineEligibilityRestController {
	@Autowired
	private DetermineEligibilityService eligService;
	@ApiOperation(
			value = "Find Eligibility Details",
			response = PlanInfo.class,
			tags = "determineEligibility",
			consumes = "application/json",
			produces = "application/xml"
			)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200,message = "Success|OK"),
					@ApiResponse(code = 400, message = "Bad Request"),
					@ApiResponse(code = 401,message = "not authorized"),
					@ApiResponse(code = 403,message = "forbidden"),
					@ApiResponse(code = 404,message = "not found!!!")					
	})
	@PostMapping(
			value = "determindElig",
			produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"}
			)
	public PlanInfo checkPlanEligiblity(@RequestBody IndvInfo indvInfo) {
		System.out.println(indvInfo);
		PlanInfo planInfo = eligService.determineEligibility(indvInfo);
		return planInfo;
	}

}
