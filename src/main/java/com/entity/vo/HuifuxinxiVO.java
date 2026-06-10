package com.entity.vo;

import com.entity.HuifuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 回复信息
 * @author 
 * @email 
 * @date 2025-04-23 15:04:40
 */
public class HuifuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 面试时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date mianshishijian;
		
	/**
	 * 回复
	 */
	
	private String huifu;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
				
	
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
	 * 设置：面试时间
	 */
	 
	public void setMianshishijian(Date mianshishijian) {
		this.mianshishijian = mianshishijian;
	}
	
	/**
	 * 获取：面试时间
	 */
	public Date getMianshishijian() {
		return mianshishijian;
	}
				
	
	/**
	 * 设置：回复
	 */
	 
	public void setHuifu(String huifu) {
		this.huifu = huifu;
	}
	
	/**
	 * 获取：回复
	 */
	public String getHuifu() {
		return huifu;
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
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
			
}
