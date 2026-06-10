package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 应聘信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-23 15:04:39
 */
@TableName("yingpinxinxi")
public class YingpinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YingpinxinxiEntity() {
		
	}
	
	public YingpinxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 职位类型
	 */
					
	private String zhiweileixing;
	
	/**
	 * 招聘封面
	 */
					
	private String zhaopinfengmian;
	
	/**
	 * 应聘日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date yingpinriqi;
	
	/**
	 * 简历
	 */
					
	private String jianli;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 评论数
	 */
					
	private Integer discussnum;
	
	/**
	 * 评分
	 */
					
	private Double totalscore;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
	/**
	 * 设置：企业名称
	 */
	public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
	}
	/**
	 * 获取：企业名称
	 */
	public String getQiyemingcheng() {
		return qiyemingcheng;
	}
	/**
	 * 设置：职位类型
	 */
	public void setZhiweileixing(String zhiweileixing) {
		this.zhiweileixing = zhiweileixing;
	}
	/**
	 * 获取：职位类型
	 */
	public String getZhiweileixing() {
		return zhiweileixing;
	}
	/**
	 * 设置：招聘封面
	 */
	public void setZhaopinfengmian(String zhaopinfengmian) {
		this.zhaopinfengmian = zhaopinfengmian;
	}
	/**
	 * 获取：招聘封面
	 */
	public String getZhaopinfengmian() {
		return zhaopinfengmian;
	}
	/**
	 * 设置：应聘日期
	 */
	public void setYingpinriqi(Date yingpinriqi) {
		this.yingpinriqi = yingpinriqi;
	}
	/**
	 * 获取：应聘日期
	 */
	public Date getYingpinriqi() {
		return yingpinriqi;
	}
	/**
	 * 设置：简历
	 */
	public void setJianli(String jianli) {
		this.jianli = jianli;
	}
	/**
	 * 获取：简历
	 */
	public String getJianli() {
		return jianli;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：评论数
	 */
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
	/**
	 * 设置：评分
	 */
	public void setTotalscore(Double totalscore) {
		this.totalscore = totalscore;
	}
	/**
	 * 获取：评分
	 */
	public Double getTotalscore() {
		return totalscore;
	}

}
