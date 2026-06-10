package com.dao;

import com.entity.MianshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MianshixinxiVO;
import com.entity.view.MianshixinxiView;


/**
 * 面试信息
 * 
 * @author 
 * @email 
 * @date 2025-04-23 15:04:40
 */
public interface MianshixinxiDao extends BaseMapper<MianshixinxiEntity> {
	
	List<MianshixinxiVO> selectListVO(@Param("ew") Wrapper<MianshixinxiEntity> wrapper);
	
	MianshixinxiVO selectVO(@Param("ew") Wrapper<MianshixinxiEntity> wrapper);
	
	List<MianshixinxiView> selectListView(@Param("ew") Wrapper<MianshixinxiEntity> wrapper);

	List<MianshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<MianshixinxiEntity> wrapper);

	
	MianshixinxiView selectView(@Param("ew") Wrapper<MianshixinxiEntity> wrapper);
	

}
