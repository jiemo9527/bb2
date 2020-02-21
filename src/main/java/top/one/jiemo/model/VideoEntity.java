package top.one.jiemo.model;

public class VideoEntity {
	private String title;
	private String img;
	private String url;
	private String m3u8;
	private String type;
	private String click;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getM3u8() {
		return m3u8;
	}

	public void setM3u8(String m3u8) {
		this.m3u8 = m3u8;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public VideoEntity() {
	}

	public VideoEntity(String title, String img, String url, String m3u8, String type, String click) {
		this.title = title;
		this.img = img;
		this.url = url;
		this.m3u8 = m3u8;
		this.type = type;
		this.click = click;
	}
}
