package com.xiaonan.scancode.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xiaonan.scancode.scheduleJob.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/road")
public class RoadMessageController {

	@RequestMapping(value = "/yuncheng")
	public String index(Model model, Map<String, Object> map) {

		List<String> roadList = ScheduleTask.getRoadContent();
		List<String> time = new ArrayList<>(16);
		List<String> content = new ArrayList<>(16);
		for (int i = 0; i < roadList.size(); i++) {
			if (i % 2 == 0) {
				time.add(roadList.get(i));
			} else content.add(roadList.get(i));
		}
		map.put("timeList", time);
		map.put("contentList", content);
		map.put("roadList", roadList);
		model.addAllAttributes(map);
		return "road/roadlist";
	}
}
