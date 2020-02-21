package top.one.jiemo.util;

import java.io.*;

public class VideoParse {

    public static String rootPath = "";

    static {
        rootPath = "F:\\ideaprojects\\bb2\\src\\main\\resource\\";
    }

    public String getList(String url){
        String list=null;
        System.out.println("==============================获取m3u8列表==============================");
        try {
            Runtime rt = Runtime.getRuntime();
            String exec = rootPath + "phantomjs.exe " + rootPath + "code.js " + url;
            Process p = rt.exec(exec);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sbf = new StringBuffer();
            while (br.readLine() != null) {
                sbf.append(br.readLine());
            }
            System.out.println(sbf);
            //m3u8list：5个相同list
            String trait="https://tx-video.acfun.cn/mediacloud/acfun/acfun_video/segment/";
            String[] last = String.valueOf(sbf).split("backupUrl");
            for (int i = 0; i < 1; i++) {
                int end =last[i].indexOf("\\",last[i].indexOf(trait));
                list=last[i].substring(last[i].indexOf(trait), end);
            }
            System.out.println(list);
            System.out.println("==============================结束1==============================");

        }catch (Exception e){
            System.out.println("ERROR!"+e);
        }
        return list;

    }

        //无需获取ts片段
//    public List<String> getVideoUrls(String url) {
//        List<String> ans = new ArrayList<String>();
//
//        System.out.println("==============================获取ts视频片段==============================");
//        try {
//            Runtime rt = Runtime.getRuntime();
//            String exec = rootPath + "/phantomjs.exe " + rootPath + "/code.js " + url;
//            Process p = rt.exec(exec);
//            InputStream is = p.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            StringBuffer sbf = new StringBuffer();
//            while (br.readLine() != null) {
//                sbf.append(br.readLine());
//            }
//            //ts片段:24*5个相同片段
//            String[] split = String.valueOf(sbf).split("backupUrl");
//            for (int i = 0; i < 1; i++) {
//                String urls = sbf.substring(sbf.indexOf("#EXTM3U"));
//                urls = urls.substring(0,urls.indexOf("\\\"}")-1);
//                String[] paths = urls.split("\\\\\\\\n");
//                for (String path:paths) {
//                    if(path.contains(".ts?"))
//                        ans.add(path);
//                }
//            }
//            for (String an:ans) {
//                System.out.println(an);
//            }
//
//            System.out.println("==============================结束2==============================");
//        }catch (Exception e){
//            System.out.println("ERROR!"+e);
//        }
//        return ans;
//    }


}