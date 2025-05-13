package com.ruoyi.cold.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.cold.domain.WarehouseInWName;
import com.ruoyi.cold.service.IClientInfoService;
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
import com.ruoyi.cold.domain.WarehouseIn;
import com.ruoyi.cold.service.IWarehouseInService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入库Controller
 * 
 * @author zzz
 * @date 2025-05-12
 */
@RestController
@RequestMapping("/cold/warehouse_in")
public class WarehouseInController extends BaseController
{
    @Autowired
    private IWarehouseInService warehouseInService;


    @PreAuthorize("@ss.hasPermi('cold:warehouse_in:list')")
    @GetMapping("/listWName")
    public TableDataInfo listWName(WarehouseIn warehouseIn)
    {
        startPage();
        List<WarehouseInWName> list = warehouseInService.selectWarehouseInWNameList(warehouseIn);
        return getDataTable(list);
    }

    /**
     * 查询入库列表
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_in:list')")
    @GetMapping("/list")
    public TableDataInfo list(WarehouseIn warehouseIn)
    {
        startPage();
        List<WarehouseIn> list = warehouseInService.selectWarehouseInList(warehouseIn);
        return getDataTable(list);
    }

    /**
     * 导出入库列表
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_in:export')")
    @Log(title = "入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WarehouseIn warehouseIn)
    {
        List<WarehouseIn> list = warehouseInService.selectWarehouseInList(warehouseIn);
        ExcelUtil<WarehouseIn> util = new ExcelUtil<WarehouseIn>(WarehouseIn.class);
        util.exportExcel(response, list, "入库数据");
    }

    /**
     * 获取入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_in:query')")
    @GetMapping(value = "/{warehouseInId}")
    public AjaxResult getInfo(@PathVariable("warehouseInId") Integer warehouseInId)
    {
        return success(warehouseInService.selectWarehouseInByWarehouseInId(warehouseInId));
    }

    /**
     * 新增入库
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_in:add')")
    @Log(title = "入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WarehouseIn warehouseIn)
    {
        return toAjax(warehouseInService.insertWarehouseIn(warehouseIn));
    }

    /**
     * 修改入库
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_in:edit')")
    @Log(title = "入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WarehouseIn warehouseIn)
    {
        return toAjax(warehouseInService.updateWarehouseIn(warehouseIn));
    }

    /**
     * 删除入库
     */
    @PreAuthorize("@ss.hasPermi('cold:warehouse_in:remove')")
    @Log(title = "入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseInIds}")
    public AjaxResult remove(@PathVariable Integer[] warehouseInIds)
    {
        return toAjax(warehouseInService.deleteWarehouseInByWarehouseInIds(warehouseInIds));
    }
}
