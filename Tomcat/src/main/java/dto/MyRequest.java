package dto;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public class MyRequest {

    private String url;
    private String method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public MyRequest(InputStream inputStream) throws IOException{
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];

        int len = 0 ;
        if ((len =  inputStream.read(httpRequestBytes)) > 0){
            httpRequest = new String(httpRequestBytes, 0 ,len);//把协议转换为string
        }

        /**
         * 一个典型的http协议
         *
         *GET /home/xman/data/tipspluslist?indextype=manht&_req_seqid=0x82203fe1000c4250&asyn=1&t=1624689601933&sid=34099_31660_34133_34072_33607_34106_34135_26350 HTTP/1.1
         Host: www.baidu.com
         Connection: keep-alive
         sec-ch-ua: " Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91"
         Accept: text/plain; q=0.01
        X-Requested-With: XMLHttpRequest
        sec-ch-ua-mobile: ?0
        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36
        Sec-Fetch-Site: same-origin
        Sec-Fetch-Mode: cors
        Sec-Fetch-Dest: empty
        Referer: https://www.baidu.com/
        Accept-Encoding: gzip, deflate, br
        Accept-Language: zh-CN,zh;q=0.9
        Cookie: BIDUPSID=3D7
         *
         */

        // GET /home/xman/data/tipspluslist?indextype=manht&_req_seqid=0x82203fe1000c4250&asyn=1&t=1624689601933&sid=34099_31660_34133_34072_33607_34106_34135_26350 HTTP/1.1
        String httpHead = httpRequest.split("\n")[0];

        // method : GET
        // url : /home/xman/data/tipspluslist?indextype=manht&_req_seqid=0x82203fe1000c4250&asyn=1&t=1624689601933&sid=34099_31660_34133_34072_33607_34106_34135_26350
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public static void main(String[] args) {

        String  httpRequest = "GET /home/xman/data/tipspluslist?indextype=manht&_req_seqid=0x82203fe1000c4250&asyn=1&t=1624689601933&sid=34099_31660_34133_34072_33607_34106_34135_26350 HTTP/1.1\n" +
                "         Host: www.baidu.com\n" +
                "         Connection: keep-alive\n" +
                "         sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"\n" +
                "         Accept: text/plain; q=0.01\n" +
                "        X-Requested-With: XMLHttpRequest\n" +
                "        sec-ch-ua-mobile: ?0\n" +
                "        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36\n" +
                "        Sec-Fetch-Site: same-origin\n" +
                "        Sec-Fetch-Mode: cors\n" +
                "        Sec-Fetch-Dest: empty\n" +
                "        Referer: https://www.baidu.com/\n" +
                "        Accept-Encoding: gzip, deflate, br\n" +
                "        Accept-Language: zh-CN,zh;q=0.9\n" +
                "        Cookie: BIDUPSID=3D7";

        // GET /home/xman/data/tipspluslist?indextype=manht&_req_seqid=0x82203fe1000c4250&asyn=1&t=1624689601933&sid=34099_31660_34133_34072_33607_34106_34135_26350 HTTP/1.1
        String httpHead = httpRequest.split("\n")[0];

        // 补充一个小的知识点： \s 可以匹配空格
        /**
         * 详解 "\\s+"
         正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]

         \f -> 匹配一个换页
         \n -> 匹配一个换行符
         \r -> 匹配一个回车符
         \t -> 匹配一个制表符
         \v -> 匹配一个垂直制表符
         而“\s+”则表示匹配任意多个上面的字符。另因为反斜杠在Java里是转义字符，所以在Java里，我们要这么用“\\s+”.
         */
        String url = httpHead.split("\\s")[1];
        String method = httpHead.split("\\s")[0];
        System.out.println("method : "+ method);
        System.out.println("url : "+ url);
    }
}
