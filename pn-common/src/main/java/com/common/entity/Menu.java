
package com.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author QuiFar
 * @version V1.0
 * @Description: 系统菜单实体类
 * @date 2017年11月24日 下午20:53:00
 */
@Getter
@Setter
@ToString
public class Menu implements Serializable {

	private static final long serialVersionUID = -4716109663079532955L;

	private Integer menuId; /* menu_id */
	private Integer parentId; /* 父菜单ID，一级菜单为0 */
	private String name; /* 菜单名称 */
	private String url; /* 菜单URL */
	private Integer type; /* 类型 0：目录 1：菜单 2：按钮 */
	private String icon; /* 菜单图标 */
	private Integer orderNum; /* 排序 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime; /* 创建时间 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime; /* 修改时间 */
	private Integer status; /* 状态 1：正常，0：暂停 */

	// 角色菜单设置用到，其他没用
	private String isChecked;/* 该菜单是否勾选 */

}