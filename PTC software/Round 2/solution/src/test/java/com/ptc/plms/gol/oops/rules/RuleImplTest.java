package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.State;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuleImplTest {


    @Test
    public void testNextState1() {
     
        State currentState = State.LIVE;
        int liveNeighbours = 2;
        RuleImpl instance = new RuleImpl();
        State expResult = State.LIVE;
        State result = instance.nextState(currentState, liveNeighbours);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testNextState2() {

        State currentState = State.LIVE;
        int liveNeighbours = 3;
        RuleImpl instance = new RuleImpl();
        State expResult = State.LIVE;
        State result = instance.nextState(currentState, liveNeighbours);
        assertEquals(expResult, result);

    }
    @Test
    public void testNextState3() {

        State currentState = State.LIVE;
        int liveNeighbours = 1;
        RuleImpl instance = new RuleImpl();
        State expResult = State.DEAD;
        State result = instance.nextState(currentState, liveNeighbours);
        assertEquals(expResult, result);

    }
    @Test
    public void testNextStat4() {

        State currentState = State.LIVE;
        int liveNeighbours = 4;
        RuleImpl instance = new RuleImpl();
        State expResult = State.DEAD;
        State result = instance.nextState(currentState, liveNeighbours);
        assertEquals(expResult, result);

    }
    @Test
    public void testNextState5() {

        State currentState = State.DEAD;
        int liveNeighbours = 3;
        RuleImpl instance = new RuleImpl();
        State expResult = State.LIVE;
        State result = instance.nextState(currentState, liveNeighbours);
        assertEquals(expResult, result);

    }
    @Test
    public void testNextState6() {

        State currentState = State.DEAD;
        int liveNeighbours = 2;
        RuleImpl instance = new RuleImpl();
        State expResult = State.DEAD;
        State result = instance.nextState(currentState, liveNeighbours);
        assertEquals(expResult, result);

    }

}