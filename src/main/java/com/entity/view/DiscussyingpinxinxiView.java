package com.entity.view;

import com.entity.DiscussyingpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 应聘信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-23 15:04:41
 */
@TableName("discussyingpinxinxi")
public class DiscussyingpinxinxiView  extends DiscussyingpinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussyingpinxinxiView(){
	}
 
 	public DiscussyingpinxinxiView(DiscussyingpinxinxiEntity discussyingpinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussyingpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
