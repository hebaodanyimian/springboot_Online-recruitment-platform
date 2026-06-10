package com.dao;

import com.entity.QiyeyonghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiyeyonghuVO;
import com.entity.view.QiyeyonghuView;


/**
 * 企业用户
 * 
 * @author 
 * @email 
 * @date 2025-04-23 15:04:39
 */
public interface QiyeyonghuDao extends BaseMapper<QiyeyonghuEntity> {
	
	List<QiyeyonghuVO> selectListVO(@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);
	
	QiyeyonghuVO selectVO(@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);
	
	List<QiyeyonghuView> selectListView(@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);

	List<QiyeyonghuView> selectListView(Pagination page,@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);

	
	QiyeyonghuView selectView(@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);
	

}
