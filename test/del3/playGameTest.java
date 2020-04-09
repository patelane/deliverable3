/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aneen
 */
public class playGameTest {
    
    public playGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class playGame.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        playGame.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of isHitorStand method, of class playgame.
     */
    @Test
    public void testgoodHit() {
        System.out.println("Player hits");
        String hit = "hit";
        boolean expResult = true;
        boolean result = playGame.isHitorStand(hit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
@Test
    public void testbadHit() {
        System.out.println("Player hits");
        String hit = "";
        boolean expResult = false;
        boolean result = playGame.isHitorStand(hit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    @Test
    public void testboundaryHit() {
        System.out.println("Player hits");
        String hit= "h";
        boolean expResult = false;
        boolean result = playGame.isHitorStand(hit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    @Test
    public void testgoodStand() {
        System.out.println("Player Stands");
        String stand = "stand";
        boolean expResult =true;
        boolean result = playGame.isHitorStand(stand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
     @Test
    public void testbadStand() {
        System.out.println("Player Stands");
        String hitter = "";
        boolean expResult = false;
        boolean result = playGame.isHitorStand(hitter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
     @Test
    public void testboundaryStand() {
        System.out.println("Player Stands");
        String stand = "s";
        boolean expResult = false;
        boolean result = playGame.isHitorStand(stand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of isyesorno method, of class playgame.
     */
    @Test
    public void testgoodyes() {
        System.out.println("Player wants to play again");
        String ans = "yes";
        boolean expResult = true;
        boolean result = playGame.isyesorno(ans);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testbadyes() {
        System.out.println("Player wants to play again");
        String ans= "";
        boolean expResult = false;
        boolean result = playGame.isyesorno(ans);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testboundaryyes() {
        System.out.println("Player wants to play again");
        String ans = "y";
        boolean expResult = false;
        boolean result = playGame.isyesorno(ans);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testgoodno() {
        System.out.println("Player doesn't want to play again");
        String ans= "no";
        boolean expResult = true;
        boolean result = playGame.isyesorno(ans);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testbadno() {
        System.out.println("Player doesn't want to play again");
        String answer = "";
        boolean expResult = false;
        boolean result = playGame.isyesorno(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testboundaryno() {
        System.out.println("Player doesn't want to play again");
        String ans = "n";
        boolean expResult = false;
        boolean result = playGame.isyesorno(ans);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
    
