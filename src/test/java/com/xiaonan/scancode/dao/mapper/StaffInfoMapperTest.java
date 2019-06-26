package com.xiaonan.scancode.dao.mapper;

import com.xiaonan.scancode.model.models.StaffModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StaffInfoMapperTest {

	@Autowired
	private StaffInfoMapper mapper;

	@Test
	public void selectAllStaff() {

		List<StaffModel> staffModels = mapper.selectAllStaff();
		for (StaffModel staffModel: staffModels) {
			System.out.println(staffModel.getOpenid());
		}
	}
}