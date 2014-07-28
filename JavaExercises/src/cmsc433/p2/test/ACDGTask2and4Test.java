package cmsc433.p2.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.jdom.JDOMException;
import org.junit.*;

import cmsc433.p2.ACDG;
import cmsc433.p2.ACDGException;
import cmsc433.p2.ConOp;


public class ACDGTask2and4Test {

	private static ACDG[] acdg;
	private static ACDG[] acdgr;
	private static List<List<ACDG>> acdgconfigs;
	private static int[] configsize={1,2,2};
	private static String[] tops={"TopTest1","A","T"},topvers={"vt1.1","v1","v1"};
	private static String[] bots={"BottomTest1","OS","OS"},botvers={"vb1.2","v4.1","v4.1"};
	private static final int NUMTESTS=3, CONFIGSCORE=6;

	@BeforeClass
	public static void setBefore() {
		acdg = new ACDG[NUMTESTS];
		acdgr = new ACDG[NUMTESTS];
		acdgconfigs = new ArrayList<>();
		for(int i=0;i<NUMTESTS;i++){
			try{
				acdg[i]=new ACDG("C:\\programming_workspace\\java\\testfiles\\simple"+i+".xml");
			} catch (IOException e) {
				Assert.fail("Cannot create ACDG from file simple1.xml"+e.getMessage());
			} catch (JDOMException e) {
				Assert.fail("Cannot create ACDG from file simple1.xml"+e.getMessage());
			} catch (ACDGException e) {
				Assert.fail("Cannot create ACDG from file simple1.xml"+e.getMessage());
			}

			try {
				acdgr[i]=new ACDG("C:\\programming_workspace\\java\\testfiles\\simple"+i+".xml");
			} catch (IOException e) {
				Assert.fail("Cannot create ACDG from file simple1.xml"+e.getClass());
			} catch (JDOMException e) {
				Assert.fail("Cannot create ACDG from file simple1.xml"+e.getClass());
			} catch (ACDGException e) {
				Assert.fail("Cannot create ACDG from file simple1.xml"+e.getClass());
			}
			try {
				List<ACDG> l = new ArrayList<ACDG>();
				for(int j=0;j<configsize[i];j++){
					ACDG b = new ACDG("C:\\programming_workspace\\java\\testfiles\\simple"+i+"_config"+j+".xml");
					l.add(b);
				}
				acdgconfigs.add(l);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (ACDGException e) {
				e.printStackTrace();
			}
		}
	}


	@Test
	public void testTop(){
		for(int i=0;i<NUMTESTS;i++){
			assertTrue(acdg[i].getTop().getName().equals(tops[i]));
			assertTrue(acdg[i].getTop().getVersions().contains(topvers[i]));
		}
	}

	@Test
	public void testBottom(){
		for(int i=0;i<NUMTESTS;i++){
			assertTrue(acdg[i].getBottom().getName().equals(bots[i]));
			assertTrue(acdg[i].getBottom().getVersions().contains(botvers[i]));
		}
	}

	@Test
	public void testNodes(){
		for(int i=0;i<NUMTESTS;i++){
			assertTrue(acdg[i].getNodeSet().equals(acdgr[i].getNodeSet()));
		}
	}

	@Test
	public void testEdges(){
		for(int i=0;i<NUMTESTS;i++){
			assertTrue(acdg[i].getEdgeSet().equals(acdgr[i].getEdgeSet()));
		}
	}

	@Test
	public void testConstraints(){
		int numcons=0,numfailed=0;
		for(int k=0;k<NUMTESTS;k++){
			Set<ConOp> cons=acdg[k].getConstraints().getConstraints();
			Set<ConOp> consr=acdgr[k].getConstraints().getConstraints();
			Object[] i1=cons.toArray();
			Object[] ir1=consr.toArray();

			for(int i=0;i<ir1.length;i++){
				ConOp c = (ConOp) ir1[i];
				ConOp c2 = null;
				boolean contains=false;
				for(int j=0;j<i1.length;j++){
					c2 = (ConOp) i1[j];
					if(c2.toString().trim().equals(c.toString().trim())){
						contains=true;
						break;
					}
				}
				numcons++;
				if(!contains){
					numfailed++;
				}
			}

		}
		System.out.println("GRADE"+(numcons-numfailed)+" out of "+numcons+"GRADE");

	}

	@Test
	public void testConfigs(){
		int totalscore=0;
		int numconfigs=0;
		//for each acdg example i
		for(int i=0;i<NUMTESTS;i++){
			acdg[i].genConfigs();
			int acdgscore=0;
			//for each correct configuration of i
			for(ACDG configr : acdgconfigs.get(i)){
				numconfigs++;
				int configscore=0;
				//check against each configuration produced by student, 
				//assign score out of CONFIGSCORE for partial credit
				//pick the one with highest score
				//if equal to CONFIGSCORE, test succeeds
				//else, assign partial to this config and continue with other ones
				for(ACDG config : acdg[i].getConfigs()){
					int temp=equalsACDG(config,configr);
					if(temp==CONFIGSCORE){
						configscore=temp;
						break;	//no need to look further
					}
					if(temp>configscore){
						configscore=temp;
					}
				}
				acdgscore+=configscore;
			}
			if(acdg[i].getConfigs().size()==acdgconfigs.get(i).size()){
				acdgscore++;
			}
			totalscore+=acdgscore;
		}
		System.out.println("GRADE"+totalscore+" out of "+(CONFIGSCORE*numconfigs+NUMTESTS)+"GRADE");

	}


	private int equalsACDG(ACDG a, ACDG ar) {
		int c=0;

		if(a.getNodeSet().equals(ar.getNodeSet()))
			c=c+2;
		if(a.getEdgeSet().equals(ar.getEdgeSet()))
			c=c+2;
		if(a.getTop().equals(ar.getTop()))
			c++;
		if(a.getBottom().equals(ar.getBottom()))
			c++;
		return c;
		

	}
	
}



