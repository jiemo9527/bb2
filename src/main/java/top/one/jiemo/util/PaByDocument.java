package top.one.jiemo.util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaByDocument {
    //存储列表
    List<String> rside_title_list = new ArrayList<>();
    List<String> rside_img_list = new ArrayList<>();
    List<String> rside_url_list = new ArrayList<>();
    List<String> rside_click_list = new ArrayList<>();
    List<String> yl_title_list = new ArrayList<>();
    List<String> yl_img_list = new ArrayList<>();
    List<String> yl_url_list = new ArrayList<>();
    List<String> yl_click_list = new ArrayList<>();
    List<String> rank1_title_list = new ArrayList<>();
    List<String> rank1_url_list = new ArrayList<>();

    //获取到rside，yl，rank1数据列表
    public void JsoupParse() throws IOException {
        //匹配规则
        String regex_title = "alt=\\\\\\\"(\\S+)\\\\\\\"";
        String regex_img = "src=\\\\\\\"(\\S+)\\\\\\\"";
        String regex_url = "/v/ac[0-9]+";
        List<String> regex_list = new ArrayList<>();
        regex_list.add(regex_title);
        regex_list.add(regex_img);
        regex_list.add(regex_url);
        //获取html document
        Document document = Jsoup.parse(new URL("https://www.acfun.cn"), 6000);
        String doc = document.toString();
//------------------------------------------------- rside切分*6---------------------------------------------------------------
        regex_list.add(3,"icon-view-player\\\\\\\">(\\S+)</i>");
        String doc_k1 = doc.substring(doc.indexOf("slider-right-images"), doc.indexOf("window.sliderData"));
        String[] rside = doc_k1.split("recommend-video log-item");
        //匹配rside特征，保存
        for (int i = 1; i < rside.length; i++) {
            for (int j = 0; j < regex_list.size(); j++) {
                Pattern p = Pattern.compile(regex_list.get(j));
                Matcher m = p.matcher(rside[i]);
                if (m.find()) {
                    if (j == 0) {
                        rside_title_list.add(m.group(1));
                    } else if (j == 1) {
                        rside_img_list.add(m.group(1));
                    } else if (j == 2) {
                        rside_url_list.add(m.group());
                    }else if (j==3){
                        rside_click_list.add(m.group(1));
                    }
                } else {
//                    System.out.println("特征匹配失败：第"+(i+1)+"分块--第"+(j+1)+"匹配");
                    if (j == 0)
                        rside_title_list.add("特征匹配失败");
                }
            }

        }
        //rside匹配失败后处理
        for (int i = 0; i < rside_title_list.size(); i++) {
            if (rside_title_list.get(i) == "特征匹配失败") {
                rside_title_list.set(i, rside_url_list.get(i).split("/v/")[1]);
            }
        }
//-----------------------------------------------yl切分*12------------------------------------------------------
        regex_list.set(3,"点击:(\\S+)&#160");
        String[] doc_k2 = doc.split("big-image");
        String[] yl = doc_k2[1].split("normal-video-container");
//        匹配yl特征，保存
        for (int i = 0; i < yl.length; i++) {
            for (int j = 0; j < regex_list.size(); j++) {
                Pattern p = Pattern.compile(regex_list.get(j));
                Matcher m = p.matcher(yl[i]);
                if (m.find()) {
                    if (j == 0) {
                        yl_title_list.add(m.group(1));
                    } else if (j == 1) {
                        yl_img_list.add(m.group(1));
                    } else if (j == 2) {
                        yl_url_list.add(m.group());
                    }else if (j==3){
                       yl_click_list.add(m.group(1).split("&#")[0]);
                    }
                } else {
                    if (j == 0)
                        yl_title_list.add("特征匹配失败");
                }
            }
        }
        //yl匹配失败后处理
        for (int i = 0; i < yl_title_list.size(); i++) {
            if (yl_title_list.get(i) == "特征匹配失败") {
                yl_title_list.set(i, yl_url_list.get(i).split("/v/")[1]);
            }
        }
        regex_list.remove(3);
//-----------------------------------------------rank1切分*10------------------------------------------------------
        String doc_k3 = doc.substring(doc.indexOf("list-content-videos active"),doc.indexOf("class=\\\"list-content-videos\\\""));
        String[] rank1 = doc_k3.split("video-title text-overflow");
        regex_list.remove(1);
        regex_list.set(0,"title=\\\\\\\"(\\S+)&#13");
        for (int i = 1; i < rank1.length; i++) {
            for (int j = 0; j < regex_list.size(); j++) {
                Pattern p = Pattern.compile(regex_list.get(j));
                Matcher m = p.matcher(rank1[i]);
                if (m.find()) {
                    if (j == 0) {
                        rank1_title_list.add(m.group(1).split("&#13")[0]);
                    } else if (j == 1) {
                        rank1_url_list.add(m.group());
                    }
                } else {
                    if (j == 0)
                        rank1_title_list.add("特征匹配失败");
                }
            }
        }
        for (int i = 0; i < rank1_title_list.size(); i++) {
            if (rank1_title_list.get(i) == "特征匹配失败") {
                rank1_title_list.set(i, rank1_url_list.get(i).split("/v/")[1]);
            }
        }
        new Jdbc().saveDbData_V(rside_title_list,rside_img_list,rside_url_list,"rside_video","rside");
        new Jdbc().saveDbData_V(yl_title_list,yl_img_list,yl_url_list,"yl_video","yl");
        new Jdbc().saveDbData_R(rank1_title_list,rank1_url_list,"rank1","rank1");
        new Jdbc().saveDbData_V(rside_title_list,rside_img_list,rside_url_list,"video","rside");
        new Jdbc().saveDbData_V(yl_title_list,yl_img_list,yl_url_list,"video","yl");
        new Jdbc().saveDbData_R(rank1_title_list,rank1_url_list,"video","rank1");
        new Jdbc().saveDbData_click(rside_title_list,rside_click_list,"video");
        new Jdbc().saveDbData_click(yl_title_list,yl_click_list,"video");
    }




}

