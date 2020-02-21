package top.one.jiemo.controller;
/*注册，登录，修改登录密码，退出登录，search*/

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.one.jiemo.model.VideoEntity;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UpdatePasswordService updatePasswordService;
    @Autowired
    private UserInformationShowService uiss;
    @Autowired
    private VideoUpload videoUpload;





    //    注册
    @RequestMapping("/reg_back")
    public String reg_back(HttpServletRequest request,HttpServletResponse response,Model model)
            throws IOException, ServletException {
        request.setCharacterEncoding("gbk");
//        response.setCharacterEncoding("gbk");
        userEntity user = new userEntity();
        java.lang.String userName = request.getParameter("userName");
        java.lang.String passWord = request.getParameter("passWord");
        java.lang.String userEmail = request.getParameter("userEmail");
        java.lang.String userPhone = request.getParameter("userPhone");
        user.setUserName(userName);
        user.setPassWord(passWord);
        user.setUserEmail(userEmail);
        user.setUserPhone(userPhone);
        user.setUserState("正常");
        if (registerService.findUserFromDb(userName) > 0) {
            request.setAttribute("msg", "用户名已存在");
            request.getRequestDispatcher("register.do").forward(request,response);
        } else if (userName == null || userName.trim().length() == 0) {
            request.setAttribute("msg","用户名不能为空");
            request.getRequestDispatcher("register.do").forward(request,response);
        } else if (passWord == null || passWord.trim().length() == 0) {
            request.setAttribute("msg", "密码不能为空");
            request.getRequestDispatcher("register.do").forward(request,response);
        } else {
            registerService.addUser(user);
            request.setAttribute("msg","注册成功，点击跳转"+"<a style='color:green;' href='login.do'>登录</a><br>分支：等待管理员审核！");
            request.getRequestDispatcher("register.do").forward(request,response);

        }
        return null;
    }
//    登录+登录成功显示头像
    @RequestMapping("/log_back")
    public java.lang.String Log_back(HttpServletRequest request, HttpServletResponse response,
                                     HttpSession session, userEntity user, Model model) throws ServletException, IOException {
        java.lang.String userName = request.getParameter("userName");
        java.lang.String passWord = request.getParameter("passWord");
        int count = loginService.checkUser(user);
        userEntity userDetail = uiss.findDetail(userName);
        if(userName == null || userName.trim().length() == 0){
            request.setAttribute("msg","用户名不能为空！");
            request.getRequestDispatcher("login.do").forward(request,response);
        }else if(passWord == null || passWord.trim().length() == 0){
            request.setAttribute("msg","密码不能为空！");
            request.getRequestDispatcher("login.do").forward(request,response);
        }else if(count>0){
            if(userDetail.getUserState().equals("正常")){
                model.addAttribute("userDetail",userDetail);
                session.setAttribute("userName",userName);
                return "redirect:index.do";
            }else {
                request.setAttribute("msg","您的账号异常，暂时无法登陆！");
                request.getRequestDispatcher("login.do").forward(request,response);
            }

        }else {
            request.setAttribute("msg","用户名或密码错误！");
            request.getRequestDispatcher("login.do").forward(request,response);
        }
        return  null;
    }
//    修改密码
    @RequestMapping("/up_back")
    public String UP_back(HttpServletRequest request,HttpServletResponse response,userEntity user) throws ServletException, IOException {
        java.lang.String passWord=request.getParameter("passWord");
        java.lang.String newPassWord = request.getParameter("newPassWord");
        java.lang.String newPassWord2 = request.getParameter("newPassWord2");
        java.lang.String userName = (java.lang.String) request.getSession().getAttribute("userName");
        java.lang.String passWord_sql=updatePasswordService.findPasswd(userName);
        if(!passWord.equals(passWord_sql)){
            request.setAttribute("msg","原密码不正确！");
            request.getRequestDispatcher("updatePasswd.do").forward(request,response);
        }else if(!newPassWord.equals(newPassWord2)){
            request.setAttribute("msg","新密码不匹配！");
            request.getRequestDispatcher("updatePasswd.do").forward(request,response);
        }else if(newPassWord.equals(passWord)){
            request.setAttribute("msg","新密码与原密码相同！");
            request.getRequestDispatcher("updatePasswd.do").forward(request,response);
        }else{
//            userEntity user = new userEntity(userName,newPassWord);
            int count=updatePasswordService.updatePassword(user);
            if(count==1){
                request.setAttribute("msg","密码修改成功！新密码为"+"'"+newPassWord+"'");
                request.getRequestDispatcher("updatePasswd.do").forward(request,response);
            }

        }
        return null;
}
    @RequestMapping("/search")
    public java.lang.String Search(java.lang.String key, HttpServletRequest request, HttpServletResponse response, Model model){
        key="%"+key+"%";
        List<VideoEntity> serachVideos = videoUpload.serachVideo(key);
        model.addAttribute("serachVideos",serachVideos);
        java.lang.String userName = (java.lang.String) request.getSession().getAttribute("userName");
        userEntity uissDetail = uiss.findDetail(userName);
        model.addAttribute("uissDetail",uissDetail);
        return "search";

    }
    @RequestMapping("/favorite")
    public java.lang.String Favorite(java.lang.String status, java.lang.String username, java.lang.String videourl,
                                     java.lang.String title, java.lang.String img, java.lang.String click,
                                     HttpServletRequest request, HttpServletResponse response, Model model){
        try {
            if (status.equals("收藏")){
                videoUpload.addVideoFavorite(username,videourl,title,img,click);
            }else if(status.equals("已收藏")){
                videoUpload.delVideoFavorite(username,videourl);
            }
        } catch (Exception e) {

        }
        return null;

    }
    //退出登录
    @RequestMapping("/exit")
    public void Exit(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
        //清除当前用户相关的session对象
        request.getSession().invalidate();
        request.setAttribute("login_status","已退出当前账户，请登录！");
        request.getRequestDispatcher("login.do").forward(request,response);
    }


}
