package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.State;

/**
 * 
 * @author hdhingra
 *
 */
public interface Rule {
	State nextState(State currentState,int liveNeighbours);
}
