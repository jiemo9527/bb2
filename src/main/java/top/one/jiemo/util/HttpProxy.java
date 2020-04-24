package top.one.jiemo.util;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.jsoup.nodes.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class HttpProxy {

    public String getParse(String urlFromDB) throws Exception {
        // 目标地址
        String targetUrl = "http://www.flvcd.com/parse.php?format=&kw="+urlFromDB;
        // 代理服务器
        String proxyHost = "58.218.92.167";
        int proxyPort = 3139;
        // http代理: Proxy.Type.HTTP, socks代理: Proxy.Type.SOCKS
        Proxy.Type proxyType = Proxy.Type.HTTP;
        // 代理验证
        String proxyUser = "17761715530";
        String proxyPwd = "553399lv";
        String m3u8_url=null;
        try {
            // 设置验证
            Authenticator.setDefault(new ProxyAuthenticator(proxyUser, proxyPwd));

            // 创建代理服务器
            InetSocketAddress addr = new InetSocketAddress(proxyHost, proxyPort);
            Proxy proxy = new Proxy(proxyType, addr);
            // 访问目标网页
            URL url = new URL(targetUrl);
            URLConnection conn = url.openConnection(proxy);
            conn.setRequestProperty("Accept","text/html, application/xhtml+xml, */*");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setConnectTimeout(0);

            // 读取返回数据
            InputStream in= conn.getInputStream();
            m3u8_url=IO2String(in).split("br>���ص�ַ��<a href=\"")[1].split("\" target=\"_blank\" class=\"link\" >")[0];
            if (m3u8_url.contains(".m3u8")){
                System.out.print("√");
            }else {
                System.out.print("×");
            }
            if (m3u8_url.trim().equals("")){
                m3u8_url="#";
            }
        } catch (Exception e) {
            System.out.println("解析错误："+e);;
        }
        return m3u8_url;
    }

    /**
     * 将输入流转换成字符串
     *
     * @param inStream
     * @return
     * @throws IOException
     */
    public static String IO2String(InputStream inStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inStream.read(buffer)) != -1) {
            result.write(buffer, 0, len);
        }
        String str = result.toString(StandardCharsets.UTF_8.name());
        return str;
    }
    //平台账号认证
    static class ProxyAuthenticator extends Authenticator {
        private String authUser, authPwd;

        public ProxyAuthenticator(String authUser, String authPwd) {
            this.authUser = authUser;
            this.authPwd = authPwd;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return (new PasswordAuthentication(authUser, authPwd.toCharArray()));
        }
    }
}
