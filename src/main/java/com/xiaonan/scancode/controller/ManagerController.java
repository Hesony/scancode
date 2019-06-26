package com.xiaonan.scancode.controller;

import com.xiaonan.scancode.dao.CertCardInfo;
import com.xiaonan.scancode.dao.CertValueInfo;
import com.xiaonan.scancode.dao.ShopCommodity;
import com.xiaonan.scancode.dao.ShopInfo;
import com.xiaonan.scancode.model.models.ResultVO;
import com.xiaonan.scancode.model.models.ShopCommodityModel;
import com.xiaonan.scancode.model.models.StaffModel;
import com.xiaonan.scancode.model.models.VerifyLogModel;
import com.xiaonan.scancode.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

	@Autowired
	private ShopServiceImpl shopService;
	@Autowired
	private StaffServiceImpl staffService;
	@Autowired
	private VerifyLogServiceImpl verifyLogService;
	@Autowired
	private ShopCommodityServiceImpl shopCommodityService;
	@Autowired
	private CertValueInfoServiceImpl certValueInfoService;
	@Autowired
	private CertCardInfoServiceImpl certCardInfoService;
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index() {
		return "manager/index";
	}

	/**
	 * 店铺信息列表页面
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/shoplist")
	public String shoplist(Model model, Map<String, Object> map) {
		List<ShopInfo> shopInfoList = shopService.shoplist();
		map.put("shopInfoList", shopInfoList);
		model.addAllAttributes(map);
		return "manager/shoplist";
	}

	/**
	 * 新增店铺
	 * @return
	 */
	@RequestMapping(value = "/addshop")
	public String addshop() {
		return "manager/addshop";
	}
	@RequestMapping(value = "addshopdetail")
	public String addshopdetail(@RequestParam("shopname") String shopName,
								Model model, Map<String, Object> map) {
		shopService.addshop(shopName);
		map.put("msg","插入店铺成功");
		model.addAllAttributes(map);
		return "manager/success";
	}

	/**
	 * 删除店铺
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "deleteshop")
	public String deleteshop(@RequestParam("shopid") String shopId,
								Model model, Map<String, Object> map) {
		shopService.deleteshop(shopId);
		map.put("msg","删除店铺成功");
		model.addAllAttributes(map);
		return "manager/success";
	}


	/**
	 * 核销员审核页面
	 */
	@RequestMapping(value = "staffcheck")
	public String staffcheck(Model model, Map<String, Object> map) {
		List<StaffModel> staffModels = staffService.selectAllStaff();
		map.put("stafflist", staffModels);
		model.addAllAttributes(map);
		return "manager/staffchecklist";
	}

	/**
	 * 核销员审核页面2
	 */
	@RequestMapping(value = "/checkverify")
	public String checkverify(@RequestParam("openid") String openid,
							  Model model, Map<String, Object> map) {
		map.put("openid", openid);
		model.addAllAttributes(map);
		return "manager/checkverify";
	}
	@RequestMapping(value = "checkverifyupdate")
	public String checkverifyupdate(@RequestParam("staff") String staff,
									@RequestParam("openid") String openid,
								Model model, Map<String, Object> map) {

		staffService.updateVerifyMessage(openid, staff);
		map.put("msg","审核成功");
		model.addAllAttributes(map);
		return "manager/success";
	}

	/**
	 * 电子券核销记录页面
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/verifycodelist")
	public String verifycodelist(Model model, Map<String, Object> map) {
		List<VerifyLogModel> verifyLogList = verifyLogService.selectAllVerifyLog();
		map.put("verifyloglist", verifyLogList);
		model.addAllAttributes(map);
		return "manager/verifycodelist";
	}

	/**
	 * 删除核销员
	 * @param openid
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/deleteverify")
	public String deleteverify(@RequestParam("openid") String openid,
							   Model model, Map<String, Object> map) {
		staffService.deleteVerifyMessage(openid);
		map.put("msg","删除核销员成功");
		model.addAllAttributes(map);
		return "manager/success";
	}

	/**
	 * 商品编码列表
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/commoditylist")
	public String commoditylist(Model model, Map<String, Object> map) {
		List<ShopCommodityModel> list = shopCommodityService.selectAllShopCommodityModel();
		map.put("list", list);
		model.addAllAttributes(map);
		return "manager/commoditylist";
	}

	/**
	 * 新增商品编码
	 * @return
	 */
	@RequestMapping(value = "/addcommodity")
	public String addcommodity() {
		return "manager/addcommodity";
	}
	@RequestMapping(value = "/addcommoditydetail")
	public String addcommoditydetail(@RequestParam("outerItemId") String outerItemId,
									 @RequestParam("goodsTitle") String goodsTitle,
									 @RequestParam("shopname") String shopname,
									 Model model, Map<String, Object> map) {
		ResultVO resultVO = shopCommodityService.addShopCommodity(shopname, outerItemId, goodsTitle);
		map.put("msg", resultVO.getMsg());
		if ("001".equals(resultVO.getCode())) {
			return "manager/error";
		}
		return "manager/success";
	}

	@GetMapping(value = "/deletecommodity")
	public String deletecommodity(@RequestParam("outerItemId") String outerItemId,
								  Model model, Map<String, Object> map) {
		shopCommodityService.deleteShopCommodity(outerItemId);
		map.put("msg", "删除商品成功");
		model.addAllAttributes(map);
		return "manager/success";
	}


	/**
	 * 查询商品编码与卡密面值对应列表
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/certvaluelist")
	public String certvaluelist(Model model, Map<String, Object> map) {
		List<CertValueInfo> list = certValueInfoService.findCertValueInfoList();
		map.put("list", list);
		model.addAllAttributes(map);
		return "manager/certvaluelist";
	}
	@RequestMapping(value = "/addcertvalue")
	public String addcertvalue() {
		return "manager/addcertvalue";
	}
	@RequestMapping(value = "/addcertvaluedetail")
	public String addcertvaluedetail(@RequestParam("outerItemId") String outerItemId,
									 @RequestParam("outerCertCardValue") String outerCertCardValue,
									 Model model, Map<String, Object> map) {
		CertValueInfo certValueInfo = new CertValueInfo();
		certValueInfo.setOuterItemId(outerItemId);
		certValueInfo.setOuterCertCardValue(outerCertCardValue);
		try {
			certValueInfoService.addCertValueInfo(certValueInfo);
			map.put("msg", "新增商品编码对应卡密面值成功");
			return "manager/success";
		} catch (Exception e) {
			map.put("msg", "新增商品编码对应卡密面值失败,详情查看日志");
			return "manager/error";
		}
	}
	@GetMapping(value = "/deletecertvalue")
	public String deletecertvalue(@RequestParam("outerItemId") String outerItemId,
								  Model model, Map<String, Object> map) {
		certValueInfoService.deleteCertValueInfo(outerItemId);
		map.put("msg", "删除商品编码对应卡密面值成功");
		model.addAllAttributes(map);
		return "manager/success";
	}

	/**
	 * 查询未消费卡密列表
	 */
	@RequestMapping(value = "/certcardinfolist")
	public String certcardinfolist(Model model, Map<String, Object> map) {
		List<CertCardInfo> list = certCardInfoService.findCertValueInfoList();
		map.put("list", list);
		model.addAllAttributes(map);
		return "manager/certcardinfolist";
	}
	@RequestMapping(value = "/addcertcardinfo")
	public String addcertcardinfo() {
		return "manager/addcertcardinfo";
	}
	@RequestMapping(value = "/addcertcardinfodetail")
	public String addcertcardinfodetail(@RequestParam("certcardinfo") String certcardinfo,
									 Model model, Map<String, Object> map) {

		try {
			map.put("msg", "新增商品编码对应卡密面值成功");
			return "manager/success";
		} catch (Exception e) {
			map.put("msg", "新增商品编码对应卡密面值失败,详情查看日志");
			return "manager/error";
		}
	}

	@GetMapping(value = "/deletecertcardinfo")
	public String deletecertcardinfo(@RequestParam("serialNumber") String serialNumber,
								  Model model, Map<String, Object> map) {
		certCardInfoService.deleteCertCardInfo(serialNumber);
		map.put("msg", "删除卡密成功");
		model.addAllAttributes(map);
		return "manager/success";
	}

}
