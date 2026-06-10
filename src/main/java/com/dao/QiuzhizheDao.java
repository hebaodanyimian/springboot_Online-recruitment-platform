package com.dao;

import com.entity.QiuzhizheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiuzhizheVO;
import com.entity.view.QiuzhizheView;


/**
 * 求职者
 * 
 * @author 
 * @email 
 * @date 2025-04-23 15:04:39
 */
public interface QiuzhizheDao extends BaseMapper<QiuzhizheEntity> {
	
	List<QiuzhizheVO> selectListVO(@Param("ew") Wrapper<QiuzhizheEntity> wrapper);
	
	QiuzhizheVO selectVO(@Param("ew") Wrapper<QiuzhizheEntity> wrapper);
	
	List<QiuzhizheView> selectListView(@Param("ew") Wrapper<QiuzhizheEntity> wrapper);

	List<QiuzhizheView> selectListView(Pagination page,@Param("ew") Wrapper<QiuzhizheEntity> wrapper);

	
	QiuzhizheView selectView(@Param("ew") Wrapper<QiuzhizheEntity> wrapper);
	

}
