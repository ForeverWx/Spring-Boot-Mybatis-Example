package com.sm.service.controller;

import com.sm.service.entity.User;
import com.sm.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*log4j*/
@RestController //相当于 restbody+controller 标识这个类为控制器 同时返回数据为json 数据 return的数据都变成json的格式，返回到前端，不会跳转界面
@RequestMapping("/user")//控制器的名字
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*RequestBody
     * @RequestMapping修饰的方法在正常情况下虽然可以直接在参数列表中声明参数，但如果在Ajax的Post方式提交时是不会取到值的，所以要用最原始的方法获取参数。
     * @PathVariable 路径获取参数     @RequestMapping("/showTeacher/{id}") @PathVariable int id
     */
//    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    User login(@RequestBody User user) throws Exception {
        logger.error("用户登录信息");
        String username = "";
        String password = "";

        if (user.getUsername() != null) {
            username = user.getUsername();
        }
        if (user.getPassword() != null) {
            password = user.getPassword();
        }

        if (username == null || password == null) {
            logger.error("未获取到数据！");
            return null;
        } else {
            logger.error("用户 名");
            logger.error(username);
            logger.error("用户 密码");
            logger.error(password);

            User user_rs = userService.findUserByName(username);

            if (user_rs != null) {
                logger.info("结果");
                logger.info(user_rs.toString());

                String pass_rs = user_rs.getPassword();
                if (pass_rs.equals(user.getPassword())) {
                    return user_rs;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }
}
