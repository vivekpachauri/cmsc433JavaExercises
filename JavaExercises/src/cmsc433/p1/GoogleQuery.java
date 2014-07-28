
package cmsc433.p1;

import java.io.OutputStream;

/**
 * Generates a query to Google, returns an HTTP redirect to the client to execute that query.
 */
public class GoogleQuery implements Servlet
{

    /**
     * The doGet method performs the following steps.
     * 
     * <ul>
     * 
     * <li>Generate the following URL text: <url>http://www.google.com/search?rls =en&q=OPTIONS&ie=UTF-8&oe=UTF-8</url>
     * where OPTIONS should be replaced with doGet()'s options string
     * 
     * <li>Output an HTTP redirect (code 302) on the given OutputStream, having form
     * 
     * <pre>
     * HTTP/1.0 302 Relocate status
     * Location: URL
     * Content-Type: text/plain
     * </pre>
     * 
     * where URL is the URL generated in the above step.
     * 
     * </ul>
     * 
     * @param path
     *            the path
     * @param options
     *            the options
     * @param out
     *            the OutputStream
     * 
     * @throws ServletException
     *             the servlet exception
     * @throws ShutdownException
     *             the shutdown exception
     */
    public void doGet(String path, String options, OutputStream out) throws ServletException, ShutdownException
    {

    }
}
