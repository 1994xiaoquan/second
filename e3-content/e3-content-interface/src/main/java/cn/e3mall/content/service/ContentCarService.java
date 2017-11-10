package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.TreeNode;

public interface ContentCarService {
	/**
	 * 参数: id
	 * 返回值: treebean
	 */
	public List<TreeNode> findCatTreeNode(Long id);
	/**
	 * 新增节点
	 * 路径:/content/category/create
	 * 参数: parentId:node.parentId,name:node.text
	 * 返回值: E3mallresult
	 */
	public E3mallResult insertCat(Long parentId,String text);
}
