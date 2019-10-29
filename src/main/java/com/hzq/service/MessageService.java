package com.hzq.service;

import com.hzq.common.ServerResponse;
import com.hzq.domain.Message;
import com.hzq.vo.SendMessage;

import java.util.List;

/**
 * @Auther: blue
 * @Date: 2019/10/2
 * @Description: 处理私聊
 * @version: 1.0
 */
public interface MessageService {

    /**
     *  插入私聊消息
     * @param message 消息
     * @param messageStatus 0 未读 1 已读
     * @param userId 该消息属于哪个用户
     * @return 返回通用对象
     */
    ServerResponse<String> insert(SendMessage message, Integer messageStatus, Integer userId);


    ServerResponse<List<Message>> queryMessageByUserIdAndFriendId(Integer id, Integer friendId);

    /**
     * 根据消息id更新一条消息状态
     * @param id 消息id
     */
    void updateOneMessage(Integer id);

    /**
     * 根据两个id更新多条消息状态
     * @param bigId 大的id
     * @param smallId 小的id
     * @param userId 用户id
     */
    void update( Integer bigId, Integer smallId, Integer userId);

    /**
     * 根据消息删除消息
     * @param id 消息id
     * @return 返回通用对象
     */
    ServerResponse<String> deleteMessageById(Integer id);

    /**
     * 根据用户id和好友id删除消息
     * @param userId 用户id
     * @param friendId 好友id
     * @return 返回通用对象
     */
    ServerResponse<String>  deleteMessageByUserIdAndFriendId(Integer userId, Integer friendId);

    /**
     *
     * 根据用户id查询所有私聊未读消息
     * @param userId 用户主表id
     * @return 返回未读消息通用对象
     */
    ServerResponse<List<SendMessage>>  selectUnReadSendMessage(Integer userId);
}
