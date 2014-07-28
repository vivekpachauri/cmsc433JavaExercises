
package cmsc433.p1;

/**
 * A factory for creating Servlet objects.
 */
public class ServletFactory
{

    private static final ServletFactory factory = new ServletFactory();
    
    private ServletFactory()
    {
    }
    /**
     * Implements the singleton pattern, returning the same instance of ServletFactor each time it is called.
     * 
     * @return ServletFactory
     */
    public static ServletFactory getInstance()
    {
        return factory;
    }

    /**
     * Given a servlet descriptor such as HelloWorld, it should return an instance of the HelloWorld Servlet. Give a
     * servlet descriptor such as Cache:GetDateAndTime it should return a GetDateAndTime servlet that has decorated with
     * a Cache servlet. You cannot hard code the set of servlet descriptors
     * 
     * <p>
     * Decorator servlets must take a servlet as an argument in their constructor. Non-decorator servlets should have a
     * no-arg constructor.
     * 
     * <p>
     * For any particular servlet descriptor, a unique instance should be returned. For example, all requests for a
     * Cache:GetDateAndTime servlet should return the same instance. Servlet instances, including nested Servlet
     * instances, are never shared (neither within a single servlet nor across two or more servlets).
     * 
     * @param name
     *            the servlet descriptor
     * 
     * @return instance of name Servlet
     * 
     * @throws ServletException
     *             the servlet exception
     */
    public Servlet getServlet(String name) throws ServletException
    {

        return buildServlet(name);
    }

    /**
     * Builds the servlet.
     * 
     * @param name
     *            the servlet descriptor
     * 
     * @return the servlet
     * 
     * @throws ServletException
     *             the servlet exception
     */
    private Servlet buildServlet(String name) throws ServletException
    {
        try
        {
            Object instance =  Class.forName(name).newInstance();
            if ( Servlet.class.isAssignableFrom(instance.getClass()) == true )
            {
                return (Servlet)instance;
            }
            else
            {
                throw new ServletException("Unable to find servlet by name - " + name, ServletException.HTTP_NOT_FOUND);
            }
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new ServletException("Unable to instantiate servlet by name - " + name, e, ServletException.HTTP_INTERNAL_SERVER_ERROR);
        }
    }

}
