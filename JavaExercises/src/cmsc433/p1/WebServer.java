
package cmsc433.p1;

import java.io.IOException;

public class WebServer
{

    private static Integer port;
    /*
     * Shutdown webserver in 20 minutes; 
     */
    static
    {
        countdownToShutdown(20);
    }

    /**
     * Countdown to shutdown.
     * 
     * @param minutes
     *            the minutes
     */
    private static void countdownToShutdown(final int minutes)
    {

        (new Thread()
        {

            public void run()
            {

                try
                {
                    Thread.sleep(1000 * 60 * minutes);
                    System.out.println("Web server shutting down after 20 minute timeout");
                    System.exit(1);
                }
                catch (InterruptedException e)
                {
                }
            }
        }).start();
    }

    /**
     * The main method constructs a WebServer and runs it. It parses the first command line argument as an integer and
     * runs the web server on that port. If you might be running the web server for testing purposes on a machine where
     * other students will also be testing their project, use the port derived from your account number so as to not
     * have collisions with other students trying to run web servers.
     * 
     * @param args
     *            - the first entry is the string representation of the port on which to run the web server.
     * 
     * @throws Exception
     *             if the web server cannot be started or if the port on which to run cannot be determined.
     */
    public static void main(String args[]) throws Exception
    {

        if (args.length > 0)
        {
            port = Integer.parseInt(args[0]);
            System.out.println("Listening on port " + port);
            new WebServer().runWebServer(port);
        }
    }

    /**
     * Run a web server on the supplied port.
     * 
     * <p>
     * The method should perform the following steps for each accepted socket connection.
     * <ul>
     * <li>Get the input and output streams from the Socket connection.
     * <li>Construct a BufferedReader from the input stream.
     * <lI>Read the first line of the HTTP request from the BufferedReader.
     * 
     * <li>Decompose the HTTP request into three components: the servlet descriptor, the path and the options. The URL
     * contains the following parts:
     * <ol>
     * <li>A / character, followed by the servlet descriptor (a sequence of characters not containing a space, a / or a
     * ?)
     * <li>optionally, a / character, followed by the path (a sequence of characters not containing a space, or a ?)
     * <li>optionally, a question mark, following by the options (a sequence of characters not containing a space)
     * </ol>
     * <p>
     * The following table shows some example URL's, and their decomposition into servlet descriptors, paths and
     * options. Note that the path and option are never null; they should be empty if they are not present.
     * <p>
     * <table>
     * <tr>
     * <th>URL
     * <th>servlet name
     * <th>path
     * <th>options
     * <tr>
     * <td>/abc/def
     * <td>abc
     * <td>def
     * <td>
     * <tr>
     * <td>/abc?d+f
     * <td>abc
     * <td>
     * <td>d+f
     * <tr>
     * <td>/abc/def?x+z
     * <td>abc
     * <td>def
     * <td>x+z
     * </table>
     * 
     * <li>Ask the servlet factory for the servlet corresponding to the servlet descriptor.
     * 
     * <li>invoke the doGet method of the servlet, as described in the Servlet interface, passing the path and options
     * derived from the URL and the output stream for the socket connection.
     * 
     * <li>Close the socket.
     * 
     * </ul>
     * 
     * <p>
     * If a ServletException is thrown by any of the methods called, the server should call
     * {@link cmsc433.p1.Util#generateErrorPage} to generate an error response. The Webserver should not shutdown
     * because a ServletException is thrown.
     * 
     * <p>
     * If the servlet throws a ShutdownException, then no more requests should be processed and the server socket should
     * be closed.
     * 
     * @param port
     *            - port on which to create the ServerSocket
     * 
     * @throws IOException
     *             - if the servlet socket cannot be opened or closed.
     */

    public void runWebServer(int port) throws IOException
    {

        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * <li>This method extracts the URL from the first line of the HTTP GET request. The URL is the portion of the first
     * line of the request between the GET and HTTP/1.x blocks with remaining white space characters removed.
     * 
     * @param request
     *            the request
     * 
     * @return the string
     * 
     * @throws ServletException
     *             the servlet exception
     */

    public String findRequestURL(String request) throws ServletException
    {

        throw new UnsupportedOperationException("not implemented yet");
    }
}
