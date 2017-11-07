package cn.e3mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.utils.TreeNode;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	/**
	 * 实现根据父id查询子节点
	 * 请求:/item/cat/list
	 * 参数:  parentid(实际上必须是id)
	 * 返回值:List<TreeNode>
	 * 在页面初始化过程中发送请求,需要初始化顶级父节点,也就是parentid='0' 的使用默认值
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> findItemWithParentId(@RequestParam(value="id",defaultValue="0") Long parentId){
		//调用远程service服务方法查询
		List<TreeNode> list = itemCatService.findItemCatWithParentId(parentId);
		
		return list;
	}
}
