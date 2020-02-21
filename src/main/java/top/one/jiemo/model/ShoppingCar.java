package top.one.jiemo.model;

//商品实体表
public class ShoppingCar {
	public String carID; //购物车ID
	public String userName;//购物人名字(账号)
	public String shoppingID;//商品ID
	public String shoppingName;//商品名字
	public String shoppingImg;//商品图片地址
	public String shoppingPrice;//商品价格

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShoppingID() {
		return shoppingID;
	}

	public void setShoppingID(String shoppingID) {
		this.shoppingID = shoppingID;
	}

	public String getShoppingName() {
		return shoppingName;
	}

	public void setShoppingName(String shoppingName) {
		this.shoppingName = shoppingName;
	}

	public String getShoppingImg() {
		return shoppingImg;
	}

	public void setShoppingImg(String shoppingImg) {
		this.shoppingImg = shoppingImg;
	}

	public String getShoppingPrice() {
		return shoppingPrice;
	}

	public void setShoppingPrice(String shoppingPrice) {
		this.shoppingPrice = shoppingPrice;
	}

	public ShoppingCar() {
	}

	public ShoppingCar(String carID, String userName, String shoppingID, String shoppingName, String shoppingImg, String shoppingPrice) {
		this.carID = carID;
		this.userName = userName;
		this.shoppingID = shoppingID;
		this.shoppingName = shoppingName;
		this.shoppingImg = shoppingImg;
		this.shoppingPrice = shoppingPrice;
	}
}
