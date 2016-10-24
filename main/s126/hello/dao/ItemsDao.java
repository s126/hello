package s126.hello.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import s126.hello.bean.Item;
import s126.hello.util.DBUtil;


/**
 * Dao 是进行数据库连接的类
 */
public class ItemsDao {

	// 查询所有商品
	public List<Item> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Item> items = new ArrayList<Item>();

		try {

			String sql = "select item_id, item_name, item_price, create_time, status from items_info";

			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				items.add(new Item(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getInt(5)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}

		return items;
	}

	// 按照 status 查询商品
	public List<Item> getByStatus(int status) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Item> items = new ArrayList<Item>();

		try {

			String sql = "select item_id, item_name, item_price, create_time, status from items_info "
					+ "where status = ?";

			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			rs = ps.executeQuery();

			while (rs.next()) {
				items.add(new Item(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getInt(5)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}

		return items;
	}

	// 更改上下架状态
	public boolean changeStatus(int id, int status) {
		Connection conn = null;
		PreparedStatement ps = null;

		boolean res = true;

		try {
			conn = DBUtil.getConn();

			String sql = "update items_info set status=? where item_id=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.execute();

		} catch (Exception e) {
			res = false;
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}

		return res;
	}

	// 增加新商品
	public boolean addItem(Item item) {
		Connection conn = null;
		PreparedStatement ps = null;

		boolean res = true;

		try {
			conn = DBUtil.getConn();

			String sql = "insert into items_info (item_id, item_name, item_price, create_time, status) values (seq_items.nextval, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setFloat(2, item.getPrice());
			ps.setDate(3, new Date(item.getCdate().getTime()));
			ps.setInt(4, item.getStatus());
			ps.execute();

		} catch (Exception e) {
			res = false;
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(new ItemsDao().getAll());
	}

}
