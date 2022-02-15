package dto;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public class MyResponse {

    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void write(String context) throws IOException {


        StringBuilder httpResponse = new StringBuilder();
        httpResponse.append("HTTP/1.1 200 OK").append("\n")
                .append("Content-Type: text/html;charset=utf-8").append("\n")
                .append("\r\n")
                .append("<html><body>")
                .append(context)
                .append("</html></body>");

        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }


}
