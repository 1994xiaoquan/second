package cn.e3mall.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.utils.TreeNode;
@Service
public class ItemCatServiceImpl implements ItemCatService{

	//注入dao
	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<TreeNode> findItemCatWithParentId(Long parentId) {
		//创建查询对象
		TbItemCatExample example = new TbItemCatExample();
		//添加条件
		Criteria criteria = example.createCriteria();
		//设置查询参数(使用parentid = "" 查询)
		criteria.andParentIdEqualTo(parentId);
		//执行查询返回list集合
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//封装到需要的list集合中
		List<TreeNode> treelist = new ArrayList<TreeNode>();
		//循环list给treelist赋值
		for (TbItemCat itemcat : list) {
			//创建tree节点封装单个treenode添加到treelist
			TreeNode treeNode = new TreeNode();
			treeNode.setId(itemcat.getId());
			treeNode.setText(itemcat.getName());
			treeNode.setState(itemcat.getIsParent()?"closed":"open"); 
			treelist.add(treeNode);
		}
		return treelist;
	}

}
