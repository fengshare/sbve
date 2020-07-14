package com.xf.web.common.enums;

/**
 * @author xf
 */

public enum DbStatus {
    不可用(0), 可用(1), Y(1), N(0);

    private Integer value;

    DbStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static DbStatus fromString(Integer value) {
        DbStatus rtn = null;
        for (DbStatus item : DbStatus.values()) {
            if (item.value.equals(value)) {
                rtn = item;
                break;
            }
        }
        return rtn;
    }
}
