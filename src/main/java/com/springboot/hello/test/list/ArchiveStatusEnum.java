package com.springboot.hello.test.list;

/**
 * Description: 档案管理状态枚举(表archive中的status)
 * Created by zc on 2020/8/25.
 * @author zhouchao
 */
public enum ArchiveStatusEnum {
    WAIT_SEAL("待盖章", 0),
    SEALED("已盖章", 1),
    WAIT_FILE("待归档", 2),
    FILED("已归档", 3),
    BOTH_SEALED_UP("双方盖章件已上传", 4),
    BOTH_SEALED_PASS("双方盖章件审核通过", 5),
    BOTH_SEALED_NOT_PASS("双方盖章件审核不通过", 6),
    COMMISSION_PASS("佣金标准审核通过", 7),
    DISABLED("已禁用", 8),
    WAIT_REVIEW("待复核", 9),
    NO_FILE("无归档", 10),
    IN_ACCESS("调档中", 11);

    private final String name;
    private final Integer value;

    ArchiveStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    /**
     * 根据value获取枚举值
     * @param value
     * @return
     */
    public static ArchiveStatusEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (ArchiveStatusEnum item : values()) {
            if (item.value == value.intValue()) {
                return item;
            }
        }
        return null;
    }

    /**
     * 根据value获取name
     * @param value
     * @return
     */
    public static String getNameByValue(Integer value) {
        ArchiveStatusEnum statusEnum = getEnumByValue(value);
        return statusEnum == null ? null : statusEnum.getName();
    }
}
