package com.h2.admin.dto;


import com.h2.admin.entity.SysUser;

/**
 * @author lengleng
 * @date 2017/11/5
 */
public class UserDto extends SysUser {
    /**
     * 角色ID
     */
    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
