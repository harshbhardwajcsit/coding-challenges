package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.rules.Rule;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;


public class AbstractGameStratedgyTest {

    @Test
    public void testFindNeighbours() {
        System.out.println("findNeighbours");
        Cell cell = new Cell(2,3);
        Set<Cell> liveCells =new HashSet<Cell>();
        liveCells.add(new Cell(1,2));
        liveCells.add(new Cell(1,3));
        liveCells.add(new Cell(1,4));
        liveCells.add(new Cell(2,2));
        liveCells.add(new Cell(2,3));
        liveCells.add(new Cell(2,4));
        liveCells.add(new Cell(3,2));
        liveCells.add(new Cell(3,3));
        liveCells.add(new Cell(3,4));

       
        Set<Cell> expResult = new HashSet<Cell>();
        expResult.add(new Cell(1,2));
        expResult.add(new Cell(1,3));
        expResult.add(new Cell(1,4));
        expResult.add(new Cell(2,2));
        expResult.add(new Cell(2,3));
        expResult.add(new Cell(2,4));
        expResult.add(new Cell(3,2));
        expResult.add(new Cell(3,3));
        expResult.add(new Cell(3,4));

        Set result = AbstractGameStratedgy.findNeighbours(cell, liveCells);
        assertEquals(expResult, result);

    }
    //testing for boundary conditions
    @Test
    public void testFindNeighbours2() {
        System.out.println("findNeighbours");
        Cell Cell = new Cell(0,0);
        Set<Cell> liveCells =new HashSet<Cell>();
        liveCells.add(new Cell(0,0));
        liveCells.add(new Cell(0,1));
        liveCells.add(new Cell(1,0));
        liveCells.add(new Cell(1,1));

        
        Set<Cell> expResult = new HashSet<Cell>();

        expResult.add(new Cell(0,0));
        expResult.add(new Cell(0,1));
        expResult.add(new Cell(1,0));
        expResult.add(new Cell(1,1));

        Set result = AbstractGameStratedgy.findNeighbours(Cell, liveCells);
        assertEquals(expResult, result);

    }



}