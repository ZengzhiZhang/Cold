package com.ruoyi.cold.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.cold.domain.ClientInfo;
import com.ruoyi.cold.service.IClientInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author zzz
 * @date 2025-05-11
 */
@RestController
@RequestMapping("/cold/client")
public class ClientInfoController extends BaseController
{
    @Autowired
    private IClientInfoService clientInfoService;

    @PreAuthorize("@ss.hasPermi('cold:client:list')")
    @GetMapping("/listByIds")
    public List<ClientInfo> getClientsByIds(List<Integer> clientIds) {
        return clientInfoService.selectClientsByIds(clientIds);
    }


    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('cold:client:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClientInfo clientInfo)
    {
        startPage();
        List<ClientInfo> list = clientInfoService.selectClientInfoList(clientInfo);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('cold:client:export')")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClientInfo clientInfo)
    {
        List<ClientInfo> list = clientInfoService.selectClientInfoList(clientInfo);
        ExcelUtil<ClientInfo> util = new ExcelUtil<ClientInfo>(ClientInfo.class);
        util.exportExcel(response, list, "客户信息数据");
    }

    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('cold:client:query')")
    @GetMapping(value = "/{clientInfoId}")
    public AjaxResult getInfo(@PathVariable("clientInfoId") Long clientInfoId)
    {
        return success(clientInfoService.selectClientInfoByClientInfoId(clientInfoId));
    }

    /**
     * 新增客户信息
     */
    @PreAuthorize("@ss.hasPermi('cold:client:add')")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClientInfo clientInfo)
    {
        return toAjax(clientInfoService.insertClientInfo(clientInfo));
    }

    /**
     * 修改客户信息
     */
    @PreAuthorize("@ss.hasPermi('cold:client:edit')")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClientInfo clientInfo)
    {
        return toAjax(clientInfoService.updateClientInfo(clientInfo));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('cold:client:remove')")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{clientInfoIds}")
    public AjaxResult remove(@PathVariable Long[] clientInfoIds)
    {
        return toAjax(clientInfoService.deleteClientInfoByClientInfoIds(clientInfoIds));
    }
}
