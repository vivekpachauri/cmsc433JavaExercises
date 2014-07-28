
package cmsc433.p1;

import java.io.OutputStream;

/**
 * This servlet is invoked to shutdown the web server.
 */
public class Quit implements Servlet
{

    /**
     * The servlet is invoked to shutdown the web server.
     * 
     * @param path
     *            the path
     * @param options
     *            the options
     * @param out
     *            the out
     * 
     * @throws ShutdownException
     *             always
     * @throws ServletException
     *             the servlet exception
     */
    public void doGet(String path, String options, OutputStream out) throws ServletException, ShutdownException
    {
        throw new ShutdownException();
    }

}
