package com.xiaonan.scancode.dao.mapper;

import com.xiaonan.scancode.dao.CertCardInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


public interface CertCardInfoMapper {

	@Insert("insert into cert_card_info " +
			"(serial_number,redeem_code,value,create_time,validity,is_send)" +
			"values(" +
			"#{serialNumber,jdbcType=VARCHAR}," +
			"#{redeemCode,jdbcType=VARCHAR}," +
			"#{value,jdbcType=VARCHAR}," +
			"#{createTime,jdbcType=VARCHAR}," +
			"#{validity,jdbcType=VARCHAR}," +
			"#{isSend,jdbcType=VARCHAR}," +
			")")
	int insertByObject(CertCardInfo staffInfo);

	@Update("update cert_card_info set " +
			"is_send = #{isSend,jdbcType=VARCHAR} " +
			"where serial_number=#{serialNumber,jdbcType=VARCHAR}"
	)
	void update(CertCardInfo staffInfo);

	/**
	 * 查询未消费卡密
	 * @return
	 */
	@Select("select serial_number,redeem_code,value,create_time,validity,is_send from " +
			"cert_card_info " +
			"where is_send = \'N\'"
	)
	@Results({
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "redeem_code", property = "redeemCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validity", property = "validity", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_send", property = "isSend", jdbcType = JdbcType.VARCHAR),
	}
	)
	List<CertCardInfo> selectNotSendList();

	/**
	 * 查询未消费卡密
	 * @return
	 */
	@Select("select serial_number,redeem_code,value,create_time,validity,is_send from " +
			"cert_card_info " +
			"where is_send = \'N\' " +
			"and value = #{value, jdbcType=VARCHAR}"
	)
	@Results({
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "redeem_code", property = "redeemCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validity", property = "validity", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_send", property = "isSend", jdbcType = JdbcType.VARCHAR),
	}
	)
	List<CertCardInfo> selectNotSendListByValue(String value);

	@Delete("delete from cert_card_info " +
			"where serial_number=#{serialNumber,jdbcType=VARCHAR}")
	int delete(String serialNumber);
}
