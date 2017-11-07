package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

public interface ItemService {
	/**
	 * 根据id查询
	 */
	public TbItem findItemById(Long itemId);
	
	/*
	 * 分页查询
	 */
	public PageBeanResult  getListByPage(Integer page,Integer rows);
}
