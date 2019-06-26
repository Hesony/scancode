package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.CertValueInfo;
import com.xiaonan.scancode.dao.mapper.CertValueInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertValueInfoServiceImpl {

	@Autowired
	private CertValueInfoMapper mapper;

	/** 查询商品编码对应面值 */
	public List<CertValueInfo> findCertValueInfoList() {
		return mapper.select();
	}

	public CertValueInfo findCertValueInfo(String outerItemId) {
		return mapper.selectByOuterItemId(outerItemId);
	}

	/** 插入商品编码和对应面值 */
	public int addCertValueInfo(CertValueInfo certValueInfo) {
		return mapper.insertByObject(certValueInfo);
	}

	/** 通过商品编码删除商品编码和对应面值 */
	public int deleteCertValueInfo(String outerItemId) {
		return mapper.deleteByOuterItemId(outerItemId);
	}



}
