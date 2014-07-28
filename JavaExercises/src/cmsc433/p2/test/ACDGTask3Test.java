package cmsc433.p2.test;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.jdom.JDOMException;
import org.junit.Assert;
import org.junit.Test;

import cmsc433.p2.ACDG;
import cmsc433.p2.ACDGException;
import cmsc433.p2.ACDGVisitor;
import cmsc433.p2.ArityChecker;
import cmsc433.p2.ComponentNode;
import cmsc433.p2.Constraints;
import cmsc433.p2.MyEdge;
import cmsc433.p2.MyGraph;
import cmsc433.p2.MyNode;
import cmsc433.p2.RelationAndNode;
import cmsc433.p2.RelationXorNode;

public class ACDGTask3Test {
	private final int IO=0, JDOM=1, ACDG=2, SUCC=3;
	//TopCheck
	@Test
	public void testChecker1_1(){
		testFileSucceed("succ_checker1.xml");
	}
	@Test
	public void testChecker1_2(){
		testFileFail("fail_checker1.xml");
	}
	
	//BottomCheck
	@Test
	public void testChecker2_1(){
		testFileSucceed("succ_checker2.xml");
	}
	@Test
	public void testChecker2_2(){
		testFileFail("fail_checker2.xml");		
	}
	
	//ArityCheck
	@Test
	public void testChecker3_1(){
		//Code should throw ACDGException when a component node is a parent of 2 edges
		testFileSucceed("succ_checker3_1.xml");
	}
	@Test
	public void testChecker3_2(){
		testFileFail("fail_checker3_1.xml");
	}
	@Test
	public void testChecker3_3(){
		//Code should throw ACDGException when a component node is a child of 2 edges
		testFileSucceed("succ_checker3_2.xml");
	}	
	@Test
	public void testChecker3_4(){
		testFileFail("fail_checker3_2.xml");
	}
	@Test
	public void testChecker3_5(){
		//Code should throw ACDGException when a relation node is not a parent of any edge
		boolean isOk1 = checkArity3("and");
		boolean isOk2 = checkArity3("xor");

		assertTrue("Doesn't fail when a RelationAndNode is not a parent of any edge",!isOk1); 
		assertTrue("Doesn't fail when a RelationXorNode is not a parent of any edge",!isOk2); 
	}
	@Test
	public void testChecker3_6(){
		//Code should throw ACDGException when a relation node is not a child of any edge
		testFileSucceed("succ_checker3_4.xml");
	}
	@Test
	public void testChecker3_7(){
		testFileFail("fail_checker3_4.xml");
	}

	@Test
	public void testChecker4_1(){
		testFileSucceed("succ_checker4.xml");
	}
	@Test
	public void testChecker4_2(){
		testFileFail("fail_checker4.xml");	
	}
	
	//private methods
	private boolean checkArity3(String r) {
		MyNode top = new ComponentNode("TOP");
		MyNode bot = new ComponentNode("BOT");
		MyNode node1 = new ComponentNode("1");
		MyNode rel;
		if(r.equals("and"))
			rel = new RelationAndNode("AND1");
		else
			rel = new RelationXorNode("XOR1");
		
		MyEdge e = new MyEdge(top,rel);
		MyEdge e2 = new MyEdge(node1,bot);

		MyGraph mg = new MyGraph();

		mg.addNode(top);
		mg.addNode(bot);
		mg.addNode(node1);
		mg.addNode(rel);
		mg.addEdge(e);
		mg.addEdge(e2);
		
		ACDG a = new ACDG(top,bot,new Constraints(),mg);
		ACDGVisitor ac = new ArityChecker(a);
		ac.doCheck();
		
		return ac.isOk();
	}

	private void testFileFail(String file){
		try {
			ACDG a=new ACDG("C:\\programming_workspace\\java\\testfiles\\"+file);
			Assert.fail("Should fail file "+file);
		} catch (IOException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		} catch (JDOMException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		} catch (ACDGException e) {
			assertTrue(true);
		}	
	}
	
	private void testFileSucceed(String file){
		try {
			ACDG a=new ACDG("C:\\programming_workspace\\java\\testfiles\\"+file);
		} catch (IOException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		} catch (JDOMException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		} catch (ACDGException e) {
			Assert.fail("Cannot create ACDG from file: " + file + e.getMessage());
		}	
	}
}
