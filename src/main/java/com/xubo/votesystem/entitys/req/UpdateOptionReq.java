package com.xubo.votesystem.entitys.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xubo
 * @Date 2022/2/25 11:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateOptionReq {

    private Integer voteId;

    private Integer newOptionId;

    private Integer oldOptionId;

    private Integer userId;
}
