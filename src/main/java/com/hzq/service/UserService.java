package com.hzq.service;

import com.hzq.vo.ServerResponse;
import com.hzq.vo.Result;
import com.hzq.domain.User;

import javax.servlet.http.HttpSession;

/**
 * @Auther: blue
 * @Date: 2019/9/30
 * @Description: service接口
 * @version: 1.0
 */
public interface UserService {

    /**
     * 用户注册
     * @param user 用户
     * @return 返回通用对象
     */
    ServerResponse<String> register(User user);

    /**
     * 用户登录
     * @param username 用户账号
     * @param password 用户密码
     * @return 返回通用对象
     */
    ServerResponse<Result> login(String username, String password);

    /**
     * 根据用户名和用户id刷新token
     * @param session 一次会话
     * @param username 用户名
     * @param id 用户id
     * @return 返回通用结果
     */
    ServerResponse<String> refreshToken(String username, Integer id, HttpSession session);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 返回通用对象
     */
    ServerResponse<User> selectByUsername(String username);

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 返回用户对象
     */
    ServerResponse<User> selectById(Integer id);

    /**
     * 更新用户密码
     * @param newPassword 新密码
     * @param oldPassword 旧密码
     * @param id 主键id
     * @return 返回通用对象
     */
    ServerResponse<String> updatePassword(String newPassword, String oldPassword, Integer id);

    /**
     * 更新密码
     * @param password 密码
     * @param id 用户id
     * @return 返回通用结果
     */
    ServerResponse<String> update(String password,Integer id);

    /**
     * 更新用户状态
     * @param status 状态
     * @param id 用户id
     * @return 返回通用结果
     */
    ServerResponse<String> updateStatus(Integer status, Integer id);

    /**
     * 根据用户id删除用户
     * @param id 用户id
     * @return 返回通用对象
     */
    ServerResponse<String> deleteUserById(Integer id);

    /**
     * 根据用户id查询用户是否存在
     * @param id 用户id
     * @return 返回查询到的数据条数
     */
    int checkUserId(Integer id);

    /**
     * 根据用户名查询用户是否存在
     * @param username 用户名
     * @return 返回通用对象
     */
    ServerResponse<String> checkUsername(String username);
}























