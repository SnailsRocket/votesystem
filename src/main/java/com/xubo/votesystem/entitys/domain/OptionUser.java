package com.xubo.votesystem.entitys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户投票选项表
 * @TableName option_user
 */
@TableName("option_user")
@Builder
public class OptionUser implements Serializable {
    /**
     * 投票选项id
     */
    private Integer optionId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 删除状态
     */
    private Integer delStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 投票选项id
     */
    public Integer getOptionId() {
        return optionId;
    }

    /**
     * 投票选项id
     */
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    /**
     * 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 删除状态
     */
    public Integer getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态
     */
    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OptionUser other = (OptionUser) that;
        return (this.getOptionId() == null ? other.getOptionId() == null : this.getOptionId().equals(other.getOptionId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDelStatus() == null ? other.getDelStatus() == null : this.getDelStatus().equals(other.getDelStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOptionId() == null) ? 0 : getOptionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDelStatus() == null) ? 0 : getDelStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", optionId=").append(optionId);
        sb.append(", userId=").append(userId);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}