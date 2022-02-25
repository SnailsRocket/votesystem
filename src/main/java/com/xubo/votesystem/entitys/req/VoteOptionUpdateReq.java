package com.xubo.votesystem.entitys.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xubo
 * @Date 2022/2/24 17:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteOptionUpdateReq {

    private Integer optionId;

    private String optionDescription;

    private Integer updateUserId;

}
