package top.one.jiemo.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GetThirdParse {
    public static String httpGet(String url) throws IOException {
        //获取请求连接
        Connection con = Jsoup.connect(url);
        //请求头设置，特别是cookie设置
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko");
//        con.header("Cookie", cookie);
        Document doc=con.get();
        String m3u8_url = doc.getElementsByClass("link").attr("href");
        return m3u8_url;

    }
    public String getM3u8(String url){
        String m3u8_url =null;
        try {
             m3u8_url=GetThirdParse.httpGet(
                    "http://www.flvcd.com/parse.php?format=&kw="+url);
//            System.out.println(m3u8_url);
            if (m3u8_url.contains(".m3u8")){
                System.out.print("√");
            }else {
                System.out.print("×");
            }
            if (m3u8_url.trim().equals("")){
                m3u8_url="#";
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return m3u8_url;
    }
}
