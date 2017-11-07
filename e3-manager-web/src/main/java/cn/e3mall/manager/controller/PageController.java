package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.utils.PageBeanResult;

@Controller
public class PageController {
	@Autowired
	private ItemService  itemService;
	/*
	 * 商品的页面跳转(resuful风格的路径)
	 *一个方法处理多个跳转,跳转页面必须符合这个跳转规则
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	/*
	 * 分页查询
	 * 返回分页对象
	 * 需要检查是否引用(消费者)
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public PageBeanResult getListByPage(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="20") Integer rows){
		PageBeanResult result = itemService.getListByPage(page, rows);
		return result;
	}
}
