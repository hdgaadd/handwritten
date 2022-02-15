package mapping;

import java.util.ArrayList;
import java.util.List;
/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();//封装了name、url、类引用

    static {
        servletMappingList.add(new ServletMapping("HelloWorldServlet","/HelloWorld","servlet.impl.HelloWorldServlet"));
        servletMappingList.add(new ServletMapping("StopTheWorldServlet","/StopTheWorld","servlet.impl.StopTheWorldServlet"));
    }
}
