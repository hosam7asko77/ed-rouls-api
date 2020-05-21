package com.hit.health.service;

import com.hit.health.bindings.ElgDetails;
import com.hit.health.bindings.IndvInfo;
public interface RuleService {
	public ElgDetails executeRules(IndvInfo info);

}
