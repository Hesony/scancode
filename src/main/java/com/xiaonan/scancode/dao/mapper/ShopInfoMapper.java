package com.xiaonan.scancode.dao.mapper;

import com.xiaonan.scancode.dao.ShopInfo;
import com.xiaonan.scancode.dao.StaffInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ShopInfoMapper {


	@Insert("insert into shop_info " +
			"(shop_id, shop_name)" +
			"values(" +
			"#{shopId,jdbcType=VARCHAR}," +
			"#{shopName,jdbcType=VARCHAR})")
	int insertByObject(ShopInfo shopInfo);


	@Select("select shop_id,shop_name from " +
			"shop_info " +
			"where shop_name=#{shopName,jdbcType=VARCHAR}")
	@Results({
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shop_name", property = "shopName", jdbcType = JdbcType.VARCHAR),
	})
	ShopInfo selectByShopName(String shopName);


	@Select("select shop_id,shop_name from " +
			"shop_info " +
			"where shop_id=#{shopId,jdbcType=VARCHAR}")
	@Results({
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shop_name", property = "shopName", jdbcType = JdbcType.VARCHAR),
	})
	ShopInfo selectByShopId(String shopId);



	@Select("select shop_id,shop_name from shop_info"
	)
	@Results({
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shop_name", property = "shopName", jdbcType = JdbcType.VARCHAR),
	})
	List<ShopInfo> selectAllShop();

	@Delete("delete from shop_info " +
			"where shop_id=#{shopId,jdbcType=VARCHAR}")
	void deleteShop(String shopId);
}
