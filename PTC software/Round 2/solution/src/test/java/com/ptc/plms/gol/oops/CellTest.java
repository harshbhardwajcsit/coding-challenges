package com.ptc.plms.gol.oops;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samsung
 */
public class CellTest {
     /**
     * Test of getX method, of class Cell.
     */

    @Test
    public void testGetX() {
        System.out.println("getX");
        Cell instance = new Cell(2,3);
        int expResult = 2;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Cell.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Cell instance = new Cell(2,3);
        int expResult = 3;
        int result = instance.getY();
        assertEquals(expResult, result);
        fail("problem in returning y coodinates");
    }

    /**
     * Test of getState method, of class Cell.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Cell instance = new Cell(2,3,State.LIVE);
        State expResult = State.LIVE;
        State result = instance.getState();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetState2() {
        System.out.println("getState");
        Cell instance = new Cell(2,3);
        State expResult = State.DEAD;
        State result = instance.getState();
        assertEquals(expResult, result);

    }

    /**
     * Test of setState method, of class Cell.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        State state = State.LIVE;
        Cell instance = new Cell(2,3);
        assertEquals(State.LIVE, instance.getState());

    }

    /**
     * Test of hashCode method, of class Cell.
     */

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Cell instance = new Cell(2,3);
        int expResult = 1026;
        int result = instance.hashCode();
        assertEquals(expResult,result);

    }

    /**
     * Test of equals method, of class Cell.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals");
        Object obj = null;
        Cell instance = new Cell(2,3,State.LIVE);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }

     /**
     * Test of equals method, of class Cell.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object obj = this;
        Cell instance = new Cell(2,3,State.LIVE);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }


    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object obj = new Object();
        Cell instance = new Cell(2,3,State.LIVE);
        boolean expResult=true; //false
        if(getClass()!=obj.getClass()){
           expResult= false;//true
        }

        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }
   
    /**
     * Test of createCopy method, of class Cell.
     */
    @Test
    public void testCreateCopy() {
        System.out.println("createCopy");
        Cell instance = new Cell(2,3,State.DEAD);
        Cell result = instance.createCopy();
        assertEquals(instance, result);

    }

}