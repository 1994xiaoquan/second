package cn.e3mall.content.service;

import cn.e3mall.pojo.TbContent;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

public interface ContentService {
	/**
	 * 分页分类显示
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	public  PageBeanResult selectContentPage(Long categoryId,Integer page,Integer rows);
	
	/**
	 * 新增
	 * 
	 */
	public E3mallResult insertContent(TbContent content);
}
