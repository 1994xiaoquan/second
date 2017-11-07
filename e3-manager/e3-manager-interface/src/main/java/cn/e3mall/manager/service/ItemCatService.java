package cn.e3mall.manager.service;

import java.util.List;

import cn.e3mall.utils.TreeNode;

public interface ItemCatService {
	/**
	 * 根据父类id查询子节点,按需加载
	 * 参数是:parentid 
	 * 返回值:List<TreeNode>
	 */
	public List<TreeNode> findItemCatWithParentId(Long parentId);
}
