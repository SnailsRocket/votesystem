package com.xubo.votesystem.entitys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 投票表
 * @TableName vote_content
 */
@TableName("vote_content")
@Data
@Builder
public class VoteContent implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 投票主题
     */
    private String content;

    /**
     * 过期状态
     */
    private Integer expiredStatus;

    /**
     * 过期时间  不设置 默认 24小时
     */
    private Integer expiredTime;

    /**
     * 删除状态
     */
    private Integer delStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人id
     */
    private Integer createUser;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人id
     */
    private Integer updateUser;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 投票主题
     */
    public String getContent() {
        return content;
    }

    /**
     * 投票主题
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 过期状态
     */
    public Integer getExpiredStatus() {
        return expiredStatus;
    }

    /**
     * 过期状态
     */
    public void setExpiredStatus(Integer expiredStatus) {
        this.expiredStatus = expiredStatus;
    }

    /**
     * 过期时间  不设置 默认 24小时
     */
    public Integer getExpiredTime() {
        return expiredTime;
    }

    /**
     * 过期时间  不设置 默认 24小时
     */
    public void setExpiredTime(Integer expiredTime) {
        this.expiredTime = expiredTime;
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

    /**
     * 创建人id
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 创建人id
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 修改时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人id
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人id
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
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
        VoteContent other = (VoteContent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getExpiredStatus() == null ? other.getExpiredStatus() == null : this.getExpiredStatus().equals(other.getExpiredStatus()))
            && (this.getExpiredTime() == null ? other.getExpiredTime() == null : this.getExpiredTime().equals(other.getExpiredTime()))
            && (this.getDelStatus() == null ? other.getDelStatus() == null : this.getDelStatus().equals(other.getDelStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getExpiredStatus() == null) ? 0 : getExpiredStatus().hashCode());
        result = prime * result + ((getExpiredTime() == null) ? 0 : getExpiredTime().hashCode());
        result = prime * result + ((getDelStatus() == null) ? 0 : getDelStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", expiredStatus=").append(expiredStatus);
        sb.append(", expiredTime=").append(expiredTime);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}