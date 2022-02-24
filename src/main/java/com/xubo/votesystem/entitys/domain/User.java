package com.xubo.votesystem.entitys.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName user
 */
public class User implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 头像
     */
    private String image;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户标签
     */
    private String label;

    /**
     * 删除状态 0 未删  1 删除
     */
    private Integer delStatus;

    /**
     * 创建时间
     */
    private Date createTime;

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
     * 昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 昵称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 手机号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 头像
     */
    public String getImage() {
        return image;
    }

    /**
     * 头像
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 用户标签
     */
    public String getLabel() {
        return label;
    }

    /**
     * 用户标签
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 删除状态 0 未删  1 删除
     */
    public Integer getDelStatus() {
        return delStatus;
    }

    /**
     * 删除状态 0 未删  1 删除
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getDelStatus() == null ? other.getDelStatus() == null : this.getDelStatus().equals(other.getDelStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", tel=").append(tel);
        sb.append(", image=").append(image);
        sb.append(", address=").append(address);
        sb.append(", label=").append(label);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}