package com.example.controller;

import com.common.bean.JsonResult;
import com.common.constant.Constants;
import com.common.entity.User;
import com.common.util.JsonResultUtils;
import com.common.util.MDUtils;
import com.example.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * 登陆控制类
 *
 * @author QuiFar
 * @version V1.0
 */
@Controller
public class LoginController {

    @Autowired
    private UserClient userClient;

    /**
     * 获取登陆初始化页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登陆校验
     *
     * @param userName
     * @param password
     * @return code 100 成功，101 失败
     */
    @PostMapping("/loginPost")
    @ResponseBody
    public JsonResult loginPost(HttpServletRequest request, @RequestParam("userName") String userName,
                                @RequestParam("password") final String password) {

        Integer code = Constants.FAIL_CODE;
        String msg = Constants.USER_NAME_OR_PASSWORD_ERROR;
        User user = userClient.getByName(userName);

        if (user != null) {
            String md5Str = "";
            try {
                md5Str = MDUtils.encodeMD5(password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (user.getPassword().equals(md5Str)) {
                code = Constants.SUCCESS_CODE;
                msg = Constants.SUCCESS_DESCRIPTION;

//                // 存放user相关信息进入session
//                WebContext webContext = new WebContext();
//                webContext.setUserId(user.getId());
//                webContext.setUserName(user.getUserName());
//                webContext.setUserNike(user.getUserNike());
//                webContext.setRoleId(user.getRoleId());
//                webContext.setIp(request.getRemoteAddr());
//
//                HttpSession session = request.getSession();
//                session.setAttribute(Constants.SESSION_USER, webContext);
//
//                // 重新为内存的session 赋值，保证两个session对象一致
//                WebContextUtils.setSession(session);
            }
        }

        // 结果返回
        return JsonResultUtils.jsonResult(code, msg);
    }

    /**
     * 登出
     *
     * @return
     */
    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        // 清除session
        Enumeration<String> em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement());
        }
        return "redirect:/login";
    }

    /**
     * 修改密码初始化视图
     *
     * @return
     */
    @GetMapping("/changePwd")
    public String changePwd(Model model) {
//        String userName = WebContextUtils.getCurrentUserName();
//        model.addAttribute("userName", userName);
//        model.addAttribute("result", "");
        return "user/changePwd";
    }

    /**
     * 获取修改密码操作
     *
     * @param userName 用户名
     * @param oldPwd   旧密码
     * @param newPwd   新密码
     * @param model    需要返回的数据
     * @return
     * @throws Exception
     */
    @PostMapping("/changePwdPost")
    public String changePwdPost(@RequestParam String userName, @RequestParam String oldPwd, @RequestParam String newPwd,
                                Model model) throws Exception {
        String result;

        // 根据用户名获取用户信息
        //User user = userClient.getByName(userName);
        User user = new User();
        String encodePwd = MDUtils.encodeMD5(oldPwd);
        if (user != null && user.getPassword().equals(encodePwd)) {
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setPassword(MDUtils.encodeMD5(newPwd));

            // 修改密码
//            int flag = userClient.update(newUser);
//            result = flag >= 1 ? Constants.SUCCESS_DESCRIPTION : Constants.FAIL_DESCRIPTION;
        } else {
            result = Constants.USER_NAME_OR_PASSWORD_ERROR;
        }
        model.addAttribute("userName", userName);
        //model.addAttribute("result", result);
        return "user/changePwd";
    }
}
