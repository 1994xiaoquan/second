package cn.e3mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.content.service.ContentCarService;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.TreeNode;



@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCarService  contentCarService;
	/**
	 * 查询:根据父id
	 * 路径: "/content/category/list"
	 * 参数: 查询的父id
	 * 返回值: pageresult
	 * 需要订阅服务
	 */
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<TreeNode> findCategoryTree(@RequestParam(defaultValue="0") Long id){
		//调用服务
		List<TreeNode> list = contentCarService.findCatTreeNode(id);
		return list;
	}
	/**
	 * 新增节点
	 * 路径:/content/category/create
	 * 参数: parentId:node.parentId,name:node.text
	 * 返回值: E3mallresult
	 */
	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3mallResult insertCat(Long parentId, String name) {
		E3mallResult e3mallResult = contentCarService.insertCat(parentId, name);
		return e3mallResult;
	}
	
	
}
