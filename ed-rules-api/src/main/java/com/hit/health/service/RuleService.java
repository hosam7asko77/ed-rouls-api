package com.hit.health.service;

import com.hit.health.bindings.IndvInfo;
import com.hit.health.bindings.PlanInfo;

public interface RuleService {
	public PlanInfo executeRules(IndvInfo info);

}
