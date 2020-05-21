package com.hit.health.service;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.hit.health.bindings.ElgDetails;
import com.hit.health.bindings.IndvInfo;
import com.hit.health.bindings.PlanInfo;

@Service("eligService")
public class DetermineEligibilityService {

	public ElgDetails determineEligibility(IndvInfo indvInfo) {
		String planName = indvInfo.getPlanName();
		ElgDetails elgDetails=null;
		try {
			Class clz = Class.forName("com.hit.health.service.impl."+ planName +"RuleService");
			Object obj = clz.newInstance();
			Method method = clz.getDeclaredMethod("executeRules", IndvInfo.class);
			Object resultObject = method.invoke(obj, indvInfo);
			elgDetails = (ElgDetails) resultObject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elgDetails;
	}
}
