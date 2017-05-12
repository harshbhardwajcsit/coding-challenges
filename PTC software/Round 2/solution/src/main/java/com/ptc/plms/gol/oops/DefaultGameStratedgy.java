package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.rules.Rule;
import com.ptc.plms.gol.oops.rules.RuleImpl;

/**
 * 
 * @author hdhingra
 *
 */
public class DefaultGameStratedgy extends AbstractGameStratedgy {

	public DefaultGameStratedgy()
	{
		setRules(new Rule[]{new RuleImpl()});
	}
	
}
