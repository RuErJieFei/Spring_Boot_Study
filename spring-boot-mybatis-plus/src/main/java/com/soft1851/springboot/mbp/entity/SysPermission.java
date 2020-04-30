package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yy
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_permission")
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("parent_id")
    private String parentId;

    @TableField("type")
    private String type;

    @TableField("name")
    private String name;

    @TableField("icon")
    private String icon;

    @TableField("path")
    private String path;

    @TableField("ex1")
    private String ex1;

    @TableField("ex2")
    private String ex2;

    private List<SysUser> users;

    private List<SysRole> roles;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
