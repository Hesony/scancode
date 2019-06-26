package com.xiaonan.scancode.dao.mapper;

import com.xiaonan.scancode.dao.CertValueInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface CertValueInfoMapper {

	@Insert("insert into cert_value_info " +
			"(outer_item_id, outer_cert_card_value)" +
			"values(" +
			"#{outerItemId,jdbcType=VARCHAR}," +
			"#{outerCertCardValue,jdbcType=VARCHAR}" +
			")")
	int insertByObject(CertValueInfo certValueInfo);


	@Delete("delete from cert_value_info " +
			"where " +
			"outer_item_id = #{outerItemId,jdbcType=VARCHAR}"
	)
	int deleteByOuterItemId(String outerItemId);

	@Select("select " +
			"outer_item_id, outer_cert_card_value " +
			"from cert_value_info"
	)
	@Results({
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_cert_card_value", property = "outerCertCardValue", jdbcType = JdbcType.VARCHAR),
	})
	List<CertValueInfo> select();

	@Select("select " +
			"outer_item_id, outer_cert_card_value " +
			"from cert_value_info " +
			"where outer_item_id = #{outerItemId,jdbcType=VARCHAR}"
	)
	@Results({
			@Result(column = "outer_item_id", property = "outerItemId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outer_cert_card_value", property = "outerCertCardValue", jdbcType = JdbcType.VARCHAR),
	})
	CertValueInfo selectByOuterItemId(String outerItemId);
}
