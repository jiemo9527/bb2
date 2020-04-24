package top.one.jiemo.controller;
/*页面跳转的控制*/

import javafx.beans.binding.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.one.jiemo.model.*;
import top.one.jiemo.service.OrderService;
import top.one.jiemo.service.ShowCommodityService;
import top.one.jiemo.service.UserInformationShowService;
import top.one.jiemo.service.VideoUpload;
import top.one.jiemo.util.GetThirdParse;
import top.one.jiemo.util.HttpProxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PageJumpController {
    @Autowired
    private UserInformationShowService uiss;
    @Autowired
    private VideoUpload videoUpload;
    @Autowired
    private ShowCommodityService showCommodityService;
    @Autowired
    private OrderService orderService;





    //      返回首页+显示用户头像+动态展示视频
    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request,Model model) throws Exception {
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        VideoEntity videoList = new VideoEntity();


        while (true) {


//        爬:每隔1小时获取一次（视频列表，排行榜列表）；【判断】完成时更新一次时间
            long ctime = System.currentTimeMillis();
            long createtime = videoUpload.getCreateTime();
            if (ctime - createtime > 5*60*1000) {
                videoUpload.paVideo();
                ctime = System.currentTimeMillis();
                videoUpload.updateCreateTime(ctime);
                //调第三方m3u8解析
                List<String> allUrl = videoUpload.getAllUrl();
                for (int i = 0; i < allUrl.size(); i++) {
                    //代理
//                String m3u8 = new HttpProxy().getParse(allUrl.get(i));
//                直连
                    String m3u8 = new GetThirdParse().getM3u8(
                            allUrl.get(i));
                    videoUpload.updateFieldM3u8(m3u8, allUrl.get(i));
                }
//            删除无效数据
                videoUpload.delErrorVideo();
            }


//        页面查询
            List<VideoEntity> rSideVideos = videoUpload.findRSideVideos();
            model.addAttribute("rSideVideos", rSideVideos);
            List<VideoEntity> ylVideos = videoUpload.findylVideos();
            model.addAttribute("ylVideos", ylVideos);
            List<VideoEntity> yxVideos = videoUpload.findyxVideos();
            model.addAttribute("yxVideos", yxVideos);
            List<VideoEntity> dhVideos = videoUpload.finddhVideos();
            model.addAttribute("dhVideos", dhVideos);
            List<VideoEntity> rank1 = videoUpload.findRank1();
            model.addAttribute("rank1", rank1);
            List<VideoEntity> rank2 = videoUpload.findRank2();
            model.addAttribute("rank2", rank2);
            List<VideoEntity> rank3 = videoUpload.findRank3();
            model.addAttribute("rank3", rank3);


            return "index";
        }
    }
    //    跳转注册页面
    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }
    //    跳转登录页面
    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }
    //    跳转修改登录密码
    @RequestMapping("/updatePasswd")
    public String UpdatePasswd(Model model,HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity uissDetail = uiss.findDetail(userName);
        model.addAttribute("uissDetail",uissDetail);
        return "UpdatePasswd";
    }
    //    跳转个人信息页面+显示用户信息（用户名，余额，上次登录时间+*头像*）
    @RequestMapping("/userInformation")
    public String ToUserInformation(HttpServletRequest request, HttpServletResponse response,
                                   Model model){
        String nowTime= DateFormat.getDateTimeInstance().format(new Date());
        String userName = (String) request.getSession().getAttribute("userName");
        List<Integer> userPaymoney = orderService.findUserPaymoney(userName);//查询订单中的消费
        int payMoney=0;
        for (Integer i:userPaymoney) {
            payMoney+=i;
        }//合计
        uiss.updateUserMoney(payMoney,userName);//更新余额
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        userEntity user = new userEntity();
        user.setUserName(userName);
        user.setLastLoginTime(nowTime);
        uiss.updateLoginTime(user);
        return "UserInformation";
    }
    //    跳转邮箱绑定
    @RequestMapping("/updateEmail")
    public String ToUpdateEmail(){
        return "UpdateEmail";
    }
    //    跳转手机绑定
    @RequestMapping("/updatePhone")
    public String ToUpdatePhone(){
        return "UpdatePhone";
    }
    //    跳转修改支付密码
    @RequestMapping("/updatePayPassword")
    public String ToUpdatePayPassword(){
        return "UpdatePayPassword";
    }
    //跳转信息资料+显示头像+显示用户信息
    @RequestMapping("/info")
    public  String ToInformation(HttpServletRequest request,Model model){
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        userEntity user = uiss.findDetail(userName);
        model.addAttribute("user",user);
        return "Information";
    }
    //跳转银行卡+显示头像+银行卡状态
    @RequestMapping("/bankCard")
    public  String ToBankCard(HttpServletRequest request,HttpServletResponse response,Model model) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        if (userDetail.getUserCard()==null){
            model.addAttribute("state","您还未设置银行卡信息!");
        }else{
            model.addAttribute("state","您已绑定银行卡!");
        }
        return "BankCard";
    }


    //跳转收货地址+显示头像
    @RequestMapping("/userAddress")
    public  String ToUserAddress(HttpServletRequest request,Model model){
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        return "UserAddress";
    }
    //跳转个人订单++显示头像+显示订单
    @RequestMapping("/order")
    public String ToOrder(HttpServletRequest request,Model model){
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        List<OrderEntity> orders = orderService.findAllOrders(userName);
        model.addAttribute("orders",orders);

        return "Order";
    }
    //取消订单
    @RequestMapping("/cancelOrder")
    public String CancelOrder(String orderID){
        orderService.cancelOrder(orderID);
        return "redirect:order.do";
    }
    //删除订单
    @RequestMapping("/delOrder")
    public String DelOrder(String orderID){
        orderService.delOrder(orderID);
        return "redirect:order.do";
    }
    //跳转已删除订单+显示头像+显示删除订单
    @RequestMapping("/deletedOrder")
    public String DeletedOrderOrder(HttpServletRequest request,Model model){
        String userName = (String) request.getSession().getAttribute("userName");
        userEntity userDetail = uiss.findDetail(userName);
        model.addAttribute("userDetail",userDetail);
        List<OrderEntity> delOrders = orderService.findDelOrders(userName);
        model.addAttribute("delOrders",delOrders);
        return "DeletedOrder";
    }
    //添加订单


    //跳转视频投稿
    @RequestMapping("/videoUpload")
    public  String ToVideoUpload(){
        return "VideoUpload";
    }




}
