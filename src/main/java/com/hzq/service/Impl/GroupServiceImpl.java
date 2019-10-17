package com.hzq.service.Impl;

import com.hzq.common.Const;
import com.hzq.common.ServerResponse;
import com.hzq.dao.GroupDao;
import com.hzq.dao.GroupToUserDao;
import com.hzq.dao.UserInfoDao;
import com.hzq.domain.Group;
import com.hzq.domain.GroupToUser;
import com.hzq.domain.User;
import com.hzq.domain.UserInfo;
import com.hzq.enums.ResponseCodeEnum;
import com.hzq.execption.CustomGenericException;
import com.hzq.service.GroupService;
import com.hzq.service.GroupToUserService;
import com.hzq.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: blue
 * @Date: 2019/10/3
 * @Description: 群聊
 * @version: 1.0
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public ServerResponse<String> insert(Group group, HttpSession session) {
        if (groupDao.insert(group) == 0) {
            throw CustomGenericException.CreateException(ResponseCodeEnum.ERROR.getCode(),"创建群聊失败");
        }
        //群主的由触发器自动设定
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<String> delete(Integer id) {
        if (groupDao.delete(id) == 0) {
            return ServerResponse.createByErrorMessage("删除群聊失败");
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<String> update(Group group) {
        if (groupDao.update(group) == 0) {
            return ServerResponse.createByErrorMessage("更新群聊失败");
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<List<Group>> selectAll(Integer userId) {
        List<Group> groups = groupDao.selectAll(userId);
        if (groups == null) {
            return ServerResponse.createByErrorMessage("查找不到群聊");
        }
        return ServerResponse.createBySuccess(groups);
    }

    @Override
    public ServerResponse<Group> select(Integer id) {
        Group group = groupDao.selectGroup(id);
        if (group == null) {
            return ServerResponse.createByErrorMessage("根据群id查询不到群信息");
        }
        return ServerResponse.createBySuccess(group);
    }
}
