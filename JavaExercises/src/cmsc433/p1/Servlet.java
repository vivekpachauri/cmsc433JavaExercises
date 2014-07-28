
package cmsc433.p1;

import java.io.OutputStream;

/**
 * The interface for all servlets. There are two types of servlets: decorator servlets and concrete servlets.
 * 
 * <p>
 * Concrete servlets stand alone and don't need any other servlet to function. They must have a public, no-argument
 * constructor.
 * 
 * <p>
 * Decorator servlets use the decorator design pattern to modify the behavior of another servlet. They must have a
 * public constructor that takes a servlet as an argument.
 * 
 * <p>
 * Do not make <em>any</em> changes to this interface.
 */
public interface Servlet
{

    /**
     * The method by which is a servlet is asked to process an HTTP GET request.
     * 
     * <p>
     * For example, assume a browser issues the request
     * 
     * <pre>
     * GET /abc/def/ghi?x+y HTTP/1.0
     * </pre>
     * 
     * The web server would use abc to determine what servlet to use to process the request. Having determined the
     * servlet, it would pass "<code>def/ghi</code>" as the <code>path</code> to the servlet and "<code>x+y</code>" as
     * the <code>option</code> to the servlet.
     * 
     * @param path
     *            - the path component of the servlet request
     * @param options
     *            - the option component of the servlet request. The option component is what comes after a question
     *            mark.
     * @param out
     *            - the output stream to which the response should be written
     * 
     * @throws ServletException
     *             - if an error occurs in processing the request
     * @throws ShutdownException
     *             - if the servlets needs to instruct the entire webserver to be shut down.
     */
    public void doGet(String path, String options, OutputStream out) throws ServletException, ShutdownException;
}
