package top.one.jiemo.controller;
/*商品-商品详情页-购物车-提交-----------前台||后台:发货
* 商品-商品详情页-（购买）确定订单-提交---|
*
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.one.jiemo.mapper.OrderMapper;
import top.one.jiemo.model.OrderEntity;
import top.one.jiemo.model.ShoppingCar;
import top.one.jiemo.model.commodityEntity;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.OrderService;
import top.one.jiemo.service.ShowCommodityService;
import top.one.jiemo.service.UpdateGoodsService;
import top.one.jiemo.service.UserInformationShowService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ShoppingController {
    @Autowired
    private UserInformationShowService uiss;
    @Autowired
    private ShowCommodityService showCommodityService;
    @Autowired
    private UpdateGoodsService updateGoodsService;
    @Autowired
    private OrderMapper orderMapper;



    //跳转周边+列出商品
    @RequestMapping("/surrounding")
    public  String ToSurrounding(HttpServletRequest request,Model model){
        List<commodityEntity> commodityList =showCommodityService.findAllCommodity();
        model.addAttribute("commodityList",commodityList);
        return "Surrounding";
    }
    //跳转商品详情页
    @RequestMapping("/commodityPay")
    public String CommodityPay(Integer commodityID, Model model){
        commodityEntity commodity=showCommodityService.findCommodityById(commodityID);
        model.addAttribute("commodity",commodity);
        return "CommodityPay";
    }
    //左分支：跳转确认订单+显示收货地址和商品信息
    @RequestMapping("/confirmOrder")
    public String ConfirmOrder(HttpServletRequest request, Integer commodityID, Integer number, Model model){
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        commodityEntity commodity=showCommodityService.findCommodityById(commodityID);
        model.addAttribute("commodity",commodity);
        model.addAttribute("number",number);
        return "ConfirmOrder";
    }
    //左分支：提交
    @RequestMapping("/submitOrders2")
    public String SubmitOrders2(HttpServletRequest request,String Cname,String Cprice){
        String userName = (String) request.getSession().getAttribute("userName");
        String OrderID = UUID.randomUUID().toString().replace("-","");
        userEntity detail = uiss.findDetail(userName);
        OrderEntity order = new OrderEntity();
        order.setOrderStat("1");
        order.setOrderUserName(userName);
        order.setOrderAddr(detail.getUserAddress());
        order.setOrderCName(Cname);
        order.setOrderPrice(Cprice);
        order.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        order.setOrderID(OrderID);
        if (!order.getOrderCName().equals(null)){
            orderMapper.addOrders(order);
        }
        return  "redirect:order.do";
    }

    //右分支：跳转购物车+显示购物车物品
    @RequestMapping("/shoppingCar")
    public String ToShoppingCar(HttpServletRequest request, HttpServletResponse response,String user, String Cname,
                              String total, String CId, String CImg, Model model) throws ServletException, IOException {
        String carID = UUID.randomUUID().toString().replace("-","");
        ShoppingCar car = new ShoppingCar();
        car.setCarID(carID);
        car.setUserName(user);
        car.setShoppingName(Cname);
        car.setShoppingPrice(total);
        car.setShoppingID(CId);
        car.setShoppingImg(CImg);
        if (CId!=null) {
            updateGoodsService.addgoods(car);
        }
        List<ShoppingCar> goods = updateGoodsService.findgoodsFromCar(user);
        model.addAttribute("goods",goods);
        return "ShoppingCar";
    }
    //删除购物车商品
    @RequestMapping("/delShoppingCar")
    public String DelShoppingCar(HttpServletRequest request,String shoppingID,
                                 Model model){
        String userName = (String) request.getSession().getAttribute("userName");
        List<ShoppingCar> goods = updateGoodsService.findgoodsFromCar(userName);
        System.out.println(shoppingID);
        for (ShoppingCar good:goods) {
            if(good.getShoppingID().equals(shoppingID)){
                System.out.println(good.getShoppingID());
                updateGoodsService.delgoods(good.getCarID());
            }
        }
        return "redirect:shoppingCar.do?user="+userName;
    }
    //右分支：提交
    @RequestMapping("/submitOrders")
    public String SubmitOrders(HttpServletRequest request,String Cname,String Cprice,
                               String CID){
        String userName = (String) request.getSession().getAttribute("userName");
        String OrderID = UUID.randomUUID().toString().replace("-","");
        userEntity detail = uiss.findDetail(userName);
        OrderEntity order = new OrderEntity();
        order.setOrderStat("1");
        order.setOrderUserName(userName);
        order.setOrderAddr(detail.getUserAddress());
        order.setOrderCName(Cname);
        order.setOrderPrice(Cprice);
        order.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        order.setOrderID(OrderID);
        if (!order.getOrderCName().equals(null)){
            orderMapper.addOrders(order);
            updateGoodsService.delgoods(CID);
        }
        return  "redirect:order.do";
    }






}
