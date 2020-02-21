package top.one.jiemo.model;


//周边商品类
public class commodityEntity {
	public String commodityID;//商品ID
	public String commodityName;//商品名字
	public String commodityPrice;//商品价格
	public String commodityImg;//商品图片地址
	public int commodityAmount;//商品库存

	public String getCommodityID() {
		return commodityID;
	}

	public void setCommodityID(String commodityID) {
		this.commodityID = commodityID;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(String commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityImg() {
		return commodityImg;
	}

	public void setCommodityImg(String commodityImg) {
		this.commodityImg = commodityImg;
	}

	public int getCommodityAmount() {
		return commodityAmount;
	}

	public void setCommodityAmount(int commodityAmount) {
		this.commodityAmount = commodityAmount;
	}

	public commodityEntity() {
	}
	//商品详情
	public commodityEntity(String commodityID, String commodityName, String commodityPrice, String commodityImg, int commodityAmount) {
		this.commodityID = commodityID;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityImg = commodityImg;
		this.commodityAmount = commodityAmount;
	}

	@Override
	public String toString() {
		return "commodityEntity{" +
				"commodityID='" + commodityID + '\'' +
				", commodityName='" + commodityName + '\'' +
				", commodityPrice='" + commodityPrice + '\'' +
				", commodityImg='" + commodityImg + '\'' +
				", commodityAmount=" + commodityAmount +
				'}';
	}
}