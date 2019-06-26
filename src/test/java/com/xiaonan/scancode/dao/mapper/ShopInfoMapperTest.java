package com.xiaonan.scancode.dao.mapper;

import com.xiaonan.scancode.dao.ShopInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShopInfoMapperTest {

	@Autowired ShopInfoMapper mapper;

	@Test
	public void selectAllShop() {
		List<ShopInfo> shopInfoList =mapper.selectAllShop();
		System.out.print(shopInfoList.size());
	}
}