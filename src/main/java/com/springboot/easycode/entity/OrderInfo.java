package com.springboot.easycode.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrderInfo)实体类
 *
 * @author makejava
 * @since 2020-06-08 17:06:32
 */
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -82266276671455524L;
    
    private Long id;
    
    private String acttype;
    
    private String alertkey;
    
    private String devtype;
    
    private String fixalarmlevel;
    
    private Date issuedate;
    
    private String liabilitycity;
    
    private String location;
    
    private String networklevel;
    
    private String operationtype;
    
    private String returnresult;
    
    private String stickevent;
    
    private String suspectfaultreasonclass;
    
    private String suspectfaultreasonsection;
    
    private String tasktitle;
    
    private String tempstr3;
    
    private String tolllevel;
    
    private String worktip;
    
    private String wsid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActtype() {
        return acttype;
    }

    public void setActtype(String acttype) {
        this.acttype = acttype;
    }

    public String getAlertkey() {
        return alertkey;
    }

    public void setAlertkey(String alertkey) {
        this.alertkey = alertkey;
    }

    public String getDevtype() {
        return devtype;
    }

    public void setDevtype(String devtype) {
        this.devtype = devtype;
    }

    public String getFixalarmlevel() {
        return fixalarmlevel;
    }

    public void setFixalarmlevel(String fixalarmlevel) {
        this.fixalarmlevel = fixalarmlevel;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public String getLiabilitycity() {
        return liabilitycity;
    }

    public void setLiabilitycity(String liabilitycity) {
        this.liabilitycity = liabilitycity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNetworklevel() {
        return networklevel;
    }

    public void setNetworklevel(String networklevel) {
        this.networklevel = networklevel;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype;
    }

    public String getReturnresult() {
        return returnresult;
    }

    public void setReturnresult(String returnresult) {
        this.returnresult = returnresult;
    }

    public String getStickevent() {
        return stickevent;
    }

    public void setStickevent(String stickevent) {
        this.stickevent = stickevent;
    }

    public String getSuspectfaultreasonclass() {
        return suspectfaultreasonclass;
    }

    public void setSuspectfaultreasonclass(String suspectfaultreasonclass) {
        this.suspectfaultreasonclass = suspectfaultreasonclass;
    }

    public String getSuspectfaultreasonsection() {
        return suspectfaultreasonsection;
    }

    public void setSuspectfaultreasonsection(String suspectfaultreasonsection) {
        this.suspectfaultreasonsection = suspectfaultreasonsection;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public String getTempstr3() {
        return tempstr3;
    }

    public void setTempstr3(String tempstr3) {
        this.tempstr3 = tempstr3;
    }

    public String getTolllevel() {
        return tolllevel;
    }

    public void setTolllevel(String tolllevel) {
        this.tolllevel = tolllevel;
    }

    public String getWorktip() {
        return worktip;
    }

    public void setWorktip(String worktip) {
        this.worktip = worktip;
    }

    public String getWsid() {
        return wsid;
    }

    public void setWsid(String wsid) {
        this.wsid = wsid;
    }

}