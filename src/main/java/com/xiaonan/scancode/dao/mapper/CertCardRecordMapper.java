package com.xiaonan.scancode.dao.mapper;

import com.xiaonan.scancode.dao.CertCardInfo;
import com.xiaonan.scancode.dao.CertCardRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CertCardRecordMapper {

	@Insert("insert into cert_card_record " +
			"(serial_number,openid,create_time)" +
			"values(" +
			"#{serialNumber,jdbcType=VARCHAR}," +
			"#{openid,jdbcType=VARCHAR}," +
			"SUBSTR(date_format(now(3),'%Y-%m-%d %H:%i:%s:%f'),1,19)" +
			")")
	int insertByObject(CertCardRecord certCardRecord);


}
