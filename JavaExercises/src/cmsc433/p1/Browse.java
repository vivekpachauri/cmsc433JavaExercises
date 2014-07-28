
package cmsc433.p1;

import java.io.File;
import java.io.OutputStream;

/**
 * This server is used to read a file from the local file system and send it in response to a servlet request.
 */
public class Browse implements Servlet
{

    /**
     * The doGet method performs the following steps.
     * 
     * <ul>
     * 
     * <li>Pass the <code>path</code> argument to the getFile method to get a File denoting the file to be sent in
     * response.
     * 
     * <li>Determine the mimetype of the file using the FileNameMap returned by the
     * {@link java.net.URLConnection#getFileNameMap}method.
     * 
     * <li>Generate a HTTP header using the {@link cmsc433.p1.Util#generateHTTPHeader}method.
     * 
     * <li>Open the file and copy all of the "bytes" contained in the file to the output stream.
     * 
     * <li>Close the file.
     * 
     * </ul>
     * 
     * @param path
     *            the path
     * @param options
     *            the options
     * @param os
     *            the os
     * 
     * @throws ServletException
     *             the servlet exception if file cannot be read.
     */
    public void doGet(String path, String options, OutputStream os) throws ServletException, ShutdownException
    {

    }

    /**
     * Given a path to a file that is relative to the web directory, constructs a File object for that file, verifies
     * that the file is readble and returns the File object.
     * 
     * Ignoring a lot of the errors checks the method has to do, it could just call new File( new File("web"),
     * relativePathToFile). However, it must also check:
     * <ul>
     * <li>that the canonical path for web directory is a prefix of the canonical path for the returned file (this
     * prevents someone from requesting /Browse/../src/java/cmsc433/p1/WebServer.java and getting the source of your web
     * server in response). If the path does not name a file contained within (at or below) the "./web" directory, the
     * servlet should throw a Servet Exception with a ServletException.HTTP_FORBIDDEN status code.
     * <li>If the file is not readable, or any IOException occurs, the servlet should throw a Servet Exception with a
     * ServletException.HTTP_NOT_FOUND status code.
     * 
     * @param relativePathToFile
     *            relative path to the file that is to be browsed
     * 
     * @return File the File that names the file to be browsed
     * 
     * @throws ServletException
     *             if something goes wrong
     */

    protected File getFile(String relativePathToFile) throws ServletException
    {

        throw new UnsupportedOperationException("not implemented yet");
    }
}
