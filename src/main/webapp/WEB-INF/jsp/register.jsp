<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/ant-design-vue@1.3.10/dist/antd.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/register/css/custom.css?4.0.0">
    <style>
        [v-cloak] {
            display: none;
        }
    </style>


    <title>注册</title>

    <style>

        #app {
            padding-top: 100px;
        }

        h1 {
            text-align: center;
            color: #fff;
            margin: 20px 0 50px 0;
        }

        .ant-btn, .ant-input {
            height: 50px;
            border-radius: 30px;
        }

        .ant-input-affix-wrapper .ant-input-prefix {
            left: 23px;
        }

        .ant-input-affix-wrapper .ant-input:not(:first-child) {
            padding-left: 50px;
        }

    </style>

</head>
<body>

<a-layout id="app" v-cloak>
    <transition name="list" appear>
        <a-layout-content>
            <a-row type="flex" justify="center">
                <a-col :xs="22" :sm="20" :md="16" :lg="12" :xl="8">
                    <h1>用 户 注 册</h1>
                </a-col>
            </a-row>
            <a-row type="flex" justify="center">
                <a-col :xs="22" :sm="20" :md="16" :lg="12" :xl="8">
                    <form name="myform" action="${pageContext.request.contextPath}/reg_back.do" method="post">
                        <a-form-item>
                            <a-input  name="userName" v-model.trim="user.username" placeholder="用户名"
                                     @keydown.enter.native="reg" autofocus><p>${msg}</p>
                                <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input name="passWord" type="password" v-model.trim="user.password"
                                     placeholder="密码" @keydown.enter.native="reg">
                                <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input id="email" type="email" onblur="checkEmail()"
                                   name="userEmail"  placeholder="邮箱" @keydown.enter.native="reg">
                                <a-icon slot="prefix" type="mail" style="color: rgba(0,0,0,.25)"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input id="phone" type="phone" onblur="checkPhone()"
                                    name="userPhone" placeholder="手机号" @keydown.enter.native="reg">
                                <a-icon slot="prefix" type="phone" style="color: rgba(0,0,0,.25)"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-button block @click="reg" :loading="loading" >
                                <a href="javascript: document.myform.submit();">
                                   注册</a>
                            </a-button>
                        </a-form-item>
                        <div id="msg" style="color: red;font-size: 16px;" >${msg}</div>
                        <div id="msg2" style="color: red;font-size: 16px;" ></div>
                    </form>

                </a-col>
            </a-row>
        </a-layout-content>
    </transition>
</a-layout>




<script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/ant-design-vue@1.3.10/dist/antd.min.js"></script>
<script src="${pageContext.request.contextPath}/static/register/axios/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/static/register/qs/qs.min.js"></script>
<script src="${pageContext.request.contextPath}/static/register/qrcode/qrious.min.js"></script>
<script src="${pageContext.request.contextPath}/static/register/clipboard/clipboard.min.js"></script>
<script src="${pageContext.request.contextPath}/static/register/js/util.js?4.0.0"></script>
<script src="${pageContext.request.contextPath}/static/register/js/axios-init.js?4.0.0"></script>
<script src="${pageContext.request.contextPath}/static/register/js/v2_classes.js?4.0.0"></script>
<script>
    const basePath = '';
    axios.defaults.baseURL = basePath;
</script>

<script>
    let leftColor = randomIntRange(0x222222, 0xFFFFFF / 2).toString(16);
    let rightColor = randomIntRange(0xFFFFFF / 2, 0xDDDDDD).toString(16);
    let deg = randomIntRange(0, 360);
    let background = 'linear-gradient(' + deg + 'deg, #' + leftColor + ' 10%, #' + rightColor + ' 100%)';
    document.querySelector('#app').style.background = background;
    let app = new Vue({
        delimiters: ['[[', ']]'],
        el: '#app',
        data: {
            loading: false,
            user: {username: '', password: ''},
        },
        methods: {
            reg() {
                this.loading = true;
                post({
                    url: '',
                    data: this.user,
                    success: data => {
                    this.loading = false;
                if (data.success) {
                    location.href = '';
                }
            },
                error: () => this.loading = false
            });
            }
        }
    });
</script>

</body>
<script>
    function checkEmail(){
        var reg = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;
        var obj = document.getElementById("email");
        var msg = document.getElementById("msg2");
        if(obj.value === ""){ //输入不能为空
            msg.innerHTML="邮箱不能为空!";
            return false;
        }else if(!reg.test(obj.value)){ //正则验证不通过，格式不对
            msg.innerHTML="请输入正确的邮箱!";
            return false;
        }else{
            msg.innerHTML="";
            return true;
        }
    }
    function checkPhone(){
        var phone = document.getElementById('phone').value;
        var msg=document.getElementById('msg2');
        if(!(/^1[3456789]\d{9}$/.test(phone))){
            msg.innerHTML="请输入正确的手机号";
            return false;
        }else{
            msg.innerHTML="";
            return true;
        }
    }

</script>
</html>