package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyingpinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyingpinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyingpinxinxiView;


/**
 * 应聘信息评论表
 *
 * @author 
 * @email 
 * @date 2025-04-23 15:04:41
 */
public interface DiscussyingpinxinxiService extends IService<DiscussyingpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyingpinxinxiVO> selectListVO(Wrapper<DiscussyingpinxinxiEntity> wrapper);
   	
   	DiscussyingpinxinxiVO selectVO(@Param("ew") Wrapper<DiscussyingpinxinxiEntity> wrapper);
   	
   	List<DiscussyingpinxinxiView> selectListView(Wrapper<DiscussyingpinxinxiEntity> wrapper);
   	
   	DiscussyingpinxinxiView selectView(@Param("ew") Wrapper<DiscussyingpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyingpinxinxiEntity> wrapper);

   	

}

