package com.xubo.votesystem.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xubo.votesystem.dao.OptionUserMapper;
import com.xubo.votesystem.entitys.domain.OptionUser;
import com.xubo.votesystem.service.OptionUserService;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class OptionUserServiceImpl extends ServiceImpl<OptionUserMapper, OptionUser>
implements OptionUserService {

}
