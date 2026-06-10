package com.entity.view;

import com.entity.QiyeyonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 企业用户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-23 15:04:39
 */
@TableName("qiyeyonghu")
public class QiyeyonghuView  extends QiyeyonghuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QiyeyonghuView(){
	}
 
 	public QiyeyonghuView(QiyeyonghuEntity qiyeyonghuEntity){
 	try {
			BeanUtils.copyProperties(this, qiyeyonghuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
