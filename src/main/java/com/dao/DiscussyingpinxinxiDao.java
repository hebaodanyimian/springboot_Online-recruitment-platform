package com.dao;

import com.entity.DiscussyingpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyingpinxinxiVO;
import com.entity.view.DiscussyingpinxinxiView;


/**
 * 应聘信息评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-23 15:04:41
 */
public interface DiscussyingpinxinxiDao extends BaseMapper<DiscussyingpinxinxiEntity> {
	
	List<DiscussyingpinxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussyingpinxinxiEntity> wrapper);
	
	DiscussyingpinxinxiVO selectVO(@Param("ew") Wrapper<DiscussyingpinxinxiEntity> wrapper);
	
	List<DiscussyingpinxinxiView> selectListView(@Param("ew") Wrapper<DiscussyingpinxinxiEntity> wrapper);

	List<DiscussyingpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyingpinxinxiEntity> wrapper);

	
	DiscussyingpinxinxiView selectView(@Param("ew") Wrapper<DiscussyingpinxinxiEntity> wrapper);
	

}
