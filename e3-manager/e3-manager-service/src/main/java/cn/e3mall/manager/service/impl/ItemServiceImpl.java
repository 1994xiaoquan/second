package cn.e3mall.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.IDUtils;
import cn.e3mall.utils.PageBeanResult;
import cn.e3mall.utils.PictureResult;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper  itemDescMapper;
	@Override
	public TbItem findItemById(Long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}
	@Override
	public PageBeanResult getListByPage(Integer page, Integer rows) {
		
		
		//创建example
		TbItemExample exmaple = new TbItemExample();
		//使用插件进行分页查询(在查询前进行分页操作)
		PageHelper.startPage(page, rows);
		//自动执行分页查询
		List<TbItem> list = itemMapper.selectByExample(exmaple);
		//创建PageInfo对象
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//封装分页对象
		PageBeanResult result= new PageBeanResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}
	/**
	 * 
	 */
	public E3mallResult insertItem(TbItem item, TbItemDesc desc) {
		//补全属性
		//id
		//
		//设置Id
		//使用工具类生成ID
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//补全时间类型
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		//补全类型
		item.setStatus((byte)1);
		//保存商品
		itemMapper.insert(item);
		//补全商品描述信息属性
		desc.setItemId(itemId);
		desc.setCreated(date);
		desc.setUpdated(date);
		itemDescMapper.insert(desc);
		return E3mallResult.ok();
	}

}
