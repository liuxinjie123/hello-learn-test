package com.springboot.easycode.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserTable)实体类
 *
 * @author makejava
 * @since 2020-06-08 16:52:52
 */
public class UserTable implements Serializable {
    private static final long serialVersionUID = 205130937169056153L;
    
    private Long id;
    
    private Date createTime;
    
    private String headName;
    
    private String headSix;
    
    private Integer isOnjob;
    
    private Integer isOnline;
    
    private String note;
    
    private String passWord;
    
    private String phone;
    
    private String userId;
    
    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getHeadSix() {
        return headSix;
    }

    public void setHeadSix(String headSix) {
        this.headSix = headSix;
    }

    public Integer getIsOnjob() {
        return isOnjob;
    }

    public void setIsOnjob(Integer isOnjob) {
        this.isOnjob = isOnjob;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}