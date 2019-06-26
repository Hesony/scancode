package com.xiaonan.scancode.dao.mapper;


import com.xiaonan.scancode.dao.VerifyLog;
import com.xiaonan.scancode.model.models.VerifyLogModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface VerifyLogMapper {

	@Insert("insert into verify_log " +
			"(openid, outer_item_id, goods_title, ticket_code, tid, scan_code, create_time) " +
			"values(" +
			"#{openid,jdbcType=VARCHAR}," +
			"#{outerItemId,jdbcType=VARCHAR}," +
			"#{goodsTitle,jdbcType=VARCHAR}," +
			"#{ticketCode,jdbcType=VARCHAR}," +
			"#{tid,jdbcType=VARCHAR}," +
			"#{scanCode,jdbcType=VARCHAR}," +
			"SUBSTR(date_format(now(3),'%Y-%m-%d %H:%i:%s:%f'),1,19)" +
			")")
	int insertByObject(VerifyLog verifyLog);


	@Select("select openid,outer_item_id,ticket_code,tid,scan_code,create_time from " +
			"verify_log order by create_time desc")
	@Results({
			@Result(column = "openid", property = "openid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ticket_code", property = "ticketCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "tid", property = "tid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "scan_code", property = "scanCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.VARCHAR)
	})
	List<VerifyLog> selectAllVerifyLog();



	@Select("select c.shop_name, a.outer_item_id, a.goods_title, a.openid, b.nickname, a.ticket_code, a.tid, a.scan_code, a.create_time " +
			"from verify_log a LEFT JOIN staff_info b on a.openid = b.openid " +
			"left join shop_info c on b.shop_id = c.shop_id " +
			"order by a.create_time desc")
	@Results({
			@Result(column = "shop_name", property = "shopName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_title", property = "goodsTitle", jdbcType = JdbcType.VARCHAR),
			@Result(column = "openid", property = "openid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nickname", property = "nickname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ticket_code", property = "ticketCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "tid", property = "tid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "scan_code", property = "scanCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.VARCHAR)
	})
	List<VerifyLogModel> selectAllVerifyMessage();

	@Select("select c.shop_name, a.outer_item_id,a.goods_title, a.openid, b.nickname, a.ticket_code, a.tid, a.scan_code, a.create_time " +
			"from verify_log a LEFT JOIN staff_info b on a.openid = b.openid " +
			"left join shop_info c on b.shop_id = c.shop_id " +
			"where b.shop_id = #{shopId,jdbcType=VARCHAR} " +
			"order by a." +
			"create_time desc")
	@Results({
			@Result(column = "shop_name", property = "shopName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_title", property = "goodsTitle", jdbcType = JdbcType.VARCHAR),
			@Result(column = "openid", property = "openid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nickname", property = "nickname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ticket_code", property = "ticketCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "tid", property = "tid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "scan_code", property = "scanCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.VARCHAR)
	})
	List<VerifyLogModel> selectAllVerifyMessageByShopId(String shopId);
}
