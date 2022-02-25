package com.xubo.votesystem.entitys.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author xubo
 * @Date 2022/2/24 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteUpdateReq {

    private Integer voteId;

    private String content;

    private List<VoteOption> options;

    private LocalDateTime createTime;

}
