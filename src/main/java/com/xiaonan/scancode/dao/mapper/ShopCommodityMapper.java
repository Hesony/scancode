package com.xiaonan.scancode.dao.mapper;

import com.xiaonan.scancode.dao.ShopCommodity;

import com.xiaonan.scancode.model.models.ShopCommodityModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ShopCommodityMapper {

	@Insert("insert into shop_commodity " +
			"(shop_id, outer_item_id, goods_title)" +
			"values(" +
			"#{shopId,jdbcType=VARCHAR}," +
			"#{outerItemId,jdbcType=VARCHAR}," +
			"#{goodsTitle,jdbcType=VARCHAR})")
	int insertByObject(ShopCommodity shopCommodity);


	@Delete("delete from shop_commodity " +
			"where outer_item_id=#{outerItemId,jdbcType=VARCHAR}"
	)
	int deleteByItemId(String outerItemId);


	@Select("select shop_id, outer_item_id, goods_title from shop_commodity"
	)
	@Results({
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_title", property = "goodsTitle", jdbcType = JdbcType.VARCHAR)
	})
	List<ShopCommodity> selectAllShopCommodity();


	@Select("select shop_id, outer_item_id, goods_title from shop_commodity " +
			"where outer_item_id=#{outerItemId,jdbcType=VARCHAR}"
	)
	@Results({
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_title", property = "goodsTitle", jdbcType = JdbcType.VARCHAR)
	})
	ShopCommodity selectShopCommodityByItemId(String outerItemId);


	@Select("select a.shop_id, b.shop_name, a.outer_item_id, a.goods_title " +
			"from shop_commodity a " +
			"left join shop_info b " +
			"on a.shop_id = b.shop_id"
	)
	@Results({
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shop_name", property = "shopName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_title", property = "goodsTitle", jdbcType = JdbcType.VARCHAR)
	})
	List<ShopCommodityModel> selectAllShopCommodityModel();

	@Select("select a.shop_id, b.shop_name, a.outer_item_id, a.goods_title " +
			"from shop_commodity a " +
			"left join shop_info b " +
			"on a.shop_id = b.shop_id " +
			"where outer_item_id=#{outerItemId,jdbcType=VARCHAR}"
	)
	@Results({
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "shop_name", property = "shopName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_title", property = "goodsTitle", jdbcType = JdbcType.VARCHAR)
	})
	ShopCommodityModel selectShopCommodityModelByItemId(String outerItemId);

}
