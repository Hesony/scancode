package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.CertCardInfo;
import com.xiaonan.scancode.dao.CertValueInfo;
import com.xiaonan.scancode.dao.mapper.CertCardInfoMapper;
import com.xiaonan.scancode.dao.mapper.CertValueInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertCardInfoServiceImpl {

	@Autowired
	private CertCardInfoMapper mapper;

	/**
	 * 查询未发送卡密
	 */
	public List<CertCardInfo> findCertValueInfoList() {
		return mapper.selectNotSendList();
	}

	/**
	 * 插入卡密
	 */
	public int addCertCardInfo(CertCardInfo certCardInfo) {
		return mapper.insertByObject(certCardInfo);
	}

	/**
	 * 删除卡密
	 */
	public int deleteCertCardInfo(String serialNumber) {
		return mapper.delete(serialNumber);
	}

	public void addCertValueInfo(String certcardinfo) {
		String[] split = certcardinfo.split("\\n");
		for (String info: split) {
			CertCardInfo certCardInfo = new CertCardInfo();
			if ("".equals(info)) {
				String[] cert = info.split(",");
				certCardInfo.setSerialNumber(cert[0]);
				certCardInfo.setRedeemCode(cert[1]);
				certCardInfo.setValue(cert[2]);
				certCardInfo.setCreateTime(cert[3]);
				certCardInfo.setValidity(cert[4]);
				certCardInfo.setIsSend("N");
				mapper.insertByObject(certCardInfo);
			}

		}
	}

}
