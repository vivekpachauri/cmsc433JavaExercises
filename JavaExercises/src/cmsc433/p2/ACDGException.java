package cmsc433.p2;

/**
 * The Class ACDGException. Provided.
 */
public class ACDGException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new ACDG exception.
	 */
	public ACDGException () {}
	
	/**
	 * Instantiates a new ACDG exception.
	 * 
	 * @param message Provides supplementary information about the ACDGException.
	 */
	public ACDGException (String message) {
		super(message);
	}
}
