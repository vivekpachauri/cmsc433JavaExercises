
package cmsc433.p1;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Generate a plain text response. If the path is non-empty, generate "Hello " following by the value of the path.
 * Otherwise, if the options are non-empty, generate "Hello " following by the value of the options. Otherwise, generate
 * "Hello World"
 */
public class HelloWorld implements Servlet
{

    /* (non-Javadoc)
     * @see cmsc433.p1.Servlet#doGet(java.lang.String, java.lang.String, java.io.OutputStream)
     */
    public void doGet(String path, String options, OutputStream os) throws ServletException, ShutdownException
    {

        if (path == null || options == null || os == null)
        {
            throw new ServletException("Null parameters", ServletException.HTTP_INTERNAL_SERVER_ERROR);
        }
        String out = new String();
        Util.generateHTTPHeader(os, "text/plain", ServletException.HTTP_OK);

        if (path.length() > 0)
        {
            out += "Hello " + path;
        }
        else
            if (options.length() > 0)
            {
                out += "Hello " + options;
            }
            else
            {
                out += "Hello World\n";
            }
        try
        {
            os.write(out.getBytes());
            os.flush();
        }
        catch (IOException e)
        {
            throw new ServletException("Error writing to output stream", e, ServletException.HTTP_INTERNAL_SERVER_ERROR);
        }
    }
}
