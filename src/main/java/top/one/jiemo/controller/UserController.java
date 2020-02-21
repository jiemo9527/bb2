package top.one.jiemo.controller;
/*首页-个人中心：修改密码，绑定邮箱，绑定手机，修改支付密码,更新用户头像*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UpdateEmailService updateEmailService;
    @Autowired
    private UpdatePhoneService updatePhoneService;
    @Autowired
    private UpdatePayPasswordService upps;
    @Autowired
    private UpdatePictureService updatePictureService;
    @Autowired
    private UpdateUserAddressService uuas;
    @Autowired
    private UserInformationShowService uiss;
    @Autowired
    private UpdateUserCardService uucs;


    //绑定邮箱修改
    @RequestMapping("/ue_back")
    public void UE_back(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String newemail = request.getParameter("newemail");
        String userName= (String) request.getSession().getAttribute("userName");
        userEntity user = new userEntity();
        user.setUserName(userName);
        user.setUserEmail(newemail);
        String email_sql = updateEmailService.findEmail(userName);

        if(!email.equals(email_sql)){
            request.setAttribute("msg","请输入正确的原邮箱！");
            request.getRequestDispatcher("updateEmail.do").forward(request,response);
        }else if(newemail == null || newemail.length() == 0){
            request.setAttribute("msg","请输入正确的邮箱！");
            request.getRequestDispatcher("updateEmail.do").forward(request,response);
        } else if (email.equals(newemail)){
            request.setAttribute("msg","新邮箱与原邮箱相同！");
            request.getRequestDispatcher("updateEmail.do").forward(request,response);
        }else if(!newemail.matches( "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
            request.setAttribute("msg","邮箱不合法！");
            request.getRequestDispatcher("updateEmail.do").forward(request,response);
        } else if(updateEmailService.updateEmail(user)>0){
            request.setAttribute("msg","邮箱修改成功！新的邮箱为"+newemail);
            request.getRequestDispatcher("updateEmail.do").forward(request,response);
        }
    }
    //绑定手机修改
    @RequestMapping("/uph_back")
    public void UPh_back(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPhone = request.getParameter("userPhone");
        String newUserPhone = request.getParameter("newUserPhone");
        String vcode = request.getParameter("vcode");
        String userName=(String) request.getSession().getAttribute("userName");
        String phone_sql = updatePhoneService.findPhone(userName);
        userEntity user = new userEntity();
        user.setUserName(userName);
        user.setUserPhone(newUserPhone);
        if(!userPhone.equals(phone_sql)){
            request.setAttribute("msg","请输入正确的原手机号！");
            request.getRequestDispatcher("updatePhone.do").forward(request,response);
        }else if(newUserPhone == null || newUserPhone.length() == 0){
            request.setAttribute("msg","请输入正确的手机号！");
            request.getRequestDispatcher("updatePhone.do").forward(request,response);
        } else if (userPhone.equals(newUserPhone)){
            request.setAttribute("msg","新手机号与原手机号相同！");
            request.getRequestDispatcher("updatePhone.do").forward(request,response);
        }else if(!newUserPhone.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$")){
            request.setAttribute("msg","新手机号不合法！");
            request.getRequestDispatcher("updatePhone.do").forward(request,response);
        }else if(!"56143".equals(vcode)){
            request.setAttribute("msg","验证码不正确！");
            request.getRequestDispatcher("updatePhone.do").forward(request,response);
        } else if(updatePhoneService.updatePhone(user)>0){
            request.setAttribute("msg","修改成功！新的绑定手机为"+newUserPhone);
            request.getRequestDispatcher("updatePhone.do").forward(request,response);
        }
    }
    //修改支付密码
    @RequestMapping("upp_back")
    public void UpdatePayPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payPassword = request.getParameter("payPassword");
        String newPayPassword = request.getParameter("newPayPassword");
        String newPayPassword2 = request.getParameter("newPayPassword2");
        String userName = (String) request.getSession().getAttribute("userName");
        String payPassword_sql = upps.findPayPassword(userName);
        userEntity user = new userEntity();
        user.setUserName(userName);
        if(payPassword_sql==null) {
            user.setUserPayPassword("123456");
            upps.updatePayPassword(user);
            if (!"123456".equals(payPassword)){
                request.setAttribute("msg","默认密码为123456");
                request.getRequestDispatcher("updatePayPassword.do").forward(request,response);
            }
        }else{
            user.setUserPayPassword(newPayPassword);
        }
        if(!payPassword_sql.equals(payPassword)){
            request.setAttribute("msg","原支付密码不正确！");
            request.getRequestDispatcher("updatePayPassword.do").forward(request,response);
        } else if(newPayPassword == null || newPayPassword.trim().length() == 0){
            request.setAttribute("msg","支付密码不能为空！");
            request.getRequestDispatcher("updatePayPassword.do").forward(request,response);
        } else if (!newPayPassword.equals(newPayPassword2)){
            request.setAttribute("msg","新的支付密码不相同！");
            request.getRequestDispatcher("updatePayPassword.do").forward(request,response);
        }else if(newPayPassword.equals(payPassword)){
            request.setAttribute("msg","支付密码不能与原来相同！");
            request.getRequestDispatcher("updatePayPassword.do").forward(request,response);
        }else {
            user.setUserPayPassword(newPayPassword);
            upps.updatePayPassword(user);
            request.setAttribute("msg", "支付密码修改成功！新的支付密码为" + newPayPassword);
            request.getRequestDispatcher("updatePayPassword.do").forward(request, response);
        }

    }
    //更新用户头像
    @RequestMapping("/u_pic")
    public String UpdatePicture(HttpServletRequest request, HttpServletResponse response,
            Model model)
            throws IOException {
        MultipartHttpServletRequest mutliRequest = (MultipartHttpServletRequest) request;
        //1.获取图片数据
        MultipartFile mfile = mutliRequest.getFile("pic1");
        //2.把图片保存在某个路径
        String uploadFolder = request.getServletContext().getRealPath("/upload");
        System.out.println("uploadFolder:" + uploadFolder);
        File uploadFolderFile = new File(uploadFolder);
        if (!uploadFolderFile.exists()) {
            uploadFolderFile.mkdirs();
        }

        String suffix = mfile.getOriginalFilename().split("\\.")[1];
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
        String totalPath = uploadFolder + "\\" + fileName;
        System.out.println("totalpath:" + totalPath);
        FileCopyUtils.copy(mfile.getInputStream(), new FileOutputStream(new File(totalPath)));

        //返回数据给客户端
        String picture_new = "http://localhost:8080/upload/" + fileName;
        System.out.println(picture_new);
        userEntity user = new userEntity();
        String userName = (String) request.getSession().getAttribute("userName");
        user.setUserName(userName);
        user.setPicture(picture_new);
        updatePictureService.updateUserPicture(user);
        return "UserInformation";
    }
    //更新用户地址
    @RequestMapping("/ua_back")
    public void Ua_back(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("userName");
        String userAddress = request.getParameter("userAddress");
        userEntity user = uiss.findDetail(userName);
        user.setUserAddress(userAddress);
        int count = uuas.UpdateUserAddress(user);
        if (count>0){
            request.setAttribute("msg","地址更新成功！");
            request.getRequestDispatcher("userAddress.do").forward(request,response);
        }
    }
    //更新银行卡
    @RequestMapping("/ubc_back")
    public void Ubc_back(HttpServletRequest request,HttpServletResponse response, Model model) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("userName");
        String userCard = request.getParameter("userCard");
        String userCard2 = request.getParameter("userCard2");
        if (userCard.equals("") || (userCard.trim().length() == 0)){
            request.setAttribute("msg","请输入正确的银行卡！");
            request.getRequestDispatcher("bankCard.do").forward(request,response);
        }else if(!userCard.equals(userCard2)){
            request.setAttribute("msg","俩次输入的卡号不相同！");
            request.getRequestDispatcher("bankCard.do").forward(request,response);
        }else{
            userEntity user = uiss.findDetail(userName);
            user.setUserCard(userCard);
            int count = uucs.UpdateUserCard(user);
            request.setAttribute("msg","已绑定新的银行卡！");
            request.getRequestDispatcher("bankCard.do").forward(request,response);
        }
    }

}
