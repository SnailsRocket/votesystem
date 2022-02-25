package com.xubo.votesystem.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xubo.votesystem.common.BasicResultVO;
import com.xubo.votesystem.entitys.domain.VoteContent;
import com.xubo.votesystem.entitys.req.VoteTemplate;
import com.xubo.votesystem.entitys.req.VoteUpdateReq;

/**
*
*/
public interface VoteContentService extends IService<VoteContent> {

    BasicResultVO createVote(VoteTemplate voteTemplate);

    BasicResultVO getDetailsById(Integer voteId);

    BasicResultVO updateVote(VoteUpdateReq voteUpdateReq);
}
