package com.xubo.votesystem.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xubo.votesystem.entitys.domain.VoteContent;
import com.xubo.votesystem.entitys.vo.VoteInfoVO;

/**
* @Entity generator.domain.VoteContent
*/
public interface VoteContentMapper extends BaseMapper<VoteContent> {

    VoteInfoVO getDetailById(Integer voteId);
}
