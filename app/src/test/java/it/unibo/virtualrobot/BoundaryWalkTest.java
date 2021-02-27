package it.unibo.virtualrobot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoundaryWalkTest {
    private BoundaryWalk appl;
    @Before
    public void setup() {
        System.out.println("System setup");
        appl = new BoundaryWalk();
    }
    @After
    public void terminate() {
        System.out.println("System terminated");
    }
    @Test
    public void testWalk() {
        for(int i=0; i<4; i++) {
            int numForward = 0;
            while(!appl.moveForward(100)) {
                System.out.println("Forward");
                numForward++;
            }
            assertTrue(numForward > 0);
            boolean res = appl.moveLeft(100);
            assertFalse(res);
            System.out.println("Left");
        }
    }
    @Test
    public void correctStartPosition1() {
        assertTrue(appl.moveBackward(50));
        assertFalse(appl.moveRight(150));
        assertTrue(appl.moveForward(50));
        assertFalse(appl.moveLeft(150));
    }
}
