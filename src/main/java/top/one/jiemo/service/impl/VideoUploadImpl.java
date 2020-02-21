package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.VideoMapper;
import top.one.jiemo.model.Favorite;
import top.one.jiemo.model.VideoEntity;
import top.one.jiemo.service.VideoUpload;
import top.one.jiemo.util.PaByDocument;
import top.one.jiemo.util.PaByXhr;

import java.io.IOException;
import java.util.List;

@Service
public class VideoUploadImpl implements VideoUpload {
    @Autowired
    private VideoMapper videoMapper;


    @Override
    public List<VideoEntity> findylVideos() {
        return videoMapper.findylVideos();
    }

    @Override
    public List<VideoEntity> findyxVideos() {
        return videoMapper.findyxVideos();
    }

    @Override
    public List<VideoEntity> finddhVideos() {
        return videoMapper.finddhVideos();
    }

    @Override
    public List<VideoEntity> findRSideVideos() {
        return videoMapper.findRSideVideos();
    }

    @Override
    public List<VideoEntity> findRank1() {
        return videoMapper.findRank1();
    }

    @Override
    public List<VideoEntity> findRank2() {
        return videoMapper.findRank2();
    }

    @Override
    public List<VideoEntity> findRank3() {
        return videoMapper.findRank3();
    }

    @Override
    public void addVideo(VideoEntity video) {
        videoMapper.addVideo(video);
    }

    @Override
    public VideoEntity findVideoM3u8(String url) {
        return videoMapper.findVideoM3u8(url);
    }

    @Override
    public void paVideo(){
        try {
            new PaByDocument().JsoupParse();
            new PaByXhr().XhrParse(new PaByXhr().getXhr());
        } catch (IOException e) {
        }
    }

    @Override
    public long getCreateTime() {
        return videoMapper.getCreateTime();
    }

    @Override
    public int updateCreateTime(long ctime) {
        return videoMapper.updateCreateTime(ctime);
    }

    @Override
    public List<String> getAllUrl() {
        return videoMapper.getAllUrl();
    }

    @Override
    public int updateFieldM3u8(String m3u8, String url) {
        return videoMapper.updateFieldM3u8(m3u8,url);
    }

    @Override
    public int getVideoCount() {
        return videoMapper.getVideoCount();
    }

    @Override
    public void delErrorVideo() {
        videoMapper.delErrorVideo();
    }

    @Override
    public List<VideoEntity> serachVideo(java.lang.String key) {
        return videoMapper.serachVideo(key);
    }

    @Override
    public int addVideoFavorite(String username, String videourl, String title, String img, String click) {
        return videoMapper.addVideoFavorite(username,videourl,title,img,click);
    }


    @Override
    public int delVideoFavorite(String username, String videourl) {
        return videoMapper.delVideoFavorite(username,videourl);
    }

    @Override
    public List<Favorite> findVideoFavorite(String username) {
        List<Favorite> videoFavoriteList = videoMapper.findVideoFavorite(username);
        return videoFavoriteList;

    }


}
