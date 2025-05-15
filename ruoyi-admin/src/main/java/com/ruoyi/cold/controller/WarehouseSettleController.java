package com.ruoyi.cold.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.cold.domain.WarehouseOut;
import com.ruoyi.cold.domain.WarehouseOutWName;
import com.ruoyi.cold.domain.WarehouseSettleWName;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.cold.domain.WarehouseSettle;
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
        return toAjax(warehouseSettleService.insertWarehouseSettle(warehouseSettle));
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
