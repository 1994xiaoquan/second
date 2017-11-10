package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.utils.E3mallResult;

@Controller
public class ItemController {
	
	
	
	@Autowired
	private ItemService itemService;
	/**
	 * 测试访问查询
	 * 
	 */
	
	
	@RequestMapping("item/findItem/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId ){
		return itemService.findItemById(itemId);
	}
	
	//新增商品
	@RequestMapping("/item/save")
	@ResponseBody
	public E3mallResult insertItem(TbItem tbitem, TbItemDesc itemdesc){
		E3mallResult result = itemService.insertItem(tbitem, itemdesc);
		return result;
	}
	
}
