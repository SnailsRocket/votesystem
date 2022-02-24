package com.xubo.votesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xubo.votesystem.dao.UserMapper;
import com.xubo.votesystem.entitys.domain.User;
import com.xubo.votesystem.service.UserService;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService {

}
