package com.springboot.hello.test.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * （项目资料）楼盘资料
 */
@Data
@NoArgsConstructor
public class ProjectFile implements Serializable {

    /** id */
    private Long id;
    /**
     * 创建人
     */
    private Long creater;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private Long modifier;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 版本号
     */
    private Long version;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 资料类别 1:普通文件 2：音视频
     */
    private Integer fileType;
    /**
     * 资料名称
     */
    private String fileName;
    /**
     * 资料路径
     */
    private String fileUrl;
    /**
     * 0:未删除 1:已删除
     */
    private Integer logicDelete;
    /**
     * 项目资料类型， 例如：doc，pdf，txt，JPG，PNG，MP4
     */
    private String type;
    /**
     * 项目文件中的文本内容
     */
    private String words;

}