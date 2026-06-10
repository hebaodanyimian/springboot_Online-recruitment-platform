package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.MianshixinxiDao;
import com.entity.MianshixinxiEntity;
import com.service.MianshixinxiService;
import com.entity.vo.MianshixinxiVO;
import com.entity.view.MianshixinxiView;

@Service("mianshixinxiService")
public class MianshixinxiServiceImpl extends ServiceImpl<MianshixinxiDao, MianshixinxiEntity> implements MianshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshixinxiEntity> page = this.selectPage(
                new Query<MianshixinxiEntity>(params).getPage(),
                new EntityWrapper<MianshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshixinxiEntity> wrapper) {
		  Page<MianshixinxiView> page =new Query<MianshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MianshixinxiVO> selectListVO(Wrapper<MianshixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MianshixinxiVO selectVO(Wrapper<MianshixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MianshixinxiView> selectListView(Wrapper<MianshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshixinxiView selectView(Wrapper<MianshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
