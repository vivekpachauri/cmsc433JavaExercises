package cmsc433.p2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.jdom.JDOMException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmsc433.p2.ACDG;
import cmsc433.p2.ACDGException;

public class ExportConfigsTest {

	private static ACDG [] acdg;
	
	private static int NUMBER_TESTS = 4; 
	private static int[] expectedConfigs = {12, 13, 30, 3};

	@BeforeClass
	public static void setBefore() throws IOException, JDOMException, ACDGException {
		acdg = new ACDG[NUMBER_TESTS];
		for(int i = 0; i < acdg.length; i++)
			acdg[i] = new ACDG("testfiles/complex" + i + ".xml");
	}
		
	//Configs are tested separately to have more details of test result
	@Test
	public void testConfig0Size() throws Exception {
		
		acdg[0].genConfigs();
		List<ACDG> configs = acdg[0].getConfigs();
		assertEquals(expectedConfigs[0], 
				configs.size());
	
	}
	
	@Test
	public void testConfig1Size() throws Exception {
		
		acdg[1].genConfigs();
		List<ACDG> configs = acdg[1].getConfigs();
		assertEquals(expectedConfigs[1], 
				configs.size());
	
	}
	
	@Test
	public void testConfig2Size() throws Exception {
		
		acdg[2].genConfigs();
		List<ACDG> configs = acdg[2].getConfigs();
		assertEquals(expectedConfigs[2], 
				configs.size());
	
	}
	
	@Test
	public void testConfig3Size() throws Exception {
		
		acdg[3].genConfigs();
		List<ACDG> configs = acdg[3].getConfigs();
		assertEquals(expectedConfigs[3], 
				configs.size());
	
	}
		
	private ByteArrayOutputStream baos;
    private PrintStream systemOut;

    @Before
	public void setUp()
    {
		systemOut = System.out;
		baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
    }

    @After
	public void tearDown()
    {
    	System.setOut(systemOut);
    }

    
	@Test
	public void testExportGraph0() throws Exception {
		
		ACDG acdgl = new ACDG("testfiles/complex0.xml");
		acdgl.genConfigs();
		for (ACDG cdg : acdgl.getConfigs())
			cdg.exportGraph();
		String output = baos.toString();
		output = output.replaceAll(" ", "");
		output = output.replaceAll("\"", "");
		output = output.replaceAll("\r\n", "");
		output = output.toLowerCase();
		
		BufferedReader input = new BufferedReader(new FileReader("testfiles/complex0-config.doto"));
		String temp;
		while((temp = input.readLine()) != null) {
			temp = temp.replaceAll(" ", "");
			temp = temp.replaceAll("\"", "");
			temp = temp.toLowerCase();
		    if (!output.contains(temp)) {
		    	System.setOut(systemOut);
		    	System.out.println(temp);
			    fail("Didn't find: "+temp);	
		    }
		}
		
		input.close();
	}
	
	@Test
	public void testExportGraph3() throws Exception {
		
		ACDG acdgl = new ACDG("testfiles/complex3.xml");
		acdgl.genConfigs();
		for (ACDG cdg : acdgl.getConfigs())
			cdg.exportGraph();
		String output = baos.toString();
		output = output.replaceAll(" ", "");
		output = output.replaceAll("\"", "");
		output = output.replaceAll("\r\n", "");
		output = output.toLowerCase();
		
		BufferedReader input = new BufferedReader(new FileReader("testfiles/complex3-config.doto"));
		String temp;
		while((temp = input.readLine()) != null) {
			temp = temp.replaceAll(" ", "");
			temp = temp.replaceAll("\"", "");
			temp = temp.toLowerCase();
		    if (!output.contains(temp)) {
		    	System.setOut(systemOut);
		    	System.out.println(temp);
			    fail("Didn't find: "+temp);	
		    }
		}
		
		input.close();
	}
}