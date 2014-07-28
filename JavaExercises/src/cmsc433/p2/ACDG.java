package cmsc433.p2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jdom.JDOMException;

/**
 * The Class ACDG.
 */
public class ACDG {

    private MyNode top;
    private MyNode bottom;
    private Constraints contraints;
    private MyGraph graph;
    private List<ACDG> configList;
	/**
	 * Instantiates a new ACDG from a file. Checks that file is valid Checks
	 * that graph is valid (runs TopChecker, BottomChecker, DagChecker, and
	 * ArityChecker).
	 * 
	 * @param fileName
	 *            the file containing the ACDG
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws JDOMException
	 *             a JDOM exception indicates an invalid ACDG file
	 * @throws ACDGException
	 *             an ACDG exception indicates an invalid ACDG (graph)
	 */
    public ACDG(String fileName) throws IOException, JDOMException, ACDGException
    {
        ACDGReader reader = new ACDGReader(fileName);
        this.top = reader.getTop();
        this.bottom = reader.getBottom();
        this.contraints = reader.getConstraints();
        MyGraph graph = new MyGraph();
        List<MyEdge> edges = reader.getEdges();
        Set<MyNode> nodes = reader.getNodes();
        //need to create nodes before i create the edges !!DUH!!
        if (nodes != null)
        {
            for (MyNode node : nodes)
            {
                graph.addNode(node);
            }
        }
        
        if (edges != null)
        {
            for (MyEdge edge : edges)
            {
                graph.addEdge(edge);
            }
        }
        this.graph = graph;
        /* do validation tests */
        TopChecker topChecker = new TopChecker(this);
        topChecker.doCheck();
        if ( topChecker.isOk() == false)
        {
            throw new ACDGException();
        }
        BottomChecker bottomChecker = new BottomChecker(this);
        bottomChecker.doCheck();
        if ( bottomChecker.isOk() == false )
        {
            throw new ACDGException();
        }
        ArityChecker arityChecker = new ArityChecker(this);
        arityChecker.doCheck();
        if ( arityChecker.isOk() == false )
        {
            throw new ACDGException();
        }
        DagChecker dagChecker = new DagChecker(this);
        dagChecker.doCheck();
        if ( dagChecker.isOk() == false )
        {
            throw new ACDGException();
        }
        this.configList = new ArrayList<ACDG>();
    }

	/**
	 * Partially instantiates a new ACDG (for building configuration sub
	 * graphs). Assumes parameters are valid ACDG components.
	 * 
	 * @param top
	 *            the top
	 * @param bottom
	 *            the bottom
	 * @param constraints
	 *            the constraints
	 * @param graphRep
	 *            the graph rep
	 */
	public ACDG(MyNode top, MyNode bottom, Constraints constraints, MyGraph graphRep) {
	    this.top = top;
	    this.bottom = bottom;
	    this.contraints = constraints;
	    this.graph = graphRep;
	}

	
	/**
	 * Gets the top MyNode.
	 * 
	 * @return the top
	 */
	public MyNode getTop() {
	    return this.top;
	}

	/**
	 * Gets the bottom MyNode.
	 * 
	 * @return the bottom MyNode.
	 */
	public MyNode getBottom() {
	    return this.bottom;
	}

	/**
	 * Gets the set of MyNodes in the ACDG
	 * 
	 * @return the node set
	 */
	public Set<MyNode> getNodeSet() {
	    return this.graph.getNodeSet();
	}

	/**
	 * Gets the set of MyEdges in the ACDG.
	 * 
	 * @return the edge set
	 */
	public Set<MyEdge> getEdgeSet() {
	    return this.graph.getEdgeSet();
	}

	/**
	 * Gets the MyGraph.
	 * 
	 * @return the graph
	 */
	public MyGraph getGraph() {
	    return this.graph;
	}

	/**
	 * Gets the constraints.
	 * 
	 * @return the constraints
	 */
	public Constraints getConstraints() {
	    return this.contraints;
	}

	/**
	 * Generate the configuration subgraph ACDGs. Assumes overall ACDG has been
	 * checked for validity
	 * 
	 */
	public void genConfigs() {
	    /*
	     * okay so this is one of the last two pieces of puzzle to solve
	     */
	    /*
	     * what I can think of is that I have to iterate over the version list
	     * and for every multiple choices I can find I'll have to create a new ACDG
	     */
	    /* using GenConfigs object */
	    
	    /* instantiate the object and cause it to visit this acdg */
	    GenConfigs genConfigs = new GenConfigs(this);
	    
	    genConfigs.doCheck();

	    if ( genConfigs.isOk() == true )
	    {
	        this.configList = genConfigs.getConfigs();
	    }
	}

	/**
	 * Gets the configuration subgraph ACDGs. Assumes that genConfigs() has
	 * already been invoked.
	 * 
	 * @return the configs
	 */
	public List<ACDG> getConfigs() {
	    /* need to return a list so might as well create a private member */
	    return this.configList;
	}

	/**
	 * Uses ACDGDotOutputVisitor to write the DOT-formatted ACDG to standard out.
	 */
	public void exportGraph() {
	    /* acdg output visitor takes an ACDG object therefore I can just invoke constructor
	     * and then call the do check method, however I cannot do the same for
	     * ConOp
	     */
	    ACDGDotOutputVisitor visitor = new ACDGDotOutputVisitor(this);
	    visitor.doCheck();
	    
	    /* 
	     * for ConOp visitor I have to iterate over all the individual ConOp in the
	     * constraint object and set it in the visitor and then call the do check one by
	     * one therefore this visiting looks different than ACDG visiting
	     */
	    ConOpDotOutputVisitor conOpVisitor = new ConOpDotOutputVisitor();
	    /* visit all the constraints one by one */
	    for ( ConOp op : this.contraints.getConstraints() )
	    {
	        conOpVisitor.setConstraint(op);
	        conOpVisitor.doCheck();
	    }
	}

	public static void main(String[] args) throws JDOMException {
		try {
			String fileName = null;
			if (args.length >= 1) {
				fileName = args[0];
			} else
				throw new JDOMException("file name is missing");

			// Build ACDG
			ACDG acdg = new ACDG(fileName);

			// View ACDG
			acdg.exportGraph();

			// Generate Configurations
			acdg.genConfigs();

			// Output configurations as graphs
			for (ACDG cdg : acdg.getConfigs()) {
				cdg.exportGraph();
			}
			System.out.println("");

			// Output configurations in simplified format

			int num = 0;
			for (ACDG cdg : acdg.getConfigs()) {
				num++;
				String tmp = "[";
				for (MyNode n : cdg.getGraph().getNodeSet()) {
					if (n.getVersions().size() == 1) {
						tmp += n.getName() + ":" + n.getVersions().get(0) + ",";
					}
				}
				tmp = tmp.substring(0, tmp.length() - 1);
				tmp += "]";
				System.out.println(tmp);
			}
			System.out.println("Number of configs is " + num);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}