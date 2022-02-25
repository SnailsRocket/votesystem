package com.xubo.votesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xubo.votesystem.common.BasicResultVO;
import com.xubo.votesystem.dao.VoteContentMapper;
import com.xubo.votesystem.entitys.domain.VoteContent;
import com.xubo.votesystem.entitys.vo.VoteInfoVO;
import com.xubo.votesystem.entitys.req.VoteTemplate;
import com.xubo.votesystem.entitys.req.VoteUpdateReq;
import com.xubo.votesystem.service.VoteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class VoteContentServiceImpl extends ServiceImpl<VoteContentMapper, VoteContent>
implements VoteContentService {

    @Autowired
    VoteContentMapper voteContentMapper;

    @Override
    public BasicResultVO createVote(VoteTemplate voteTemplate) {
        return null;
    }

    @Override
    public BasicResultVO getDetailsById(Integer voteId) {
        VoteInfoVO voteInfoVO = voteContentMapper.getDetailById(voteId);
        return BasicResultVO.success(voteInfoVO);
    }

    @Override
    public BasicResultVO updateVote(VoteUpdateReq voteUpdateReq) {
        return null;
    }
}
