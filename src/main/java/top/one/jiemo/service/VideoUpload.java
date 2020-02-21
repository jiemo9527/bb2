package top.one.jiemo.service;

import top.one.jiemo.model.Favorite;
import top.one.jiemo.model.VideoEntity;

import java.io.IOException;
import java.util.List;

public interface VideoUpload {
    List<VideoEntity> findylVideos();//主页展示视频：yl,yx,dh*8
    List<VideoEntity> findyxVideos();
    List<VideoEntity> finddhVideos();
    List<VideoEntity> findRSideVideos();
    List<VideoEntity> findRank1();
    List<VideoEntity> findRank2();
    List<VideoEntity> findRank3();
    void addVideo(VideoEntity video);
    VideoEntity findVideoM3u8(String url);
    void paVideo() throws IOException;
    long getCreateTime();
    int updateCreateTime(long ctime);
    List<String> getAllUrl();
    int updateFieldM3u8(String m3u8, String url);//更新m3u8
    int getVideoCount();
    void delErrorVideo();

    List<VideoEntity> serachVideo(String key);
    int addVideoFavorite(String username, String videourl,String title,String img,String click);//添加收藏
    int delVideoFavorite(String username, String videourl);//删除收藏
    List<Favorite> findVideoFavorite(String username);//查询收藏



}
