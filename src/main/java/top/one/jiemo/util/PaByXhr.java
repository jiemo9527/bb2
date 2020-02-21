package top.one.jiemo.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaByXhr {

    List<String> dh_title_list = new ArrayList<>();
    List<String> dh_img_list = new ArrayList<>();
    List<String> dh_url_list = new ArrayList<>();
    List<String> dh_click_list = new ArrayList<>();
    List<String> yx_title_list = new ArrayList<>();
    List<String> yx_img_list = new ArrayList<>();
    List<String> yx_url_list = new ArrayList<>();
    List<String> yx_click_list = new ArrayList<>();
    List<String> rank2_title_list = new ArrayList<>();
    List<String> rank2_url_list = new ArrayList<>();
    List<String> rank3_title_list = new ArrayList<>();
    List<String> rank3_url_list = new ArrayList<>();

    List<String> regex_list = new ArrayList<>();

    //获取xhr文本
    public String getXhr() throws IOException {
        String url="https://www.acfun.cn/?pagelets=pagelet_game,pagelet_douga,pagelet_bangumi_list,pagelet_life,pagelet_tech,pagelet_dance,pagelet_music,pagelet_film,pagelet_fishpond,pagelet_sport&reqID=0&ajaxpipe=1&t=1576228936457";
        Connection con = Jsoup.connect(url);
        //请求头设置，特别是cookie设置
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        con.ignoreContentType(true);
//        con.header("Cookie", cookie);
        Document doc=con.get();
        String xhr=doc.toString().replaceAll("\\&quot;","");
        return xhr;
    }

    //获取到rank2-3，yx，dh的数据列表
    public void XhrParse(String xhr){
        regex_list.add(0,"alt=\\\"\\\\(\\S+)[\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5]" );
        regex_list.add(1,"src=\\\"\\\\(\\S+)\\\\\\\"");
        regex_list.add(2,"/v/ac[0-9]+");

//-------------------------------------------dh-----------------------------------------------------
        regex_list.add(3,"点击:(\\S+)&#160");
        String xhr_dh = xhr.substring(xhr.indexOf("video-list-6"));
        xhr_dh = xhr_dh.substring(0, xhr_dh.indexOf("ranked-list"));//dh
        String[] dh = xhr_dh.split("cover");
        for (int i = 1; i < dh.length; i++) {
            for (int j = 0; j < regex_list.size(); j++) {
                Pattern p = Pattern.compile(regex_list.get(j));
                Matcher m = p.matcher(dh[i]);
                if (m.find()) {
                    if (j == 0) {
                        dh_title_list.add(m.group(1).replaceAll( "[\\p{P}+~$`^=|<>\\[\\]<>《》]" , ""));
                    } else if (j == 1) {
                        dh_img_list.add(m.group(1));
                    }else if (j==2){
                        dh_url_list.add(m.group());
                    }else if (j==3){
                        dh_click_list.add(m.group(1));
                    }
                } else {
                    if (j == 0)
                        dh_title_list.add("特征匹配失败");
                }
            }
        }
        for (int i = 0; i < dh_title_list.size(); i++) {
            if (dh_title_list.get(i) == "特征匹配失败") {
                dh_title_list.set(i, dh_url_list.get(i).split("/v/")[1]);
            }
        }
//-------------------------------------------------yx-------------------------------------------------------
        String xhr_yx = xhr.substring(xhr.indexOf("video-list-19"));
        xhr_yx = xhr_yx.substring(0, xhr_yx.indexOf("ranked-list"));//yx
        String[] yx = xhr_yx.split("cover");
        for (int i = 1; i < yx.length; i++) {
            for (int j = 0; j < regex_list.size(); j++) {
                Pattern p = Pattern.compile(regex_list.get(j));
                Matcher m = p.matcher(yx[i]);
                if (m.find()) {
                    if (j == 0) {
                        yx_title_list.add(m.group(1).replaceAll( "[\\p{P}+~$`^=|<>\\[\\]<>《》]" , ""));
                    } else if (j == 1) {
                        yx_img_list.add(m.group(1));
                    }else if (j==2){
                        yx_url_list.add(m.group());
                    }else if (j==3){
                        yx_click_list.add(m.group(1));
                    }
                } else {
                    if (j == 0)
                        yx_title_list.add("特征匹配失败");
                }
            }
        }
        for (int i = 0; i < yx_title_list.size(); i++) {
            if (yx_title_list.get(i) == "特征匹配失败") {
                yx_title_list.set(i, yx_url_list.get(i).split("/v/")[1]);
            }
        }
        regex_list.remove(3);
//-------------------------------------------------rank2 生活------------------------------------------------------
        regex_list.remove(1);
        regex_list.set(1,"data-atomid=\\\"\\\\([0-9]+)\\\\\\\"");
        String xhr_rank2 = xhr.substring(xhr.indexOf("class=\"\\ranked-list\\\""),xhr.indexOf("class=\"\\more\\\""));
        String[] rank2 = xhr_rank2.split("block-right");
        for (int i = 0; i < rank2.length; i++) {
            for (int j = 0; j < regex_list.size(); j++) {
                Pattern p = Pattern.compile(regex_list.get(j));
                Matcher m = p.matcher(rank2[i]);
                if (m.find()) {
                    if (j == 0) {
                        rank2_title_list.add(m.group(1).replaceAll("[\\p{P}+~$`^=|<>\\[\\]<>《》]",""));
                    } else if (j == 1) {
                        rank2_url_list.add("/v/ac"+m.group(1).split("\\\\")[0]);
                    }
                } else {
                    if (j == 0)
                        rank2_title_list.add("特征匹配失败");
                }
            }
        }
        for (int i = 0; i < rank2_title_list.size(); i++) {
            if (rank2_title_list.get(i) == "特征匹配失败") {
                rank2_title_list.set(i, rank2_url_list.get(i).split("/v/")[1]);
            }
        }
//------------------------------------------------rank3  ---------------------------------------------------------
        String xhr_rank3 = xhr.split("class=\\\"\\\\more\\\\\\\"")[1];
        String[] rank3 = xhr_rank3.split("block-right");
        rank3[0] = rank3[0].substring(rank3[0].indexOf("ranked-list-content"));
        for (int i = 0; i < rank3.length; i++) {
            for (int j = 0; j < regex_list.size(); j++) {
                Pattern p = Pattern.compile(regex_list.get(j));
                Matcher m = p.matcher(rank3[i]);
                if (m.find()) {
                    if (j == 0) {
                        rank3_title_list.add(m.group(1).replaceAll("[\\p{P}+~$`^=|<>\\[\\]<>《》]",""));
                    } else if (j == 1) {
                        rank3_url_list.add("/v/ac"+m.group(1).split("\\\\")[0]);
                    }
                } else {
                    if (j == 0)
                        rank3_title_list.add("特征匹配失败");
                }
            }
        }
        for (int i = 0; i < rank3_title_list.size(); i++) {
            if (rank3_title_list.get(i) == "特征匹配失败") {
                rank3_title_list.set(i, rank3_url_list.get(i).split("/v/")[1]);
            }
        }


        new Jdbc().saveDbData_V(dh_title_list,dh_img_list,dh_url_list,"dh_video","dh");
        new Jdbc().saveDbData_V(yx_title_list,yx_img_list,yx_url_list,"yx_video","yx");
        new Jdbc().saveDbData_R(rank2_title_list,rank2_url_list,"rank2","rank2");
        new Jdbc().saveDbData_R(rank3_title_list,rank3_url_list,"rank3","rank3");
        new Jdbc().saveDbData_V(dh_title_list,dh_img_list,dh_url_list,"video","dh");
        new Jdbc().saveDbData_V(yx_title_list,yx_img_list,yx_url_list,"video","yx");
        new Jdbc().saveDbData_R(rank2_title_list,rank2_url_list,"video","rank2");
        new Jdbc().saveDbData_R(rank3_title_list,rank3_url_list,"video","rank3");
        new Jdbc().saveDbData_click(dh_title_list,dh_click_list,"video");
        new Jdbc().saveDbData_click(yx_title_list,yx_click_list,"video");

    }
}
