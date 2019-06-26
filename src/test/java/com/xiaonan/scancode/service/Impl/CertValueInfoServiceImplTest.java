package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.CertValueInfo;
import com.xiaonan.scancode.dao.mapper.CertValueInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CertValueInfoServiceImplTest {
	@Autowired
	private CertValueInfoMapper mapper;

	@Test
	public void findCertValueInfo() {
		String a = "testalldzkq";
		CertValueInfo certValueInfo = mapper.selectByOuterItemId(a);
		System.out.println(certValueInfo.getOuterCertCardValue());
	}
}