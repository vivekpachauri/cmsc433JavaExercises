
package cmsc433.p1;

/**
 * The Class ServletException.
 */
public class ServletException extends Exception
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant HTTP_OK. */
    public static final int HTTP_OK = 200;

    /** The Constant HTTP_BAD_REQUEST. */
    public static final int HTTP_BAD_REQUEST = 400;

    /** The Constant HTTP_FORBIDDEN. */
    public static final int HTTP_FORBIDDEN = 403;

    /** The Constant HTTP_NOT_FOUND. */
    public static final int HTTP_NOT_FOUND = 404;

    /** The Constant HTTP_INTERNAL_SERVER_ERROR. */
    public static final int HTTP_INTERNAL_SERVER_ERROR = 500;

    /** The status code. */
    private final int statusCode;

    /**
     * Instantiates a new servlet exception.
     * 
     * @param msg
     *            the msg
     * @param cause
     *            the cause
     * @param statusCode
     *            the status code
     */
    public ServletException(String msg, Exception cause, int statusCode)
    {

        super(msg, cause);
        this.statusCode = statusCode;
    }

    /**
     * Instantiates a new servlet exception.
     * 
     * @param msg
     *            the msg
     * @param statusCode
     *            the status code
     */
    public ServletException(String msg, int statusCode)
    {

        super(msg);
        this.statusCode = statusCode;
    }

    /**
     * Gets the status code.
     * 
     * @return the status code
     */
    public int getStatusCode()
    {

        return this.statusCode;
    }
}
