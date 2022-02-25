package com.xubo.votesystem.entitys.req;

import com.xubo.votesystem.entitys.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author xubo
 * @Date 2022/2/24 16:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteOption {

    private  Integer optionId;

    private String optionName;

    private List<User> users;

}
