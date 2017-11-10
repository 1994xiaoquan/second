package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;
import cn.e3mall.utils.PictureResult;

public interface ItemService {
	/**
	 * 根据id查询
	 */
	public TbItem findItemById(Long itemId);
	
	/*
	 * 分页查询
	 */
	public PageBeanResult  getListByPage(Integer page,Integer rows);
	
	/**
	 * 添加商品
	 * 
	 * 参数:Tbitem, IbItemDesc
	 * 返回值:E3mallResult
	 */
	public E3mallResult  insertItem(TbItem tbitem,TbItemDesc itemdesc);
	
}
