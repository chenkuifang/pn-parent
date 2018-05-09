package com.common;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author QuiFar
 * @version V1.0
 * @Description: 用户实体类
 * @date 2017年11月11日 下午12:21:01
 */
@Slf4j
public class User implements Serializable {

    private static final long serialVersionUID = -7846848632214306244L;

    private Integer id; /* id */
    private String userName; /* 登陆用户名 */
    private String password; /* 登陆密码 */
    private Integer departmentId; /* 所属部门 */
    private Integer roleId; /* 用户所属角色id */
    private String userNike; /* 昵称 */
    private String email; /* 电子邮件 */
    private String mobile; /* 手机 */
    private Integer sex; /* 性别 1 男, 0 女*/
    private Integer createId; /* 创建者 */
    private java.util.Date createTime; /* 创建时间 */
    private java.util.Date updateTime; /* 修改时间 */
    private Integer status; /* 状态 1 正常, 0 停用 */

    // 创建者
    private User user;
}
