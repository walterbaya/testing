import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {

	
	@Test
	public void isTriangleEquilatero() {
		assertTrue(Demo.isTriangle(1, 1, 1));
	}
	
	@Test
	public void isTriangleIsosceles() {
		assertTrue(Demo.isTriangle(3, 2, 2));
	}
	
	
	@Test
	public void isTriangleRot0() {
		assertTrue(Demo.isTriangle(7, 5, 6));
	}
	
	@Test
	public void isTriangleRot1() {
		assertTrue(Demo.isTriangle(7, 6, 5));
	}
	
	@Test
	public void isTriangleRot2() {
		assertTrue(Demo.isTriangle(5, 6, 7));
	}

	@Test
	public void isNotTriangleNull() {
		assertFalse(Demo.isTriangle(0, 0, 0));
	}
	
	@Test
	public void isNotTriangleABEqualsC() {
		assertFalse(Demo.isTriangle(1, 1, 2));
	}
	
	@Test
	public void isNotTriangleACEqualsB() {
		assertFalse(Demo.isTriangle(1, 2, 1));
	}
	
	@Test
	public void isNotTriangleBCEqualsA() {
		assertFalse(Demo.isTriangle(2, 1, 1));
	}
	
	
	
	@Test
	public void isNotTriangleNegative0() {
		assertFalse(Demo.isTriangle(-5, 70, 50));
	}
	
	@Test
	public void isNotTriangleNegative1() {
		assertFalse(Demo.isTriangle(70,-5, 50));
	}
	
	@Test
	public void isNotTriangleNegative2() {
		assertFalse(Demo.isTriangle(70, 50, -5));
	}
	
	@Test
	public void isNotTriangleToSmallSide0() {
		assertFalse(Demo.isTriangle(5, 70, 40));
	}
	
	@Test
	public void isNotTriangleToSmallSide1() {
		assertFalse(Demo.isTriangle(70, 5, 40));
	}
	
	@Test
	public void isNotTriangleToSmallSide2() {
		assertFalse(Demo.isTriangle(5, 70, 40));
	}
	
	@Test
	public void isTriangleMain() {
		ByteArrayInputStream in = new ByteArrayInputStream("7\n6\n5\n".getBytes());
		System.setIn(in);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		String[] args = {};
		Demo.main(args); 
		
		String output = "Enter side 1: " + System.lineSeparator();
        output +=  "Enter side 2: " + System.lineSeparator();
        output +=  "Enter side 3: " + System.lineSeparator();
        output +=  "This is a triangle." + System.lineSeparator();
       
        assertEquals(output, out.toString());
	}
	
	@Test
	public void isNotTriangleMain() {
		ByteArrayInputStream in = new ByteArrayInputStream("70\n6\n5\n".getBytes());
		System.setIn(in);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		String[] args = {};
		Demo.main(args); 
		
		String output = "Enter side 1: "  + System.lineSeparator();
        output +=  "Enter side 2: "  + System.lineSeparator();
        output +=  "Enter side 3: "  + System.lineSeparator();
        output +=  "This is not a triangle."  + System.lineSeparator();
        
        assertEquals(output, out.toString());
	}
	
	
	
	

	
	
}
