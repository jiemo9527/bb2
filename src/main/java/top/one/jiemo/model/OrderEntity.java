package top.one.jiemo.model;


import java.util.Date;

//订单
public class OrderEntity {
	
	
	/*		
	订单状态:
		1      为: 已下单
		2      为: 已发货
		3      为: 退货中
		4      为: 订单完成/退货完成
		5      为：已删除*/


		public String orderID;//订单ID
		public String orderUserName;//订单人名字
		public String orderCName;//订单商品名字
		public String orderImg;//订单商品图片
		public String orderPrice;//订单总价格
		public String orderStat;//订单状态
		public String orderTime;//订单时间
		public String orderAddr;//订单收货地址

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderUserName() {
		return orderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	public String getOrderCName() {
		return orderCName;
	}

	public void setOrderCName(String orderCName) {
		this.orderCName = orderCName;
	}

	public String getOrderImg() {
		return orderImg;
	}

	public void setOrderImg(String orderImg) {
		this.orderImg = orderImg;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderStat() {
		return orderStat;
	}

	public void setOrderStat(String orderStat) {
		this.orderStat = orderStat;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public OrderEntity() {
	}

	public OrderEntity(String orderID, String orderUserName, String orderCName, String orderImg, String orderPrice, String orderStat, String orderTime, String orderAddr) {
		this.orderID = orderID;
		this.orderUserName = orderUserName;
		this.orderCName = orderCName;
		this.orderImg = orderImg;
		this.orderPrice = orderPrice;
		this.orderStat = orderStat;
		this.orderTime = orderTime;
		this.orderAddr = orderAddr;
	}

	@Override
	public String toString() {
		return "OrderEntity{" +
				"orderID='" + orderID + '\'' +
				", orderUserName='" + orderUserName + '\'' +
				", orderCName='" + orderCName + '\'' +
				", orderImg='" + orderImg + '\'' +
				", orderPrice='" + orderPrice + '\'' +
				", orderStat='" + orderStat + '\'' +
				", orderTime='" + orderTime + '\'' +
				", orderAddr='" + orderAddr + '\'' +
				'}';
	}
}
