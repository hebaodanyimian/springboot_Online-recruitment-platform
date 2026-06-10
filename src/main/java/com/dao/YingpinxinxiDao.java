package com.dao;

import com.entity.YingpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YingpinxinxiVO;
import com.entity.view.YingpinxinxiView;


/**
 * 应聘信息
 * 
 * @author 
 * @email 
 * @date 2025-04-23 15:04:39
 */
public interface YingpinxinxiDao extends BaseMapper<YingpinxinxiEntity> {
	
	List<YingpinxinxiVO> selectListVO(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);
	
	YingpinxinxiVO selectVO(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);
	
	List<YingpinxinxiView> selectListView(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

	List<YingpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

	
	YingpinxinxiView selectView(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);



}
