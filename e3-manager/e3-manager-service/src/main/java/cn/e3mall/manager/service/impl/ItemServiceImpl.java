package cn.e3mall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.utils.PageBeanResult;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper itemMapper;
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

}
