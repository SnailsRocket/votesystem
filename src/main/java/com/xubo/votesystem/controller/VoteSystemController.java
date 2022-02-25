package com.xubo.votesystem.controller;

import com.xubo.votesystem.common.BasicResultVO;
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

    @PutMapping("update")
    public BasicResultVO updateVote(@RequestBody VoteUpdateReq voteUpdateReq) {
        return voteContentService.updateVote(voteUpdateReq);
    }

    @GetMapping("/select")
    public BasicResultVO getVote(@RequestParam("voteId") Integer voteId) {
        return voteContentService.getDetailsById(voteId);
    }

}
