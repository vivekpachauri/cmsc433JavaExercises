package cmsc433.p2.test;
import static org.junit.Assert.*;

import java.io.IOException;

import org.jdom.JDOMException;
import org.junit.*;

import cmsc433.p2.ACDG;
import cmsc433.p2.ACDGException;
import cmsc433.p2.ACDGReader;

public class ACDGTask1Test {

	@Test
	public void testBullet1(){
		testFileFail("lib/cmsc433/testFiles/p2/1_fail_missing_top.xml");
	}

	@Test
	public void testBullet2(){
		testFileFail("lib/cmsc433/testFiles/p2/2_fail_missing_bottom.xml");
	}

	@Test
	public void testBullet3(){
		testFileSucceed("lib/cmsc433/testFiles/p2/3_succeed_nocons.xml");
	}

	@Test
	public void testBullet4(){
		String file="lib/cmsc433/testFiles/p2/4_succeed_noedges.xml";
		try {
			ACDGReader reader = new ACDGReader(file);
		} catch (IOException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		} catch (JDOMException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		}
	}

	@Test
	public void testBullet5(){
		testFileFail("5_fail_one_node.xml");
	}

	@Test
	public void testBullet6(){
		testFileFail("lib/cmsc433/testFiles/p2/6.1_fail_missing_component_name.xml");
		testFileFail("lib/cmsc433/testFiles/p2/6.1_fail_missing_reland_name.xml");
		testFileFail("lib/cmsc433/testFiles/p2/6.1_fail_missing_relxor_name.xml");
		testFileFail("lib/cmsc433/testFiles/p2/6.2_fail_missing_type.xml");
	}

	@Test
	public void testBullet7(){
		testFileFail("7_fail_missing_version.xml");
	}

	@Test
	public void testBullet8(){
		testFileFail("8_fail_relation_version.xml");
	}

	@Test
	public void testBullet9(){
		testFileFail("9_fail_bad_type.xml");
	}

	@Test
	public void testBullet10(){
		testFileFail("./lib/cmsc433/testFiles/p2/10_fail_duplicate_name.xml");
	}

	@Test
	public void testBullet11(){
		testFileFail("lib/cmsc433/testFiles/p2/11_fail_bad_constraint_type1.xml");
		testFileFail("lib/cmsc433/testFiles/p2/11_fail_bad_constraint_type2.xml");
		testFileFail("lib/cmsc433/testFiles/p2/11_fail_constraint_bad_version.xml");
	}

	@Test
	public void testBullet12(){
		testFileFail("12_fail_constraint_bad_name.xml");
	}
		

	@Test
	public void testBullet13(){
		testFileFail("13_fail_constraint_bad_version_name.xml");
	}

	@Test
	public void testBullet14(){
		testFileFail("14.1_fail_edge_parent1.xml");
		testFileFail("14.1_fail_edge_parent2.xml");
		testFileFail("14.1_fail_edge_parent3.xml");
		testFileFail("14.2_fail_edge_child1.xml");
		testFileFail("14.2_fail_edge_child2.xml");
		testFileFail("14.2_fail_edge_child3.xml");
	}

	@Test
	public void testBullet15(){
		testFileFail("15_fail_edge_two_components.xml");	
	}

	private void testFileFail(String file){
		try {
			ACDG a=new ACDG("C:\\programming_workspace\\java\\testfiles\\"+file);
			Assert.fail("Should fail file "+file);
		} catch (IOException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());			
		} catch (JDOMException e) {
			assertTrue(true);
		} catch (ACDGException e) {
			assertTrue(true);
		}	
	}

	private void testFileSucceed(String file){
		try {
			ACDG a=new ACDG("C:\\programming_workspace\\java\\testfiles\\"+file);
			assertTrue(true);
		} catch (IOException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		} catch (JDOMException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		} catch (ACDGException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		}	
	}
}
