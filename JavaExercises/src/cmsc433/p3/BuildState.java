package cmsc433.p3;

/**
 * The Enum BuildState. Provided.
 */
public enum BuildState {

	/** Components not yet assigned to a BuildClient. */
	New,

	/** Components assigned to a BuildClient, but not yet completed. */
	Pending,

	/** Components assigned to a BuildClient and completed. */
	Done
}
