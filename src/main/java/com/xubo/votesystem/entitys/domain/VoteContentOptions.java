package com.xubo.votesystem.entitys.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 投票选项表
 * @TableName vote_content_options
 */
public class VoteContentOptions implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 投票内容
     */
    private String voteDescription;

    /**
     * 投票表Id
     */
    private Integer voteId;

    /**
     * 删除状态
     */
    private Integer delStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
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
     * 投票内容
     */
    public String getVoteDescription() {
        return voteDescription;
    }

    /**
     * 投票内容
     */
    public void setVoteDescription(String voteDescription) {
        this.voteDescription = voteDescription;
    }

    /**
     * 投票表Id
     */
    public Integer getVoteId() {
        return voteId;
    }

    /**
     * 投票表Id
     */
    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
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
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
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
        VoteContentOptions other = (VoteContentOptions) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVoteDescription() == null ? other.getVoteDescription() == null : this.getVoteDescription().equals(other.getVoteDescription()))
            && (this.getVoteId() == null ? other.getVoteId() == null : this.getVoteId().equals(other.getVoteId()))
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
        result = prime * result + ((getVoteDescription() == null) ? 0 : getVoteDescription().hashCode());
        result = prime * result + ((getVoteId() == null) ? 0 : getVoteId().hashCode());
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
        sb.append(", voteDescription=").append(voteDescription);
        sb.append(", voteId=").append(voteId);
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