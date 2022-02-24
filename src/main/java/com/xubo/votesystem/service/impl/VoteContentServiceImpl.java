package com.xubo.votesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xubo.votesystem.dao.VoteContentMapper;
import com.xubo.votesystem.entitys.domain.VoteContent;
import com.xubo.votesystem.service.VoteContentService;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class VoteContentServiceImpl extends ServiceImpl<VoteContentMapper, VoteContent>
implements VoteContentService {

}
