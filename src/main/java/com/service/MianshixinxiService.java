package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MianshixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MianshixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MianshixinxiView;


/**
 * 面试信息
 *
 * @author 
 * @email 
 * @date 2025-04-23 15:04:40
 */
public interface MianshixinxiService extends IService<MianshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshixinxiVO> selectListVO(Wrapper<MianshixinxiEntity> wrapper);
   	
   	MianshixinxiVO selectVO(@Param("ew") Wrapper<MianshixinxiEntity> wrapper);
   	
   	List<MianshixinxiView> selectListView(Wrapper<MianshixinxiEntity> wrapper);
   	
   	MianshixinxiView selectView(@Param("ew") Wrapper<MianshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshixinxiEntity> wrapper);

   	

}

