package com.xubo.votesystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xubo.votesystem.common.BasicResultVO;
import com.xubo.votesystem.constant.VoteConstant;
import com.xubo.votesystem.dao.VoteContentMapper;
import com.xubo.votesystem.entitys.domain.OptionUser;
import com.xubo.votesystem.entitys.domain.VoteContent;
import com.xubo.votesystem.entitys.domain.VoteContentOptions;
import com.xubo.votesystem.entitys.req.*;
import com.xubo.votesystem.entitys.vo.VoteInfoVO;
import com.xubo.votesystem.service.OptionUserService;
import com.xubo.votesystem.service.VoteContentOptionsService;
import com.xubo.votesystem.service.VoteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
*
*/
@Service
public class VoteContentServiceImpl extends ServiceImpl<VoteContentMapper, VoteContent>
implements VoteContentService {

    @Autowired
    VoteContentMapper voteContentMapper;

    @Autowired
    VoteContentOptionsService voteContentOptionsService;

    @Autowired
    OptionUserService optionUserService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BasicResultVO createVote(VoteTemplate voteTemplate) {
        validateVote(voteTemplate);
        VoteContent voteContent = convertToVoteContent(voteTemplate);
        List<VoteContentOptions> voteContentOptions = convertToVoteContentOptions(voteTemplate.getVoteOptions(), voteTemplate.getCreateId());
        this.save(voteContent);
        voteContentOptionsService.saveBatch(voteContentOptions);
        return BasicResultVO.success();
    }

    @Override
    public BasicResultVO getDetailsById(Integer voteId) {
        VoteInfoVO voteInfoVO = voteContentMapper.getDetailById(voteId);
        return BasicResultVO.success(voteInfoVO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResultVO updateVote(VoteUpdateReq voteUpdateReq) {
        this.updateById(VoteContent.builder().id(voteUpdateReq.getVoteId())
                    .content(voteUpdateReq.getContent())
                    .updateTime(LocalDateTime.now())
                    .updateUser(voteUpdateReq.getUpdateUser())
                    .build());
        JSONObject jsonObject = convertCoteContentOptionForUpdate(voteUpdateReq);
        if(jsonObject.getJSONArray("delOption").size() > 0) {
            List<VoteContentOptions> delOptions = jsonObject.getJSONArray("delOption").toJavaList(VoteContentOptions.class);
            delOptions.stream().forEach(e -> {
                e.setDelStatus(VoteConstant.DEL);
            });
            voteContentOptionsService.updateBatchById(delOptions);
        }
        if(jsonObject.getJSONArray("addOption").size() > 0) {
            List<VoteContentOptions> addOptions = jsonObject.getJSONArray("addOption").toJavaList(VoteContentOptions.class);
            addOptions.stream().forEach(e -> {
                e.setDelStatus(VoteConstant.NOT_DEL);
                e.setCreateTime(LocalDateTime.now());
                e.setCreateUser(voteUpdateReq.getUpdateUser());
            });
            voteContentOptionsService.saveBatch(addOptions);
        }
        return BasicResultVO.success();
    }

    @Override
    public BasicResultVO updateOption(UpdateOptionReq updateOptionReq) {
        // 首先判断这个投票有没有失效
        Integer voteId = updateOptionReq.getVoteId();
        VoteContent voteContent = this.getOne(new LambdaQueryWrapper<VoteContent>().eq(VoteContent::getId, voteId));
        if(voteContent.getExpiredStatus() == 1) {
            // 这个失效的前端去处理， 失效直接不可修改
            return BasicResultVO.fail("投票已失效，不能更改");
        }
        optionUserService.update(new UpdateWrapper<OptionUser>().set("del_status", VoteConstant.DEL)
                .eq("user_id", updateOptionReq.getUserId())
                .eq("option_id", updateOptionReq.getOldOptionId()));
        optionUserService.save(OptionUser.builder().userId(updateOptionReq.getUserId())
                    .optionId(updateOptionReq.getNewOptionId())
                    .delStatus(VoteConstant.NOT_DEL)
                    .createTime(LocalDateTime.now())
                    .build());
        return BasicResultVO.success();
    }


    public VoteContent convertToVoteContent(VoteTemplate voteTemplate) {
        return VoteContent.builder().content(voteTemplate.getContent())
                .createTime(LocalDateTime.now())
                .createUser(voteTemplate.getCreateId())
                .expiredStatus(VoteConstant.VALID)
                .delStatus(VoteConstant.NOT_DEL)
                .expiredTime(voteTemplate.getExpiredHours())
                .build();
    }

    public List<VoteContentOptions> convertToVoteContentOptions(List<VoteOption> voteOptions, Integer createUser) {
        List<VoteContentOptions> voteContentOptions = new ArrayList<>();
        voteOptions.stream().forEach(e -> {
            voteContentOptions.add(VoteContentOptions.builder().voteDescription(e.getOptionName())
                    .delStatus(VoteConstant.NOT_DEL)
                    .createTime(LocalDateTime.now())
                    .createUser(createUser)
                    .build());
        });
        return voteContentOptions;
    }

    public void validateVote(VoteTemplate voteTemplate) {
        if(StringUtils.isEmpty(voteTemplate.getContent())) {
            throw new RuntimeException("投票标题为空！");
        }
        if(StringUtils.isEmpty(voteTemplate.getVoteOptions()) || voteTemplate.getVoteOptions().size() == 0) {
            throw new RuntimeException("投票选项不能为空！");
        }
    }

    /**
     * 这个其实是重复代码，校验入参，后面规整实体类的时候再一起处理这个问题(实体类也很乱)
     * @param voteUpdateReq
     */
    public void validateVote(VoteUpdateReq voteUpdateReq) {
        if(StringUtils.isEmpty(voteUpdateReq.getContent())) {
            throw new RuntimeException("投票标题为空！");
        }
        if(StringUtils.isEmpty(voteUpdateReq.getOptions()) || voteUpdateReq.getOptions().size() == 0) {
            throw new RuntimeException("投票选项不能为空！");
        }
    }

    public VoteContent convertVoteContent(VoteUpdateReq voteUpdateReq) {
        return VoteContent.builder().id(voteUpdateReq.getVoteId())
                .content(voteUpdateReq.getContent())
                .updateTime(LocalDateTime.now())
                .updateUser(voteUpdateReq.getUpdateUser())
                .build();
    }

    public JSONObject convertCoteContentOptionForUpdate(VoteUpdateReq voteUpdateReq) {
        List<VoteOption> options = voteUpdateReq.getOptions();
        List<VoteContentOptions> voteContentOptions = new ArrayList<>();
        Integer voteId = voteUpdateReq.getVoteId();
        // 查询之前有的投票选项
        List<VoteContentOptions> beforeVoteContentOptions = voteContentOptionsService.list(new LambdaQueryWrapper<VoteContentOptions>()
                .eq(VoteContentOptions::getVoteId, voteId));
        List<VoteContentOptions> newVoteContentOptions = convertCoteContentOptionForUpdate(options, voteUpdateReq.getUpdateUser());

        // 求差集 部分没有的设置成新增，部分没有的设置成删除
        List<VoteContentOptions> tempList = new ArrayList<>();
        tempList.addAll(beforeVoteContentOptions);
        beforeVoteContentOptions.removeAll(newVoteContentOptions);
        JSONObject jsonObject = new JSONObject();
        jsonObject.fluentPut("delOption", beforeVoteContentOptions);
        newVoteContentOptions.removeAll(tempList);
        jsonObject.fluentPut("addOption", newVoteContentOptions);
        return jsonObject;
    }

    public List<VoteContentOptions> convertCoteContentOptionForUpdate(List<VoteOption> options, Integer createUserId) {
        List<VoteContentOptions> voteContentOptions = new ArrayList<>();
        options.stream().forEach(e -> {
           voteContentOptions.add(VoteContentOptions.builder().voteDescription(e.getOptionName())
                .delStatus(VoteConstant.NOT_DEL)
                .createTime(LocalDateTime.now())
                .createUser(createUserId)
                .build());
        });
        return voteContentOptions;
    }
}
