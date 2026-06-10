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


import com.dao.QiuzhizheDao;
import com.entity.QiuzhizheEntity;
import com.service.QiuzhizheService;
import com.entity.vo.QiuzhizheVO;
import com.entity.view.QiuzhizheView;

@Service("qiuzhizheService")
public class QiuzhizheServiceImpl extends ServiceImpl<QiuzhizheDao, QiuzhizheEntity> implements QiuzhizheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiuzhizheEntity> page = this.selectPage(
                new Query<QiuzhizheEntity>(params).getPage(),
                new EntityWrapper<QiuzhizheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiuzhizheEntity> wrapper) {
		  Page<QiuzhizheView> page =new Query<QiuzhizheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QiuzhizheVO> selectListVO(Wrapper<QiuzhizheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiuzhizheVO selectVO(Wrapper<QiuzhizheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiuzhizheView> selectListView(Wrapper<QiuzhizheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiuzhizheView selectView(Wrapper<QiuzhizheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
