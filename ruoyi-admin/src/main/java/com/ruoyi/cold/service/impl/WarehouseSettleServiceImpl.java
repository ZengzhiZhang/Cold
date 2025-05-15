package com.ruoyi.cold.service.impl;

import java.util.Collections;
import java.util.List;

import com.ruoyi.cold.domain.WarehouseSettleWName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cold.mapper.WarehouseSettleMapper;
import com.ruoyi.cold.domain.WarehouseSettle;
import com.ruoyi.cold.service.IWarehouseSettleService;

/**
 * 结算Service业务层处理
 * 
 * @author zzz
 * @date 2025-05-15
 */
@Service
public class WarehouseSettleServiceImpl implements IWarehouseSettleService 
{
    @Autowired
    private WarehouseSettleMapper warehouseSettleMapper;

    /**
     * 查询结算
     * 
     * @param warehouseSettleId 结算主键
     * @return 结算
     */
    @Override
    public WarehouseSettle selectWarehouseSettleByWarehouseSettleId(Integer warehouseSettleId)
    {
        return warehouseSettleMapper.selectWarehouseSettleByWarehouseSettleId(warehouseSettleId);
    }

    /**
     * 查询结算列表
     * 
     * @param warehouseSettle 结算
     * @return 结算
     */
    @Override
    public List<WarehouseSettle> selectWarehouseSettleList(WarehouseSettle warehouseSettle)
    {
        return warehouseSettleMapper.selectWarehouseSettleList(warehouseSettle);
    }

    /**
     * 新增结算
     * 
     * @param warehouseSettle 结算
     * @return 结果
     */
    @Override
    public int insertWarehouseSettle(WarehouseSettle warehouseSettle)
    {
        return warehouseSettleMapper.insertWarehouseSettle(warehouseSettle);
    }

    /**
     * 修改结算
     * 
     * @param warehouseSettle 结算
     * @return 结果
     */
    @Override
    public int updateWarehouseSettle(WarehouseSettle warehouseSettle)
    {
        return warehouseSettleMapper.updateWarehouseSettle(warehouseSettle);
    }

    /**
     * 批量删除结算
     * 
     * @param warehouseSettleIds 需要删除的结算主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseSettleByWarehouseSettleIds(Integer[] warehouseSettleIds)
    {
        return warehouseSettleMapper.deleteWarehouseSettleByWarehouseSettleIds(warehouseSettleIds);
    }

    /**
     * 删除结算信息
     * 
     * @param warehouseSettleId 结算主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseSettleByWarehouseSettleId(Integer warehouseSettleId)
    {
        return warehouseSettleMapper.deleteWarehouseSettleByWarehouseSettleId(warehouseSettleId);
    }

    @Override
    public List<WarehouseSettleWName> selectWarehouseSettleWNameList(WarehouseSettle warehouseSettle) {
        return warehouseSettleMapper.selectWarehouseSettleWNameList(warehouseSettle);
    }
}
