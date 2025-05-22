package com.ruoyi.cold.service.impl;

import java.util.Collections;
import java.util.List;

import com.ruoyi.cold.domain.WarehouseIn;
import com.ruoyi.cold.domain.WarehouseInWName;
import com.ruoyi.cold.domain.WarehouseOutWName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cold.mapper.WarehouseOutMapper;
import com.ruoyi.cold.domain.WarehouseOut;
import com.ruoyi.cold.service.IWarehouseOutService;

/**
 * 出库Service业务层处理
 * 
 * @author zzz
 * @date 2025-05-13
 */
@Service
public class WarehouseOutServiceImpl implements IWarehouseOutService
{
    @Autowired
    private WarehouseOutMapper warehouseOutMapper;

    /**
     * 查询出库
     * 
     * @param warehouseOutId 出库主键
     * @return 出库
     */
    @Override
    public WarehouseOut selectWarehouseOutByWarehouseOutId(Integer warehouseOutId)
    {
        return warehouseOutMapper.selectWarehouseOutByWarehouseOutId(warehouseOutId);
    }

    /**
     * 查询出库列表
     * 
     * @param warehouseOut 出库
     * @return 出库
     */
    @Override
    public List<WarehouseOut> selectWarehouseOutList(WarehouseOut warehouseOut)
    {
        return warehouseOutMapper.selectWarehouseOutList(warehouseOut);
    }

    /**
     * 新增出库
     * 
     * @param warehouseOut 出库
     * @return 结果
     */
    @Override
    public int insertWarehouseOut(WarehouseOut warehouseOut)
    {
        return warehouseOutMapper.insertWarehouseOut(warehouseOut);
    }

    @Override
    public int batchUpdateWarehouseOut2Settle(List<Integer> warehouseOutIds) {
        int i = warehouseOutMapper.batchUpdateOut2Settle(warehouseOutIds);
        return i;
    }

    /**
     * 修改出库
     * 
     * @param warehouseOut 出库
     * @return 结果
     */
    @Override
    public int updateWarehouseOut(WarehouseOut warehouseOut)
    {
        return warehouseOutMapper.updateWarehouseOut(warehouseOut);
    }

    /**
     * 批量删除出库
     * 
     * @param warehouseOutIds 需要删除的出库主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseOutByWarehouseOutIds(Integer[] warehouseOutIds)
    {
        return warehouseOutMapper.deleteWarehouseOutByWarehouseOutIds(warehouseOutIds);
    }

    /**
     * 删除出库信息
     * 
     * @param warehouseOutId 出库主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseOutByWarehouseOutId(Integer warehouseOutId)
    {
        return warehouseOutMapper.deleteWarehouseOutByWarehouseOutId(warehouseOutId);
    }

    @Override
    public List<WarehouseOutWName> selectWarehouseInWNameList(WarehouseOut warehouseOut) {

            return warehouseOutMapper.selectWarehouseOutWNameList(warehouseOut);

    }
}
