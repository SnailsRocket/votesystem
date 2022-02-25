package com.xubo.votesystem.entitys.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author xubo
 * @Date 2022/2/24 16:48
 * 投票模板
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteTemplate {

    private Integer id;

    /**
     * 投票标题
     */
    private String content;

    /**
     * 投票选项
     */
    private List<VoteOption> voreOptions;

    /**
     * 创建人Id
     */
    private Integer createId;


}
