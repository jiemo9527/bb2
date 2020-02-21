package top.one.jiemo.mapper;

//视频上传与展示
import top.one.jiemo.model.Favorite;
import top.one.jiemo.model.VideoEntity;

import java.util.List;

public interface VideoMapper {
    List<VideoEntity> findylVideos();//主页展示视频：yl,yx,dh*8
    List<VideoEntity> findyxVideos();
    List<VideoEntity> finddhVideos();
    List<VideoEntity> findRank1();
    List<VideoEntity> findRank2();
    List<VideoEntity> findRank3();
    List<VideoEntity> findRSideVideos();//滚动图片右侧6个视频
    void addVideo(VideoEntity video);//添加视频
    VideoEntity findVideoM3u8(java.lang.String url);
    long getCreateTime();//获取上一次爬取时间
    int updateCreateTime(long ctime);//pa完成更新一次时间
    List<java.lang.String> getAllUrl();//获取所有url→解析m3u8
    int updateFieldM3u8(java.lang.String m3u8, java.lang.String url);//更新m3u8
    int getVideoCount();
    void delErrorVideo();

    List<VideoEntity> serachVideo(java.lang.String key);//搜索视频功能
    int addVideoFavorite(String username, String videourl,String title,String img,String click);//添加收藏
    int delVideoFavorite(String username, String videourl);//删除收藏
    List<Favorite> findVideoFavorite(String username);//查询收藏




}

