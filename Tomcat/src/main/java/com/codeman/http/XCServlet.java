package com.codeman.http;

/**
 * @author hdgaadd
 * Created on 2022/04/27
 */
public abstract class XCServlet {

    public void service(XCRequest xcRequest, XCResponse xcResponse) throws Exception{
        if ("GET".equalsIgnoreCase(xcRequest.getMethod())) {
            doGet(xcRequest, xcResponse);
        } else {
            doPost(xcRequest, xcResponse);
        }
    }

    public abstract void doGet(XCRequest xcRequest, XCResponse xcResponse) throws Exception;

    public abstract void doPost(XCRequest xcRequest, XCResponse xcResponse) throws Exception;
}
