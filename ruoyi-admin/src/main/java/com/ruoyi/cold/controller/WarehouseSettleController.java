package com.ruoyi.cold.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.cold.domain.*;
import com.ruoyi.cold.service.IWarehouseInService;
import com.ruoyi.cold.service.IWarehouseOutService;
import io.swagger.models.auth.In;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.cold.service.IWarehouseSettleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 结算Controller
 * 
 * @author zzz
 * @date 2025-05-15
 */
@RestController
@RequestMapping("/cold/warehouse_settle")
public class WarehouseSettleController extends BaseController
{
    @Autowired
    private IWarehouseSettleService warehouseSettleService;


    @Autowired
    private IWarehouseOutService warehouseOutService;

    @Autowired
    private IWarehouseInService warehouseInService;

    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:query')")
    @GetMapping("/getSettleByClientCategoryUnit")
    public Map<String,Object> getSettleByClientWareCategory(Integer ClientId,  String category,String unit){
        Map<String,Object> map = new HashMap<String,Object>();
        //查询当前用户某个品类的所有未结算单
        WarehouseOut warehouseOut = new WarehouseOut();
        warehouseOut.setWarehouseOutCategory(category);
        warehouseOut.setWarehouseOutUnit(unit);
        warehouseOut.setWarehouseOutClientId(ClientId);
        warehouseOut.setWarehouseOutSettle(0);
        List<WarehouseOutWName> outList = warehouseOutService.selectWarehouseInWNameList(warehouseOut);

        WarehouseIn warehouseIn = new WarehouseIn();
        warehouseIn.setWarehouseInCategory(category);
        warehouseIn.setWarehouseInUnit(unit);
        warehouseIn.setWarehouseInClient(ClientId);
        warehouseIn.setWarehouseInSettle(0);
        List<WarehouseInWName> inList = warehouseInService.selectWarehouseInWNameList(warehouseIn);

        //计算未结算单中所有的件数与钱数
        Double outTotalQuantity = outList.stream().mapToDouble(WarehouseOutWName::getWarehouseOutQuantity).sum();
//        Double outTotalPrice = outList.stream().mapToDouble(WarehouseOutWName::getWarehouseOutMoney).sum();
        Double outTotalMaiMoney = outList.stream().mapToDouble(out -> out.getWarehouseOutMoney() * out.getWarehouseOutQuantity()).sum();
        map.put("outTotalQuantity", outTotalQuantity);
//        map.put("outTotalPrice", outTotalPrice);
        map.put("outTotalMaiMoney", outTotalMaiMoney);
        map.put("outList", outList);
        map.put("outUnit", unit);

        Double inTotalQuantity = inList.stream().mapToDouble(WarehouseInWName::getWarehouseInQuantity).sum();
//        Double inTotalPrice = inList.stream().mapToDouble(WarehouseInWName::getWarehouseInPrice).sum();
        Double inTotalKuFei = inList.stream().mapToDouble(in -> in.getWarehouseInQuantity() * in.getWarehouseInPrice()).sum();
        map.put("inTotalQuantity", inTotalQuantity);
//        map.put("inTotalPrice", inTotalPrice);
        map.put("inTotalKuFei", inTotalKuFei);
        map.put("inUnit", unit);
        map.put("inList", inList);

        return map;
    }




    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:list')")
    @GetMapping("/listWName")
    public TableDataInfo listWName(WarehouseSettle warehouseSettle)
    {
        startPage();
        List<WarehouseSettleWName> list = warehouseSettleService.selectWarehouseSettleWNameList(warehouseSettle);
        return getDataTable(list);
    }
    /**
     * 查询结算列表
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:list')")
    @GetMapping("/list")
    public TableDataInfo list(WarehouseSettle warehouseSettle)
    {
        startPage();
        List<WarehouseSettle> list = warehouseSettleService.selectWarehouseSettleList(warehouseSettle);
        return getDataTable(list);
    }

    /**
     * 导出结算列表
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:export')")
    @Log(title = "结算", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WarehouseSettle warehouseSettle)
    {
        List<WarehouseSettle> list = warehouseSettleService.selectWarehouseSettleList(warehouseSettle);
        ExcelUtil<WarehouseSettle> util = new ExcelUtil<WarehouseSettle>(WarehouseSettle.class);
        util.exportExcel(response, list, "结算数据");
    }

    /**
     * 获取结算详细信息
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:query')")
    @GetMapping(value = "/{warehouseSettleId}")
    public AjaxResult getInfo(@PathVariable("warehouseSettleId") Integer warehouseSettleId)
    {
        return success(warehouseSettleService.selectWarehouseSettleByWarehouseSettleId(warehouseSettleId));
    }

    /**
     * 新增结算
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:add')")
    @Log(title = "结算", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WarehouseSettle warehouseSettle)
    {
        AjaxResult ajax = toAjax(warehouseSettleService.insertWarehouseSettle(warehouseSettle));
        return ajax;

    }

    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:edit')")
    @Log(title = "更新出入库单为已结算", businessType = BusinessType.UPDATE)
    @PostMapping("/updateInOut2Settle")
    public AjaxResult editInOut2Settle(@RequestBody Map<String, List<Integer>> request)
    {
        List<Integer> inIds = request.get("inIds");
        List<Integer> outIds = request.get("outIds");
//        System.out.println(inIds);

        int i = warehouseOutService.batchUpdateWarehouseOut2Settle(outIds);
        int j = warehouseInService.batchUpdateWarehouseIn2Settle(inIds);
        return AjaxResult.success(i+j);
    }

    /**
     * 修改结算
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:edit')")
    @Log(title = "结算", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WarehouseSettle warehouseSettle)
    {
        return toAjax(warehouseSettleService.updateWarehouseSettle(warehouseSettle));
    }

    /**
     * 删除结算
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_settle:remove')")
    @Log(title = "结算", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseSettleIds}")
    public AjaxResult remove(@PathVariable Integer[] warehouseSettleIds)
    {
        return toAjax(warehouseSettleService.deleteWarehouseSettleByWarehouseSettleIds(warehouseSettleIds));
    }
}
