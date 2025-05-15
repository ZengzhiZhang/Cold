package com.ruoyi.cold.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.cold.domain.WarehouseIn;
import com.ruoyi.cold.domain.WarehouseInWName;
import com.ruoyi.cold.domain.WarehouseOutWName;
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
import com.ruoyi.cold.domain.WarehouseOut;
import com.ruoyi.cold.service.IWarehouseOutService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库Controller
 * 
 * @author zzz
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/cold/warehouse_out")
public class WarehouseOutController extends BaseController
{
    @Autowired
    private IWarehouseOutService warehouseOutService;

    @PreAuthorize("@ss.hasPermi('cold:warehouse_out:list')")
    @GetMapping("/listWName")
    public TableDataInfo listWName(WarehouseOut warehouseOut)
    {
        startPage();
        List<WarehouseOutWName> list = warehouseOutService.selectWarehouseInWNameList(warehouseOut);
        return getDataTable(list);
    }
    /**
     * 查询出库列表
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_out:list')")
    @GetMapping("/list")
    public TableDataInfo list(WarehouseOut warehouseOut)
    {
        startPage();
        List<WarehouseOut> list = warehouseOutService.selectWarehouseOutList(warehouseOut);
        return getDataTable(list);
    }

    /**
     * 导出出库列表
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_out:export')")
    @Log(title = "出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WarehouseOut warehouseOut)
    {
        List<WarehouseOut> list = warehouseOutService.selectWarehouseOutList(warehouseOut);
        ExcelUtil<WarehouseOut> util = new ExcelUtil<WarehouseOut>(WarehouseOut.class);
        util.exportExcel(response, list, "出库数据");
    }

    /**
     * 获取出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_out:query')")
    @GetMapping(value = "/{warehouseOutId}")
    public AjaxResult getInfo(@PathVariable("warehouseOutId") Integer warehouseOutId)
    {
        return success(warehouseOutService.selectWarehouseOutByWarehouseOutId(warehouseOutId));
    }

    /**
     * 新增出库
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_out:add')")
    @Log(title = "出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WarehouseOut warehouseOut)
    {

        return toAjax(warehouseOutService.insertWarehouseOut(warehouseOut));
    }

    /**
     * 修改出库
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_out:edit')")
    @Log(title = "出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WarehouseOut warehouseOut)
    {
        return toAjax(warehouseOutService.updateWarehouseOut(warehouseOut));
    }

    /**
     * 删除出库
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_out:remove')")
    @Log(title = "出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseOutIds}")
    public AjaxResult remove(@PathVariable Integer[] warehouseOutIds)
    {
        return toAjax(warehouseOutService.deleteWarehouseOutByWarehouseOutIds(warehouseOutIds));
    }
}
