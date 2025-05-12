package com.ruoyi.cold.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.cold.domain.WarehouseStatus;
import com.ruoyi.cold.service.IWarehouseStatusService;
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

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存信息Controller
 *
 * @author ruoyi
 * @date 2025-05-12
 */
@RestController
@RequestMapping("/system/status")
public class WarehouseStatusController extends BaseController
{
    @Autowired
    private IWarehouseStatusService warehouseStatusService;

    /**
     * 查询库存信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:status:list')")
    @GetMapping("/list")
    public TableDataInfo list(WarehouseStatus warehouseStatus)
    {
        startPage();
        List<WarehouseStatus> list = warehouseStatusService.selectWarehouseStatusList(warehouseStatus);
        return getDataTable(list);
    }

    /**
     * 导出库存信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:status:export')")
    @Log(title = "库存信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WarehouseStatus warehouseStatus)
    {
        List<WarehouseStatus> list = warehouseStatusService.selectWarehouseStatusList(warehouseStatus);
        ExcelUtil<WarehouseStatus> util = new ExcelUtil<WarehouseStatus>(WarehouseStatus.class);
        util.exportExcel(response, list, "库存信息数据");
    }

    /**
     * 获取库存信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:status:query')")
    @GetMapping(value = "/{warehouseId}")
    public AjaxResult getInfo(@PathVariable("warehouseId") Long warehouseId)
    {
        return success(warehouseStatusService.selectWarehouseStatusByWarehouseId(warehouseId));
    }

    /**
     * 新增库存信息
     */
    @PreAuthorize("@ss.hasPermi('system:status:add')")
    @Log(title = "库存信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WarehouseStatus warehouseStatus)
    {
        return toAjax(warehouseStatusService.insertWarehouseStatus(warehouseStatus));
    }

    /**
     * 修改库存信息
     */
    @PreAuthorize("@ss.hasPermi('system:status:edit')")
    @Log(title = "库存信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WarehouseStatus warehouseStatus)
    {
        return toAjax(warehouseStatusService.updateWarehouseStatus(warehouseStatus));
    }

    /**
     * 删除库存信息
     */
    @PreAuthorize("@ss.hasPermi('system:status:remove')")
    @Log(title = "库存信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{warehouseIds}")
    public AjaxResult remove(@PathVariable Long[] warehouseIds)
    {
        return toAjax(warehouseStatusService.deleteWarehouseStatusByWarehouseIds(warehouseIds));
    }
}
