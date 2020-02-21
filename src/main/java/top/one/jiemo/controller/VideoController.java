package top.one.jiemo.controller;
/*投稿与显示*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import top.one.jiemo.model.Favorite;
import top.one.jiemo.model.VideoEntity;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UserInformationShowService;
import top.one.jiemo.service.VideoUpload;
import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.util.Date;
import java.util.List;


@Controller
public class VideoController {
    @Autowired
    private VideoUpload videoUpload;
    @Autowired
    private UserInformationShowService uiss;


    //投稿入库
    @RequestMapping("/vp_back")
    public void VideoUpload(HttpServletRequest request)
            throws Exception {
        VideoEntity video = new VideoEntity();
        String mp4Url = request.getParameter("mp4Url");
        String mp4Size = request.getParameter("mp4Size");
        String imgUrl = request.getParameter("imgUrl");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String Fruit = request.getParameter("Fruit");
        /*参数入库*/
        video.setTitle(title);
//        video.setVideoDescription(description);
        String mp4Sizeformat = String.format("%.2f", (Double.parseDouble(mp4Size) / 1024 / 1024));
//        video.setVideoSize(mp4Sizeformat+"MB");
        video.setType(Fruit);
        File mp4UrlFile=new File(mp4Url);
        String mp4UrlFileName=mp4UrlFile.getName();
        String suffix1=mp4UrlFileName.substring(mp4UrlFileName.lastIndexOf("."),mp4UrlFileName.length());
        File imgUrlFile=new File(imgUrl);
        String imgUrlFileName=imgUrlFile.getName();
        String suffix2=imgUrlFileName.substring(imgUrlFileName.lastIndexOf("."),imgUrlFileName.length());
        String outPath=request.getSession().getServletContext().getRealPath("/sub");
        File outPathFile = new File(outPath);
        if (!outPathFile.exists()) {
            outPathFile.mkdirs();
        }
        String path1=outPath+"\\"+title+suffix1;
        String path2=outPath+"\\"+title+suffix2;
        FileCopyUtils.copy(new FileInputStream(mp4Url),new FileOutputStream(path1));
        FileCopyUtils.copy(new FileInputStream(imgUrl),new FileOutputStream(path2));
        /*文件地址入库*/
//        video.setVideoImage(path2);
//        video.setVideoAddress(path1);
        videoUpload.addVideo(video);



    }
    //视频播放页面
    @RequestMapping("/video")
    public String Video(String url, Model model){
        VideoEntity video = videoUpload.findVideoM3u8(url);
        model.addAttribute("video",video);
        return "Video";
    }
    //视频收藏列表
    @RequestMapping("/favoriteList")
    public String favoriteList(Model model,HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userName");
        List<Favorite> videoFavoriteList = videoUpload.findVideoFavorite(userName);
        model.addAttribute("videoFavoriteList",videoFavoriteList);
        userEntity uissDetail = uiss.findDetail(userName);
        model.addAttribute("uissDetail",uissDetail);
        return "Favorite";
    }











}


















