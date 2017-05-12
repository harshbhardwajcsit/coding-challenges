package com.ptc.plms.gol.oops;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuleRunnerTest {

    @Test
    public void testApplyRules() {
        System.out.println("applyRules");
        Set< Cell > liveCells = new HashSet<Cell>();
        liveCells.add(new Cell(1,1,State.DEAD));
        liveCells.add(new Cell(1,3,State.LIVE));
        liveCells.add(new Cell(2,3,State.DEAD));
        liveCells.add(new Cell(3,1,State.LIVE));
        liveCells.add(new Cell(3,2,State.LIVE));
        liveCells.add(new Cell(2,1,State.DEAD));
        RuleRunner instance=new RuleRunner();




        Set<Cell> expResult = new HashSet<Cell>();
        expResult.add(new Cell(1,1,State.LIVE));
        expResult.add(new Cell(3,2,State.LIVE));
        Set<Cell> result = instance.applyRules(liveCells);
        assertEquals(expResult, result);
     
    }
}