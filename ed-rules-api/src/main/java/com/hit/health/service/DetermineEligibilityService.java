package com.hit.health.service;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.hit.health.bindings.IndvInfo;
import com.hit.health.bindings.PlanInfo;

@Service("eligService")
public class DetermineEligibilityService {

	public PlanInfo determineEligibility(IndvInfo indvInfo) {
		String planName = indvInfo.getPlanName();
		PlanInfo planInfo=null;
		try {
			Class clz = Class.forName("com.hit.health.service.impl."+ planName +"RuleService");
			Object obj = clz.newInstance();
			Method method = clz.getDeclaredMethod("executeRules", IndvInfo.class);
			Object resultObject = method.invoke(obj, indvInfo);
			planInfo = (PlanInfo) resultObject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planInfo;
	}
}
