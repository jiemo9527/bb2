package top.one.jiemo.model;

public class Favorite {
    private String username;
    private String videourl;
    private String title;
    private String img;
    private String click;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public Favorite() {
    }

    public Favorite(String username, String videourl, String title, String img, String click) {
        this.username = username;
        this.videourl = videourl;
        this.title = title;
        this.img = img;
        this.click = click;
    }
}
