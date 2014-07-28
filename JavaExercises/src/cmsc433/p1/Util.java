
package cmsc433.p1;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The Class Util. Except where noted, using these methods is optional.
 */
public class Util
{

    /**
     * Write an http header to the output stream, with the supplied status code and mime type.
     * 
     * For example a call to generateHttpHeader(os, "text/html", ServletException.HTTP_OK) will write the following two
     * lines to the OutputStream.
     * 
     * <pre>
     * HTTP/1.0 200
     * Content-Type: text/html
     * </pre>
     * 
     * followed by a blank line.
     * 
     * @param os
     *            - output stream to which write the http header
     * @param mimeType
     *            - the mime type
     * @param statusCode
     *            the status code
     */
    public static void generateHTTPHeader(OutputStream os, String mimeType, int statusCode)
    {

        if (os != null && mimeType != null)
        {
            PrintWriter out = new PrintWriter(os);

            out.println("HTTP/1.0 " + statusCode);
            out.println("Content-Type: " + mimeType);
            out.println("");
            out.flush();
        }
    }

    /**
     * Write complete text/plain response to output stream, with the supplied status code and text message, then close
     * the output stream. For example, a call to generatePlainTextResponse(os, 200, "foobar") would write the following
     * lines to the output stream
     * 
     * <pre>
     * HTTP/1.0 200
     * Content-Type: text/plain
     * 
     * foobar
     * </pre>
     * 
     * @param os
     *            output stream to which write the http header
     * @param statusCode
     *            the status code
     * @param msg
     *            the contents of the plain text message,
     */

    public static void generatePlainTextResponse(OutputStream os, int statusCode, String msg)
    {

        if (os != null && msg != null)
        {
            PrintWriter out = new PrintWriter(os);

            generateHTTPHeader(os, "text/plain", statusCode);

            out.println(msg);
            out.println("");
            out.flush();
        }
    }

    /**
     * Write complete text/plain response to output stream, with a status code and response body taken from the supplied
     * ServletException. The message from the exception should be used both following the status code in the HTTP header
     * and in the body of the response. For example, generateErrorPage(os, new ServletException("Some error",
     * ServletException.HTTP_NOT_FOUND))
     * 
     * <pre>
     * HTTP/1.0 404 Some error
     * Content-Type: text/plain
     * 
     * Some error
     * </pre>
     * 
     * @param os
     *            output stream to which write the http header
     * @param e
     *            the servlet exception
     */

    public static void generateErrorPage(OutputStream os, ServletException e)
    {

        if (os != null && e != null)
        {
            PrintWriter out = new PrintWriter(os);

            out.println("HTTP/1.0 " + e.getStatusCode() + " " + e.getMessage());
            out.println("Content-Type: text/plain");
            out.println("");
            out.println(e.getMessage());
            out.println("");
            out.flush();
        }
    }

    /**
     * Close anything that is closeable, ignoring any IOExceptions. The method should check to see if the parameter is
     * null, and take no action if it is null.
     * 
     * This method is useful since the standard close method is defined as throwing an IOException. Since InputStreams
     * and OutputStreams are typically closed in finally blocks, this avoids having to put try-catch blocks in finally
     * blocks.
     * 
     * @param thingToClose
     *            the thing to close
     */
    public static void closeIt(Closeable thingToClose)
    {
        if (thingToClose != null)
        {
            try
            {
                thingToClose.close();
            }
            catch (IOException e)
            {
                ; // pass
            }
        }
    }

    /**
     * Close a Socket, ignoring any IOExceptions. The method should check to see if the parameter is null, and take no
     * action if it is null.
     * 
     * This method is useful since the standard close method is defined as throwing an IOException. Since Sockets are
     * typically closed in finally blocks, this avoids having to put try-catch blocks in finally blocks.
     * 
     * @param socket
     *            the thing to close
     */

    public static void closeIt(Socket socket)
    {

        if (socket != null)
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                ; // pass
            }
        }
    }

}
