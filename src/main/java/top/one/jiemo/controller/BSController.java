package top.one.jiemo.controller;
//SU-后台管理

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.one.jiemo.model.OrderEntity;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.BSService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class BSController  {
    @Autowired
    private BSService bsService;

    //后台登陆
    @RequestMapping("/bSlogin")
    public String BSlogin(){
        return "BSlogin";
    }
    //后台登陆验证
    @RequestMapping("/bsl_back")
    public String BSL_back(HttpServletRequest request, HttpServletResponse response,
                         HttpSession session) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String suPassword = bsService.findSuPassword();
        if (!userName.equals("admin")){
            request.setAttribute("msg","非法登陆！");
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }else if(!suPassword.equals(passWord)){
            request.setAttribute("msg","密码错误！");
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }else{
            session.setAttribute("SU",userName);
            return "redirect:allOrders.do";
        }
        return  null;
    }
    //后台管理菜单
    @RequestMapping("/allOrders")
    public String AllOrders(HttpServletRequest request,HttpServletResponse response,
                            Model model) throws ServletException, IOException {
        String su = (String) request.getSession().getAttribute("SU");
        if(su==null||su.trim().length()==0){
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }
        List<OrderEntity> orders = bsService.findAllOrders();
        model.addAttribute("orders",orders);
        return "AllOrders";
    }
    //未发货订单
    @RequestMapping("/noShipped")
    public String NoShipped(HttpServletRequest request,HttpServletResponse response,
                            Model model) throws ServletException, IOException {
        String su = (String) request.getSession().getAttribute("SU");
        if(su==null||su.trim().length()==0){
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }
        List<OrderEntity> orders = bsService.findNoShipped();
        model.addAttribute("orders",orders);
        return "NoShipped";
    }
    //立即发货
    @RequestMapping("/ship")
    public String Ship(String orderID){
        bsService.ship(orderID);
        return "forward:noShipped.do";
    }
    //已完成订单
    @RequestMapping("/completedOrders")
    public String CompletedOrders(HttpServletRequest request,HttpServletResponse response,
                                  Model model) throws ServletException, IOException {
        String su = (String) request.getSession().getAttribute("SU");
        if(su==null||su.trim().length()==0){
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }
        List<OrderEntity> orders = bsService.findCompletedOrders();
        model.addAttribute("orders",orders);
        return "CompletedOrders";
    }
    //退货订单
    @RequestMapping("/returnOrders")
    public String ReturnOrders(HttpServletRequest request,HttpServletResponse response,
                               Model model) throws ServletException, IOException {
        String su = (String) request.getSession().getAttribute("SU");
        if(su==null||su.trim().length()==0){
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }
        List<OrderEntity> orders = bsService.findReturnOrders();
        model.addAttribute("orders",orders);
        return "ReturnOrders";
    }
    //立即退货
    @RequestMapping("/Return")
    public String Return(String orderID){
        bsService.Return(orderID);
        return "forward:returnOrders.do";
    }
    //自定义查询订单
    @RequestMapping("/findOrders")
    public String FindOrders(HttpServletRequest request,HttpServletResponse response,
                             Model model) throws ServletException, IOException {
        String su = (String) request.getSession().getAttribute("SU");
        if(su==null||su.trim().length()==0){
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }
        String userName = request.getParameter("Keywords");
        List<OrderEntity> orders = bsService.findOrders(userName);
        model.addAttribute("orders",orders);
        return "FindOrders";
    }
    /*******************************************/
    //用户账号管理
    @RequestMapping("/userMM")
    public String UserMM(HttpServletRequest request,HttpServletResponse response,
                Model model) throws ServletException, IOException {
        String su = (String) request.getSession().getAttribute("SU");
        if(su==null||su.trim().length()==0){
            request.getRequestDispatcher("bSlogin.do").forward(request,response);
        }
        List<userEntity> users = bsService.findAllUsers();
        model.addAttribute("users",users);
        return "UserMM";
    }
    //用户条件查询
    @RequestMapping("/Cquery")
    public String Cquery(HttpServletRequest request,HttpServletResponse response,
                       Model model){
        String usertext = request.getParameter("usertext");
        String usertext2 = request.getParameter("usertext2");
        userEntity userByC1 = bsService.findUserByC1(usertext);
        userEntity userByC2 = bsService.findUserByC2(usertext2);
        if (userByC1!=null) {
            model.addAttribute("user", userByC1);
        }else {
            model.addAttribute("user", userByC2);
        }
        return "cquery";
    }
    //通过审核
    @RequestMapping("/approvedUser")
    public String ApprovedUser(HttpServletRequest request,String userName) {
        int count = bsService.ApprovedUser(userName);
        return "forward:userMM.do";
    }
    //冻结账号
    @RequestMapping("/freezeUser")
    public String FreezeUser(HttpServletRequest request,String userName) {
        int count = bsService.FreezeUser(userName);
        return "forward:userMM.do";
    }
    //退出BS
    @RequestMapping("/exitBS")
    public String exitBS(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

}
