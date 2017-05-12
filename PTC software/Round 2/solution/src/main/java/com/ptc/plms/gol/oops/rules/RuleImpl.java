package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.State;

/**
 * 
 * @author hdhingra
 *
 */
public class RuleImpl implements Rule{

	@Override
	public State nextState(State currentState, int liveNeighbours) {
		
		if(State.LIVE.equals(currentState))
		{
			if(liveNeighbours==2 || liveNeighbours==3)
			{
				return State.LIVE;
			}
			else return State.DEAD;
		}
		else if(State.DEAD.equals(currentState)) 
		{
			if(liveNeighbours == 3)
			{
				return State.LIVE;
			}
		}
		
		return currentState;
	}

}
