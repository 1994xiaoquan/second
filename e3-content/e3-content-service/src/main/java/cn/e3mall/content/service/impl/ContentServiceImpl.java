package cn.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;
@Service
public class ContentServiceImpl implements ContentService{
	
	@Autowired
	private TbContentMapper contentMapper;
	@Override
	public PageBeanResult selectContentPage(Long categoryId,Integer page,Integer rows) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		//创建pagehelper
		PageHelper.startPage(page, rows);
		List<TbContent> list = contentMapper.selectByExample(example);
		PageInfo<TbContent> info = new PageInfo<TbContent>(list);
		
		PageBeanResult result = new PageBeanResult();
		result.setTotal(info.getTotal());
		result.setRows(list);
		return result;
	}
	@Override
	public E3mallResult insertContent(TbContent content) {
		//补全信息
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		contentMapper.insert(content);
		return E3mallResult.ok();
	}

}
