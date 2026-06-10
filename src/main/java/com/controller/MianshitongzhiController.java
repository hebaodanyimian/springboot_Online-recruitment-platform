package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MianshitongzhiEntity;
import com.entity.view.MianshitongzhiView;

import com.service.MianshitongzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 面试通知
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-23 15:04:40
 */
@RestController
@RequestMapping("/mianshitongzhi")
public class MianshitongzhiController {
    @Autowired
    private MianshitongzhiService mianshitongzhiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MianshitongzhiEntity mianshitongzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiyeyonghu")) {
			mianshitongzhi.setGonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qiuzhizhe")) {
			mianshitongzhi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<MianshitongzhiEntity> ew = new EntityWrapper<MianshitongzhiEntity>();


        //查询结果
		PageUtils page = mianshitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshitongzhi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MianshitongzhiEntity mianshitongzhi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<MianshitongzhiEntity> ew = new EntityWrapper<MianshitongzhiEntity>();

        //查询结果
		PageUtils page = mianshitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshitongzhi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MianshitongzhiEntity mianshitongzhi){
       	EntityWrapper<MianshitongzhiEntity> ew = new EntityWrapper<MianshitongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mianshitongzhi, "mianshitongzhi")); 
        return R.ok().put("data", mianshitongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MianshitongzhiEntity mianshitongzhi){
        EntityWrapper< MianshitongzhiEntity> ew = new EntityWrapper< MianshitongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mianshitongzhi, "mianshitongzhi")); 
		MianshitongzhiView mianshitongzhiView =  mianshitongzhiService.selectView(ew);
		return R.ok("查询面试通知成功").put("data", mianshitongzhiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MianshitongzhiEntity mianshitongzhi = mianshitongzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(mianshitongzhi,deSens);
        return R.ok().put("data", mianshitongzhi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MianshitongzhiEntity mianshitongzhi = mianshitongzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(mianshitongzhi,deSens);
        return R.ok().put("data", mianshitongzhi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MianshitongzhiEntity mianshitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshitongzhi);
        mianshitongzhiService.insert(mianshitongzhi);
        return R.ok().put("data",mianshitongzhi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MianshitongzhiEntity mianshitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshitongzhi);
        mianshitongzhiService.insert(mianshitongzhi);
        return R.ok().put("data",mianshitongzhi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MianshitongzhiEntity mianshitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshitongzhi);
        //全部更新
        mianshitongzhiService.updateById(mianshitongzhi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mianshitongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
