package com.xubo.votesystem.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xubo.votesystem.entitys.domain.VoteContent;
import com.xubo.votesystem.entitys.vo.VoteInfoVO;
import org.apache.ibatis.annotations.Param;

/**
* @Entity generator.domain.VoteContent
*/
public interface VoteContentMapper extends BaseMapper<VoteContent> {

    VoteInfoVO getDetailById(@Param("voteId") Integer voteId);
}
