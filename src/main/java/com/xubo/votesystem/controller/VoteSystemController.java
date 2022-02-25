package com.xubo.votesystem.controller;

import com.xubo.votesystem.common.BasicResultVO;
import com.xubo.votesystem.entitys.req.UpdateOptionReq;
import com.xubo.votesystem.entitys.req.VoteOptionUpdateReq;
import com.xubo.votesystem.entitys.req.VoteTemplate;
import com.xubo.votesystem.entitys.req.VoteUpdateReq;
import com.xubo.votesystem.service.VoteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xubo
 * @Date 2022/2/24 15:50
 *
 */
@RestController
@RequestMapping("/vote")
public class VoteSystemController {

    @Autowired
    VoteContentService voteContentService;

    @PostMapping("/create")
    public BasicResultVO createVote(@RequestBody VoteTemplate voteTemplate) {
        return voteContentService.createVote(voteTemplate);
    }

    /**
     *  修改这块的逻辑比较复杂
     *  1、修改投票标题
     *  2、修改投票选项
     *
     * @param voteUpdateReq
     * @return
     */
    @PutMapping("update")
    public BasicResultVO updateVote(@RequestBody VoteUpdateReq voteUpdateReq) {
        return voteContentService.updateVote(voteUpdateReq);
    }

    /**
     * 需要计算百分比，记住总和要等于100% (会存在一个问题，就是三个 33.33% 四舍五入就成了 三个 33% )
     * @param voteId
     * @return
     */
    @GetMapping("/select")
    public BasicResultVO getVote(@RequestParam("voteId") Integer voteId) {
        return voteContentService.getDetailsById(voteId);
    }

    /**
     * 1、投票人修改选项   // 这个拆成一个单独的接口  或者创建投票的时候选择是否可修改的  后期迭代优化
     * @param updateOptionReq
     * @return
     */
    @PutMapping("/updateOptions")
    public BasicResultVO updateOption(@RequestBody UpdateOptionReq updateOptionReq) {
        return voteContentService.updateOption(updateOptionReq);
    }

}
