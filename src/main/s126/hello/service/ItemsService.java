package s126.hello.service;

import java.util.List;

import s126.hello.bean.Item;
import s126.hello.dao.ItemsDao;


/**
 * 这是写业务逻辑的一个类
 */
public class ItemsService {

	private ItemsDao itemsDao = new ItemsDao();

	
	// 显示所有商品，这里可以进行我们详细业务逻辑的处理
	public List<Item> listAll(int status) {
		
		// 改进，增加 status参数，如果为0或1，那么单独查找上架或下架，否则查询全部
		List<Item> items = null;
		if(status == 0 || status == 1)
			items = itemsDao.getByStatus(status);
		else
			items = itemsDao.getAll();

		System.out.println(items);

		if (items.isEmpty())
			return null;
		return items;
	}
	
	// 切换上架，下架
	public boolean changeStatus(Item item, int status) {
		return itemsDao.changeStatus(item.getId(), status);
	}
	
	// 新增商品
	public boolean addItem(Item item) {
		return itemsDao.addItem(item);
	}

}
