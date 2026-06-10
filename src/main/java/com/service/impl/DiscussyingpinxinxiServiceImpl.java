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


import com.dao.DiscussyingpinxinxiDao;
import com.entity.DiscussyingpinxinxiEntity;
import com.service.DiscussyingpinxinxiService;
import com.entity.vo.DiscussyingpinxinxiVO;
import com.entity.view.DiscussyingpinxinxiView;

@Service("discussyingpinxinxiService")
public class DiscussyingpinxinxiServiceImpl extends ServiceImpl<DiscussyingpinxinxiDao, DiscussyingpinxinxiEntity> implements DiscussyingpinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyingpinxinxiEntity> page = this.selectPage(
                new Query<DiscussyingpinxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyingpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyingpinxinxiEntity> wrapper) {
		  Page<DiscussyingpinxinxiView> page =new Query<DiscussyingpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyingpinxinxiVO> selectListVO(Wrapper<DiscussyingpinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyingpinxinxiVO selectVO(Wrapper<DiscussyingpinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyingpinxinxiView> selectListView(Wrapper<DiscussyingpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyingpinxinxiView selectView(Wrapper<DiscussyingpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
