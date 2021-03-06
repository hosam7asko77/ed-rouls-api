package com.hit.health.service.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;
import org.springframework.stereotype.Service;

import com.hit.health.bindings.ElgDetails;
import com.hit.health.bindings.IndvInfo;
import com.hit.health.service.RuleService;
@Service
public class MedicaidRuleService implements RuleService {

	@Override
	public ElgDetails executeRules(IndvInfo info) {

		ElgDetails elgDetails=null;

		try {
			InputStream isStream=getClass().getResourceAsStream("/com/ed/rules/Medicaid.drl");
			Reader reader=new InputStreamReader(isStream);
			PackageBuilder packageBuilder=new PackageBuilder();
			packageBuilder.addPackageFromDrl(reader);
			Package rulePackage=packageBuilder.getPackage();
			RuleBase ruleBase=RuleBaseFactory.newRuleBase();
			ruleBase.addPackage(rulePackage);
			//firing rules
			WorkingMemory memory=ruleBase.newStatefulSession();
			memory.insert(info);
			memory.fireAllRules();
			elgDetails=info.getElgDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return elgDetails;
	}
}
