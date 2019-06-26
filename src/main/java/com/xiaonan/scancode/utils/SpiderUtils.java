package com.xiaonan.scancode.utils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class SpiderUtils {

	public static List<String> roadMessage() {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.icauto.com.cn/gonglu/gaosu_c_130/").get();
		} catch (IOException e) {
			log.error("[请求路况信息异常]");
			e.printStackTrace();
		}
		Elements eContent = doc.getElementsByClass("content");
		Elements eTime = doc.getElementsByClass("updatetime");


		String[] key = new String[15];
		String s5 = new String();
		List<String> content = new ArrayList<>(16);


		for (int i = 0; i < 15; i++) {

			Element eTimeFor = eTime.get(i);
			key[i] = eTimeFor.text();


			if (i < 9) {
				s5 = key[i].substring(1, key[i].length());
				//System.out.println(s5);
				content.add(s5);
			} else {
				s5 = key[i].substring(2, key[i].length());
				//System.out.println(s5);
				content.add(s5);
			}

			Element eContentFor = eContent.get(i);
			String strContentFor = eContentFor.text();
			System.out.println(strContentFor);
			content.add(strContentFor);
		}
		return content;
	}

}
