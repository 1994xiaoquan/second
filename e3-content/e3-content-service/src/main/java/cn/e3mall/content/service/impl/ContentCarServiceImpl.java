package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.e3mall.content.service.ContentCarService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.TreeNode;
@Service
public class ContentCarServiceImpl implements ContentCarService{
	
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	/**
	 * 参数: 查询的父id
	 * 返回值: pageresult
	 * 需要订阅服务
	 */

	@Override
	public List<TreeNode> findCatTreeNode(Long id) { 
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<TreeNode> treenodelist= new ArrayList<TreeNode>();
		for (TbContentCategory tbContentCategory : list) {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(tbContentCategory.getId());
			treeNode.setState(tbContentCategory.getIsParent()?"closed":"open");
			treeNode.setText(tbContentCategory.getName());
			treenodelist.add(treeNode);
		}
		
		return treenodelist;
	}
	/**
	 * 新增节点
	 * 路径:/content/category/create
	 * 参数: parentId:node.parentId,name:node.text
	 * 返回值: E3mallresult
	 */
	@Override
	public E3mallResult insertCat(Long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		//设置搜索顺序
		contentCategory.setSortOrder(1);
		//设置状态
		contentCategory.setStatus(1);
		//设置isparent
		contentCategory.setIsParent(false);
		//设置时间
		Date data = new Date();
		contentCategory.setCreated(data);
		contentCategory.setUpdated(data);
		//增加
		contentCategoryMapper.insert(contentCategory);
		//判断是否其父类是子节点
		TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!parent.getIsParent()){
			//改变父的isparent
			parent.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parent);
		}
		return E3mallResult.ok(contentCategory);
	}
	
	
}
