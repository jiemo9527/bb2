package top.one.jiemo.model;

public class PaVideo {
    private String title;
    private String url;
    private String img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public PaVideo() {
    }

    public PaVideo(String title, String url, String img) {
        this.title = title;
        this.url = url;
        this.img = img;
    }

    @Override
    public String toString() {
        return "PaVideo{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
